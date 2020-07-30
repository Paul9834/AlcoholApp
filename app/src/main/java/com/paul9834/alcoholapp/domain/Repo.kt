package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.vo.Resource

interface Repo {
   suspend fun getTragosList(tragoName:String): Resource<List<Drink>>
}