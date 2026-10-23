package com.rafaelcosta.carteirinhadigital2devest_b.app.di

import com.rafaelcosta.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: com.rafaelcosta.carteirinhadigital2devest.feature.login.domain.repository.LoginRepository
    val unidadeCurricularRepository: com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
}
