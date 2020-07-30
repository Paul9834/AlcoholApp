package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.DataSource
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.vo.Resource

class RepoImpl (private val dataSource: DataSource): Repo {

    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.generateTragosList
    }


}