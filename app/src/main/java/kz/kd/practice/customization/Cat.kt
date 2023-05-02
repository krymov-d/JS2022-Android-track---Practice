package kz.kd.practice.customization

import androidx.annotation.DrawableRes

data class Cat(
    val name: String,
    @DrawableRes val imageRes: Int
): Animal