package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.remote.dto

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularDto(
    val id: String,
    val nome: String,
    val professor: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val faltas: Int
) {

    fun toDomain(): com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular {
        return _root_ide_package_.com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular(
            id = id,
            nome = nome,
            professor = professor,
            nota1 = nota1,
            nota2 = nota2,
            media = media,
            faltas = faltas
        )
    }
}