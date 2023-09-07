package zw.apkmechanic.notesapp.ui.notes_list

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import zw.apkmechanic.notesapp.data.NotesDataDummy
import zw.apkmechanic.notesapp.models.Note

class NotesListViewModel: ViewModel() {
    var notesList = mutableStateListOf<Note>()

    init {
//     notesList.addAll(NotesDataDummy().getAllNotes())
    }



    fun removeNote(note: Note){
       notesList.remove(note)
    }
    fun addNote(note: Note){
        notesList.add(note)
    }
    fun getAllNotes():List<Note>{
        return notesList
    }
}