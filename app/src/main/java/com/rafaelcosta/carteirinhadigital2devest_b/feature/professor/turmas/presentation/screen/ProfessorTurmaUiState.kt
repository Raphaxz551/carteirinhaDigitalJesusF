package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.screen

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.model.Turma

data class ProfessorTurmaUiState(
    val isLoading: Boolean = true,
    val turmas: List<Turma> = emptyList(),
    val errorMessage: String? = null
)