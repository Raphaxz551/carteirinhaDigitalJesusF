package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model

data class ProfessorUnidadeCurricular(
    val id: String,
    val nome: String,
    val turmaId: String,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)