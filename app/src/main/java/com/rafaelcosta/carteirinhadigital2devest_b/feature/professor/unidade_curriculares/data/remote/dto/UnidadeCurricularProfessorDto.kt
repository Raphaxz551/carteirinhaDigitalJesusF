package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.dto

data class UnidadeCurricularProfessorDto(
    val id: Int,
    val nome: String,
    val turmaId: Int,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)