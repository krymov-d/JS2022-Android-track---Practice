package kz.kd.practice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao //обозначаем класс для работы с таблицами
interface PersonDao {

    @Query("SELECT * FROM person") // запрос в таблицу
    fun getAll(): List<Person>

    @Query("SELECT * FROM person WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Person>

    @Query("SELECT * FROM person WHERE first_name LIKE :first LIMIT 1")
    fun findByName(first: String): Person

    @Insert(onConflict = OnConflictStrategy.REPLACE) // добавление в таблицу
    fun insertAll(vararg users: Person)

    @Delete // удаление из таблицы
    fun delete(user: Person)

}