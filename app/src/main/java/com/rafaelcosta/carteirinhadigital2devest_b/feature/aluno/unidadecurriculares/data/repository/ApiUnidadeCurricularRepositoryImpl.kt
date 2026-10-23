package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import retrofit2.HttpException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularApi
) : com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository {

    override suspend fun listar(): Result<List<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular>> {
        return runCatching {
            api.listar().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is java.io.IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}