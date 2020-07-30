package com.paul9834.alcoholapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.paul9834.alcoholapp.domain.Repo
import com.paul9834.alcoholapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo): ViewModel() {

    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList("margarita"))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }





}