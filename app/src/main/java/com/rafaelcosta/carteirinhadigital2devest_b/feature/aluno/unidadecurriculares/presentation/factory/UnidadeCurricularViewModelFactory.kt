package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UnidadeCurricularViewModelFactory(
    private val repository: com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(_root_ide_package_.com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation.UnidadeCurricularViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return _root_ide_package_.com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation.UnidadeCurricularViewModel(
                repository = repository
            ) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}