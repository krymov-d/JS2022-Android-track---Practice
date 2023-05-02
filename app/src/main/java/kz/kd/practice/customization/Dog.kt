package kz.kd.practice.customization

import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    @DrawableRes val imageRes: Int
): Animal