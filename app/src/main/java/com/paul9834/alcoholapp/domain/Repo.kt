package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.vo.Resource

interface Repo {

   suspend fun getTragosList(nombreTrago:String): Resource<List<Drink>>
   suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
   suspend fun insertTrago(trago:DrinkEntity)
   suspend fun deleteDrink(drink: DrinkEntity)


}