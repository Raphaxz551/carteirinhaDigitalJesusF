package com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.GraphRoutes
import com.rafaelcosta.carteirinhadigital2devest_b.app.navigation.ProfileGuard
import com.rafaelcosta.carteirinhadigital2devest_b.app.ui.AppShell
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.PerfilAcesso
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.home.presentation.screen.HomeProfessorScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.domain.repository.ProfessorTurmaRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.factory.ProfessorTurmaViewModelFactory
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.screen.ProfessorTurmaScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.turmas.presentation.screen.ProfessorTurmaViewModel
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.domain.repository.ProfessorUnidadeCurricularRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.factory.ProfessorUnidadeCurricularViewModelFactory
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen.ProfessorUnidadeCurricularScreen
import com.rafaelcosta.carteirinhadigital2devest_b.feature.professor.unidade_curriculares.presentation.screen.ProfessorUnidadeCurricularViewModel
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    turmaRepository: ProfessorTurmaRepository,
    unidadeCurricularRepository: ProfessorUnidadeCurricularRepository,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {

        composable(route = ProfessorRoutes.HOME) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = {
                            navController.navigate(ProfessorRoutes.TURMAS)
                        },
                        onUnidadesCurricularesClick = {
                            navController.navigate(ProfessorRoutes.UNIDADES_CURRICULARES)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        composable(route = ProfessorRoutes.TURMAS) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                val factory = remember(turmaRepository) {
                    ProfessorTurmaViewModelFactory(repository = turmaRepository)
                }
                val turmaViewModel: ProfessorTurmaViewModel = viewModel(factory = factory)

                AppShell(
                    title = "Minhas Turmas",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() },
                    onLogout = onLogout
                ) { innerPadding ->
                    ProfessorTurmaScreen(
                        viewModel = turmaViewModel,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        composable(route = ProfessorRoutes.UNIDADES_CURRICULARES) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                val factory = remember(unidadeCurricularRepository) {
                    ProfessorUnidadeCurricularViewModelFactory(
                        repository = unidadeCurricularRepository
                    )
                }
                val ucViewModel: ProfessorUnidadeCurricularViewModel = viewModel(factory = factory)

                AppShell(
                    title = "Unidades Curriculares",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() },
                    onLogout = onLogout
                ) { innerPadding ->
                    ProfessorUnidadeCurricularScreen(
                        viewModel = ucViewModel,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}