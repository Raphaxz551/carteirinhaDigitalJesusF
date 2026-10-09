package com.rafaelcosta.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation

import com.rafaelcosta.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)