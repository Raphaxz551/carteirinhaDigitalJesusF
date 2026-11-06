package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen.ProfessorUnidadeCurricularViewModel

class ProfessorUnidadeCurricularViewModelFactory(
    private val repository: ProfessorUnidadeCurricularRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfessorUnidadeCurricularViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfessorUnidadeCurricularViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}