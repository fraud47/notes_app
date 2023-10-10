package zw.apkmechanic.notesapp.ui.notes_list

import zw.apkmechanic.notesapp.domain.models.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
