package zw.apkmechanic.notesapp.domain.use_case.get_notes

import zw.apkmechanic.notesapp.domain.models.Note

class SearchNotes {

    fun execute(notes: List<Note>, query: String): List<Note> {
        if(query.isBlank()) {
            return notes
        }
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) ||
                    it.desc.trim().lowercase().contains(query.lowercase())
        }
//            .sortedBy {
//            DateTimeUtil.toEpochMillis(it.created)
//        }
    }
}