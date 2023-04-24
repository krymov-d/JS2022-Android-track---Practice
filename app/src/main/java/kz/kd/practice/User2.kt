package kz.kd.practice

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User2(
    val name: String,
    val age: Int,
    val isMale: Boolean,
    val height: Double
) : Parcelable