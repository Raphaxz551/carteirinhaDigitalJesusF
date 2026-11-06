package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfessorTurmaViewModel(
    private val repository: ProfessorTurmaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfessorTurmaUiState())
    val uiState: StateFlow<ProfessorTurmaUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            repository.listar()
                .onSuccess { turmas ->
                    _uiState.update {
                        it.copy(isLoading = false, turmas = turmas, errorMessage = null)
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar turmas."
                        )
                    }
                }
        }
    }
}