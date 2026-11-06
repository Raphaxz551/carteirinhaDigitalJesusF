package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.model

data class Turma(
    val id: Int,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)