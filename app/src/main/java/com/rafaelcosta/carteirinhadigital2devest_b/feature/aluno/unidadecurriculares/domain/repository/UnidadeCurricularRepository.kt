package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular>>
}