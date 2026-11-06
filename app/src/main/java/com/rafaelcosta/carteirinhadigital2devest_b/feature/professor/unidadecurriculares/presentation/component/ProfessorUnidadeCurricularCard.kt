package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rafaelcosta.carteirinhadigital2devest_b.core.util.formatarDiasSemana
import com.rafaelcosta.carteirinhadigital2devest_b.core.util.formatarHorario
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.model.ProfessorUnidadeCurricular

@Composable
fun ProfessorUnidadeCurricularCard(
    unidade: ProfessorUnidadeCurricular,
    modifier: Modifier = Modifier
) {
    val progresso = if (unidade.quantidadeAulas > 0) {
        unidade.aulasRealizadas.toFloat() / unidade.quantidadeAulas
    } else {
        0f
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = unidade.nome,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Turma: ${unidade.turma}")
            Text(text = "Carga horária: ${unidade.cargaHoraria}h")
            Text(text = "Dias: ${unidade.diasSemana.formatarDiasSemana()}")
            Text(text = "Horário: ${formatarHorario(unidade.horarioInicio, unidade.horarioFim)}")
            Text(text = "Aulas realizadas: ${unidade.aulasRealizadas} de ${unidade.quantidadeAulas}")
            LinearProgressIndicator(
                progress = { progresso.coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}