package zw.apkmechanic.notesapp.domain.use_case.note

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import zw.apkmechanic.notesapp.common.Resource
import zw.apkmechanic.notesapp.domain.models.Note
import zw.apkmechanic.notesapp.domain.repo.NoteRepository
import java.io.IOException
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(noteId: String): Flow<Resource<Note>> = flow {
        try {
            emit(Resource.Loading<Note>())
            val note = repository.getNoteById(noteId)
            emit(Resource.Success<Note>(note))
        }  catch(e: IOException) {
            emit(Resource.Error<Note>("Couldn't reach database."))
        }
    }
}