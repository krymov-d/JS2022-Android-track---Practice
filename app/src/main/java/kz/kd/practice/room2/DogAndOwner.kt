package kz.kd.practice.room2

import androidx.room.Embedded
import androidx.room.Relation

data class DogAndOwner(
    @Embedded val owner: Owner,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "dogOwnerId"
    )
    val dog: Dog
)