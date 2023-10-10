package zw.apkmechanic.notesapp.common

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timestampFromDate(date: Date):Long{
        return  date.time
    }
    @TypeConverter
    fun dateFromTimestamp(timestamp: Long):Date?{
        return Date(timestamp)
    }
}