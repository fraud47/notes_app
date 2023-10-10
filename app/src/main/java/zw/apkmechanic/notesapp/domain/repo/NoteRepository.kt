package zw.apkmechanic.notesapp.domain.repo

import zw.apkmechanic.notesapp.data.NoteDatabaseDao
import zw.apkmechanic.notesapp.domain.models.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
) {
    suspend fun addNote(note: Note)=noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note)=noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note)=noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes()=noteDatabaseDao.deleteAll()
    suspend fun getNoteById(id: String)=noteDatabaseDao.getNoteById(id)
   suspend fun getAllNotes():List<Note> = noteDatabaseDao.getNotes()
}