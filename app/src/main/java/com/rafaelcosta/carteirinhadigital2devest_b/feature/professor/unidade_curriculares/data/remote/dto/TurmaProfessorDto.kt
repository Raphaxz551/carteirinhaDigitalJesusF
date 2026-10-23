package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.data.remote.dto

class TurmaProfessorDto (
    val id: Int,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)