package com.practicecoding.moneyreminder.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practicecoding.moneyreminder.room.namerepo

class myfactory1(private val repository:namerepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Myviewmodelone::class.java))
            { return Myviewmodelone(repository) as T}
            throw IllegalAccessException("Unkown")

    }
}