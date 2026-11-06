package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.service.UnidadeCurricularProfessorApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.ProfessorUnidadeCurricular
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository
import retrofit2.HttpException
import java.io.IOException

class ProfessorApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularProfessorApi
) : ProfessorUnidadeCurricularRepository {

    override suspend fun listar(): Result<List<ProfessorUnidadeCurricular>> {
        return runCatching {
            api.listarUnidadesCurriculares().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}