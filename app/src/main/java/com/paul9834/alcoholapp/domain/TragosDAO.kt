package com.paul9834.alcoholapp.domain

import androidx.room.*
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity

@Dao
interface TragosDAO {

    @Query("SELECT * FROM DrinkEntity")
    suspend fun getFavoriteAllDrinks():List<DrinkEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:DrinkEntity)

    @Delete
    suspend fun deleteDrink(drink: Drink)


}