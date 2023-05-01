package kz.kd.practice

import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    @DrawableRes val imageRes: Int
): Animal