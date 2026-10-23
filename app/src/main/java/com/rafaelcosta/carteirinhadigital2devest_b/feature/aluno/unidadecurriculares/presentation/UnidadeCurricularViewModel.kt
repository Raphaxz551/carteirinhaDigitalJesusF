package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UnidadeCurricularViewModel(
    private val repository : com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(_root_ide_package_.com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation.UnidadeCurricularUiState())
    val uiState:StateFlow<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation.UnidadeCurricularUiState> = _uiState.asStateFlow()
    fun carregar() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            repository.listar()
                .onSuccess { unidades ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            unidades = unidades,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Erro ao carregar unidades curriculares."
                        )
                    }
                }
        }
    }
}