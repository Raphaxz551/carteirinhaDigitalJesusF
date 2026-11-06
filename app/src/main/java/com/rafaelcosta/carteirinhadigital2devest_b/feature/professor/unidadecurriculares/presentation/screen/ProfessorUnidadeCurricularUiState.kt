package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.ProfessorUnidadeCurricular

data class ProfessorUnidadeCurricularUiState(
    val isLoading: Boolean = true,
    val unidades: List<ProfessorUnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)