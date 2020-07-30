package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET ("search.php?s=")
    suspend fun getTragosByName (@Query ("drink") tragoName:String): DrinkList


}