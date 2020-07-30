package com.paul9834.alcoholapp.data.model

import com.paul9834.alcoholapp.AppDataBase
import com.paul9834.alcoholapp.vo.Resource
import com.paul9834.alcoholapp.vo.RetrofitClient

class DataSource(private val appDataBase: AppDataBase) {

    suspend fun getTragoByName (tragoName:String):Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragosByName(tragoName).drinkList)
    }


    suspend fun insertTragoRoom (trago:DrinkEntity) {
        appDataBase.tragoDao().insertFavorite(trago)
    }

    suspend fun getTragoFavorites(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDataBase.tragoDao().getFavoriteAllDrinks())
    }

    suspend fun deleteTrago(trago: Drink) {
        appDataBase.tragoDao().deleteDrink(trago)
    }


}