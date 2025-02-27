package it.polito.thesisapp.viewmodel

import androidx.lifecycle.viewModelScope
import it.polito.thesisapp.repository.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CreateTeamViewModel(
    private val repository: TeamRepository = TeamRepository()
) : BaseViewModel() {

    private val _teamCreated = MutableStateFlow(false)
    val teamCreated: StateFlow<Boolean> = _teamCreated

    private fun createTeam(teamName: String) {
        if (!validateNotBlank(teamName, "Team name")) {
            return
        }

        viewModelScope.launch {
            try {
                repository.createTeam(teamName)
                _teamCreated.value = true
                setError(null)
            } catch (e: Exception) {
                _teamCreated.value = false
                setError(e.message)
                println("Error in ViewModel: ${e.message}")
            }
        }
    }

    fun submitTeamName(teamName: String) {
        if (!validateNotBlank(teamName, "Team name")) {
            return
        }

        createTeam(teamName)
    }
}