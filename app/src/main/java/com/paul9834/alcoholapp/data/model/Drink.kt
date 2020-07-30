package com.paul9834.alcoholapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Drink(
    @SerializedName("idDrink")
    val tragoId:String = "",
    @SerializedName("strDrinkThumb")
    val imagen: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
    @SerializedName("strInstructions")
    val descripcion: String = "",
    @SerializedName("strAlcoholic")
    val hasAlcohol:String = "Non_Alcoholic"
):Parcelable


data class DrinkList(
    @SerializedName("drinks")
    val drinksList:List<Drink> = listOf()
)


@Entity(tableName = "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val tragoId: String,
    @ColumnInfo(name = "trago_imagen")
    val imagen: String = "",
    @ColumnInfo(name = "trago_nombre")
    val nombre: String = "",
    @ColumnInfo(name = "trago_descripcion")
    val descripcion: String = "",
    @ColumnInfo(name = "trago_has_alcohol")
    val hasAlcohol:String = "Non_Alcoholic"
)