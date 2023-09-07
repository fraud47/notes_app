package zw.apkmechanic.notesapp.models

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val desc: String,
    val date: LocalDateTime=LocalDateTime.now()
)
