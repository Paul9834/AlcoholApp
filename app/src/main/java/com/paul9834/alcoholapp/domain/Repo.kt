package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.vo.Resource

interface Repo {
   suspend fun getTragosList(tragoName:String): Resource<List<Drink>>

   suspend fun getTragosFavorites() : Resource<List<DrinkEntity>>
   suspend fun insertTrago (trago:DrinkEntity)

   suspend fun deleteTrago(trago:DrinkEntity)



}