package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.vo.Resource

interface DataSource {

    suspend fun getTragoByName (tragoName:String): Resource<List<Drink>>

    suspend fun insertTragoRoom (trago: DrinkEntity)

    suspend fun getTragoFavorites(): Resource<List<DrinkEntity>>

    suspend fun deleteDrink(drink: DrinkEntity)


}