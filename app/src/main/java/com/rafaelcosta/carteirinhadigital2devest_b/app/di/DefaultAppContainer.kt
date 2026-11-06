package com.rafaelcosta.carteirinhadigital2devest_b.app.di

import com.rafaelcosta.carteirinhadigital2devest.feature.login.domain.repository.LoginRepository
import com.rafaelcosta.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.rafaelcosta.carteirinhadigital2devest_b.core.network.NetworkClient
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.remote.service.AuthApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.repository.ApiLoginRepositoryImpl
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.repository.FakeAuthRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.remote.service.TurmaProfessorApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.repository.ProfessorApiTurmaRepositoryImpl
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.service.UnidadeCurricularProfessorApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.repository.ProfessorApiUnidadeCurricularRepositoryImpl
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository


class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()

    private val networkClient = NetworkClient(
        baseUrl = BASE_URL,
        sessionTokenStore = sessionTokenStore
    )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularApi::class.java)
    }

    private val turmaProfessorApi: TurmaProfessorApi by lazy {
        networkClient.createAuthenticated(TurmaProfessorApi::class.java)
    }

    private val unidadeCurricularProfessorApi: UnidadeCurricularProfessorApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularProfessorApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }

    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }

    override val professorTurmaRepository: ProfessorTurmaRepository by lazy {
        ProfessorApiTurmaRepositoryImpl(api = turmaProfessorApi)
    }

    override val professorUnidadeCurricularRepository: ProfessorUnidadeCurricularRepository by lazy {
        ProfessorApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularProfessorApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}