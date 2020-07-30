package com.paul9834.alcoholapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paul9834.alcoholapp.domain.Repo

class VMFactory (private val repo: Repo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }

}