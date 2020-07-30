package com.paul9834.alcoholapp.data.model

import com.paul9834.alcoholapp.vo.Resource
import com.paul9834.alcoholapp.vo.RetrofitClient

class DataSource {

    suspend fun getTragoByName (tragoName:String):Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webservice.getTragosByName(tragoName).drinkList)
    }


}