package kz.kd.practice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun personDao() : PersonDao
}