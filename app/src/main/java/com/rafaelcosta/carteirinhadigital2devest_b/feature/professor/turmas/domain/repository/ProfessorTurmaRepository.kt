package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.model.Turma

interface ProfessorTurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}