package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.ProfessorUnidadeCurricular

interface ProfessorUnidadeCurricularRepository {
    suspend fun listar(): Result<List<ProfessorUnidadeCurricular>>
}