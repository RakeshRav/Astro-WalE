package com.example.astro_wale.data.common


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "shopping_items")
@Parcelize
data class AstroApiData(
    @SerializedName("explanation")
    val explanation: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) : Parcelable