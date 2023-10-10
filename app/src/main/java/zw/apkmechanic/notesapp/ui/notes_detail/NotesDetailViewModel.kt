package zw.apkmechanic.notesapp.ui.notes_detail


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import zw.apkmechanic.notesapp.domain.models.Note

import javax.inject.Inject
import zw.apkmechanic.notesapp.domain.repo.NoteRepository

import java.util.UUID


@HiltViewModel
class NotesDetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val noteTitle = savedStateHandle.getStateFlow("noteTitle", "")
    private val isNoteTitleFocused = savedStateHandle.getStateFlow("isNoteTitleFocused", false)
    private val noteContent = savedStateHandle.getStateFlow("noteContent", "")
    private val isNoteContentFocused = savedStateHandle.getStateFlow("isNoteContentFocused", false)


    val state = combine(
        noteTitle,
        isNoteTitleFocused,
        noteContent,
        isNoteContentFocused,

    ) { title, isTitleFocused, content, isContentFocused->
        NoteDetailState(
            noteTitle = title,
            isNoteTitleHintVisible = title.isEmpty() && !isTitleFocused,
            noteContent = content,
            isNoteContentHintVisible = content.isEmpty() && !isContentFocused,

        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteDetailState())

    private val _hasNoteBeenSaved = MutableStateFlow(false)
    val hasNoteBeenSaved = _hasNoteBeenSaved.asStateFlow()

    private var existingNoteId: String? = null

    init {

        savedStateHandle.get<String>("id")?.let { id->



            if(id== "-1") {

                return@let
            }
            this.existingNoteId = id


            viewModelScope.launch {
                noteRepository.getNoteById(id).let { note ->
                    savedStateHandle["noteTitle"] = note.title
                    savedStateHandle["noteContent"] = note.desc

                }
            }
        }
    }

    fun onNoteTitleChanged(text: String) {
        savedStateHandle["noteTitle"] = text
    }

    fun onNoteContentChanged(text: String) {
        savedStateHandle["noteContent"] = text
    }

    fun onNoteTitleFocusChanged(isFocused: Boolean) {
        savedStateHandle["isNoteTitleFocused"] = isFocused
    }

    fun onNoteContentFocusChanged(isFocused: Boolean) {
        savedStateHandle["isNoteContentFocused"] = isFocused
    }

    fun saveNote() {
        viewModelScope.launch {
            if(existingNoteId==null){noteRepository.addNote(
                Note(

                    title = noteTitle.value,
                    desc = noteContent.value,

                )
            )}else{noteRepository.addNote(
                Note(
                    id = UUID.fromString(existingNoteId) ,
                    title = noteTitle.value,
                    desc = noteContent.value,

                    )
            )

            }


            _hasNoteBeenSaved.value = true
        }
    }
}