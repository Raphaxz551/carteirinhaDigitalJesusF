package com.rafaelcosta.carteirinhadigital2devest_b.app.di

import com.rafaelcosta.carteirinhadigital2devest.feature.login.domain.repository.LoginRepository
import com.rafaelcosta.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
    val professorTurmaRepository: ProfessorTurmaRepository
    val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository
}