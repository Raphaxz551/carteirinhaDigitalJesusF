package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfessorUnidadeCurricularViewModel(
    private val repository: ProfessorUnidadeCurricularRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfessorUnidadeCurricularUiState())
    val uiState: StateFlow<ProfessorUnidadeCurricularUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            repository.listar()
                .onSuccess { unidades ->
                    _uiState.update {
                        it.copy(isLoading = false, unidades = unidades, errorMessage = null)
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message
                                ?: "Erro ao carregar unidades curriculares."
                        )
                    }
                }
        }
    }
}