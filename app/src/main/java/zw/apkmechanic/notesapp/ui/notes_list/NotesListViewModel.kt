package zw.apkmechanic.notesapp.ui.notes_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import zw.apkmechanic.notesapp.domain.models.Note
import zw.apkmechanic.notesapp.domain.repo.NoteRepository
import zw.apkmechanic.notesapp.domain.use_case.get_notes.SearchNotes
import javax.inject.Inject


@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val repository: NoteRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val searchNotes = SearchNotes()
    private val notes = savedStateHandle.getStateFlow("notes", emptyList<Note>())
    private val searchText = savedStateHandle.getStateFlow("searchText", "")
    private val isSearchActive = savedStateHandle.getStateFlow("isSearchActive", false)

    val state = combine(notes, searchText, isSearchActive) { notes, searchText, isSearchActive ->
        NoteListState(
            notes = searchNotes.execute(notes, searchText),
            searchText = searchText,
            isSearchActive = isSearchActive
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteListState())






    fun loadNotes() {
        viewModelScope.launch {
            savedStateHandle["notes"] = repository.getAllNotes()

        }
    }

    fun onSearchTextChange(text: String) {
        savedStateHandle["searchText"] = text
    }

    fun onToggleSearch() {
        savedStateHandle["isSearchActive"] = !isSearchActive.value
        if(!isSearchActive.value) {
            savedStateHandle["searchText"] = ""
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
            loadNotes()
        }
    }









  
}