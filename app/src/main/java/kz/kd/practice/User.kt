package kz.kd.practice

import java.io.Serializable

data class User(
        val name: String,
        val age: Int,
        val isMale: Boolean,
        val height: Double
) : Serializable