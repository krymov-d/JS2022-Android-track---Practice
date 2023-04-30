package kz.kd.practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person") // обозначаем таблицу

data class Person(
    @PrimaryKey // первичный ключ, идентификатор строки
    @ColumnInfo(name = "id") // обозначаем столбец, задаем имя
    val personId: Int,
    @ColumnInfo(name = "first_name")
    val firstName: String?,
    @ColumnInfo(name = "last_name")
    val lastName: String?
)
