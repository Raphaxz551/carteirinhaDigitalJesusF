package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.screen.ProfessorTurmaViewModel

class ProfessorTurmaViewModelFactory(
    private val repository: ProfessorTurmaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfessorTurmaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfessorTurmaViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}