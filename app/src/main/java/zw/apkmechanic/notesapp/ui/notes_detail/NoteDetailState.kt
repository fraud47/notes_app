package zw.apkmechanic.notesapp.ui.notes_detail

import zw.apkmechanic.notesapp.domain.models.Note


data class NoteDetailState(
    val isLoading: Boolean = false,
    val noteTitle: String = "",
    val isNoteTitleHintVisible: Boolean = false,
    val noteContent: String = "",
    val isNoteContentHintVisible: Boolean = false,

)
