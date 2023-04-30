package kz.kd.practice.room2

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface DogAndOwnerDao {
    @Transaction
    @Query("SELECT * FROM Owner")
    fun getDogsAndOwners(): List<DogAndOwner>
}