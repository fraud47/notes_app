package zw.apkmechanic.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import zw.apkmechanic.notesapp.common.DateConverter
import zw.apkmechanic.notesapp.common.UUIDConverter
import zw.apkmechanic.notesapp.domain.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase:RoomDatabase(){
    abstract fun noteDao():NoteDatabaseDao
}