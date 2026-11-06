package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.remote.service.TurmaProfessorApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.model.Turma
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import retrofit2.HttpException
import java.io.IOException

class ProfessorApiTurmaRepositoryImpl(
    private val api: TurmaProfessorApi
) : ProfessorTurmaRepository {

    override suspend fun listar(): Result<List<Turma>> {
        return runCatching {
            api.listarTurmas().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar turmas (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar turmas.")
            }
        }
    }
}