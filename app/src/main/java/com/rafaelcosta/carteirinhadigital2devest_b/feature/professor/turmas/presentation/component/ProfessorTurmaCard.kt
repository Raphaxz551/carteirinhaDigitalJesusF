package com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rafaelcosta.carteirinhadigital2devest_b.core.util.formatarDiasSemana
import com.rafaelcosta.carteirinhadigital2devest_b.core.util.formatarHorario
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.model.Turma

@Composable
fun ProfessorTurmaCard(
    turma: Turma,
    modifier: Modifier = Modifier
) {
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
                text = turma.codigo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(text = turma.curso)
            Text(text = "Semestre: ${turma.semestre}")
            Text(text = "Alunos: ${turma.quantidadeAlunos}")
            Text(text = "Dias: ${turma.diasSemana.formatarDiasSemana()}")
            Text(text = "Horário: ${formatarHorario(turma.horarioInicio, turma.horarioFim)}")
        }
    }
}