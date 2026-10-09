package com.rafaelcosta.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}