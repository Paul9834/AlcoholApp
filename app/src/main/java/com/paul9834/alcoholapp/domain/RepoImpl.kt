package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.vo.Resource

class RepoImpl (private val dataSource: DataSource): Repo {

    override suspend fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }

    override suspend fun getTragosFavorites(): Resource<List<DrinkEntity>> {

        return dataSource.getTragoFavorites()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        dataSource.insertTragoRoom(trago)
    }

    override suspend fun deleteTrago(trago: DrinkEntity) {
        dataSource.deleteDrink(trago)
    }


}