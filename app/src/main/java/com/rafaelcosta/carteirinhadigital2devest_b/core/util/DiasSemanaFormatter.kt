package com.rafaelcosta.carteirinhadigital2devest_b.core.util

fun List<String>.formatarDiasSemana(): String {
    return joinToString(", ") { dia ->
        dia.lowercase().replaceFirstChar { it.uppercase() }
    }
}

fun formatarHorario(inicio: String, fim: String): String {
    return "${inicio.take(5)} às ${fim.take(5)}"
}