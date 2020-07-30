package com.paul9834.alcoholapp.ui.viewmodel

import androidx.lifecycle.*
import com.paul9834.alcoholapp.data.model.Drink
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.domain.Repo
import com.paul9834.alcoholapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repo:Repo): ViewModel() {

    private val tragosData = MutableLiveData<String> ()

    fun setTrago(tragoName:String) {
        tragosData.value = tragoName
    }

    init {
        setTrago("Margarita")
    }

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }

    }

    fun guardarTrago(trago:DrinkEntity) {
        viewModelScope.launch {
            repo.insertTrago(trago)
        }
    }

    fun getTragosFavorites () = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosFavorites())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }

    }

    fun deleteDrink(drink: Drink) {
        viewModelScope.launch {
             repo.deleteTrago(drink)
        }

    }


}