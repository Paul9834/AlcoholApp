package com.paul9834.alcoholapp.ui.viewmodel

import androidx.lifecycle.*
import com.paul9834.alcoholapp.domain.Repo
import com.paul9834.alcoholapp.vo.Resource
import kotlinx.coroutines.Dispatchers
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





}