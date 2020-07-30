package com.paul9834.alcoholapp.domain

import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.vo.Resource

class RepoImpl (private val dataSource: DataSource): Repo {


    override suspend fun getTragosList(nombreTrago: String): Resource<List<Drink>> {
        return dataSource.getTragoByName(nombreTrago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragoFavorites()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        dataSource.insertTragoRoom(trago)
    }

    override suspend fun deleteDrink(drink: DrinkEntity) {
        dataSource.deleteDrink(drink)
    }



}