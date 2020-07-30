package com.paul9834.alcoholapp.data.model

import com.paul9834.alcoholapp.AppDataBase
import com.paul9834.alcoholapp.domain.DataSource
import com.paul9834.alcoholapp.vo.Resource
import com.paul9834.alcoholapp.vo.RetrofitClient

class DataSourceImpl(private val appDataBase: AppDataBase):DataSource {

    override suspend fun getTragoByName (tragoName:String):Resource<List<Drink>> {




        return Resource.Success(RetrofitClient.webservice.getTragosByName(tragoName).drinksList)
    }

    override suspend fun insertTragoRoom (trago:DrinkEntity) {
        appDataBase.tragoDao().insertFavorite(trago)
    }

    override suspend fun getTragoFavorites(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDataBase.tragoDao().getFavoriteAllDrinks())
    }


    override suspend fun deleteDrink(drink: DrinkEntity) {
        appDataBase.tragoDao().deleteDrink(drink)
    }

}