package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.remote.service

import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.data.remote.dto.TurmaProfessorDto
import retrofit2.http.GET

interface TurmaProfessorApi {

    @GET("professores/me/turmas")
    suspend fun listarTurmas(): List<TurmaProfessorDto>
}