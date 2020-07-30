package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.vo.Resource

interface Repo {


   fun getTragosList(): Resource<List<Drink>>


}