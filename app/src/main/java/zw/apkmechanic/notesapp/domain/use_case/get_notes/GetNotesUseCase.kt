package zw.apkmechanic.notesapp.domain.use_case.get_notes

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import zw.apkmechanic.notesapp.common.Resource
import zw.apkmechanic.notesapp.domain.models.Note
import zw.apkmechanic.notesapp.domain.repo.NoteRepository
import java.io.IOException
import javax.inject.Inject

class GetNotesUseCase  @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke():Flow<Resource<List<Note>>> = flow {
        try {
            emit(Resource.Loading<List<Note>>())
            val notes = repository.getAllNotes()
            emit(Resource.Success<List<Note>>(notes))
        } catch(e: IOException) {
            emit(Resource.Error<List<Note>>("Couldn't reach database"))
        }
    }
}