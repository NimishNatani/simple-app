package com.practicecoding.moneyreminder.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicecoding.moneyreminder.room.Nameentity
import com.practicecoding.moneyreminder.room.namerepo
import kotlinx.coroutines.launch

class Myviewmodelone(private val repository:namerepo):ViewModel(), Observable {
    val users = repository.users
    private var isupdateordelete = false
    private lateinit var usertoupdateordelte:Nameentity

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputamount = MutableLiveData<Int?>()

    @Bindable
    val saveorupdatebuttontext = MutableLiveData<Any>()
    @Bindable
    val clearallordeletebuttontext = MutableLiveData<Any>()

    init{
        saveorupdatebuttontext.value = "Save"
        clearallordeletebuttontext.value = "Clear All"
    }
    fun saveorupdate(){
        if(isupdateordelete){
            usertoupdateordelte.name = inputName.value!!
            update(usertoupdateordelte)
        }
        else {
            val name = inputName.value!!
            insert(Nameentity(0,name,0))
        }
    }
fun clearordelete(){
    if(isupdateordelete){
        delete(usertoupdateordelte)
    }
    else {
        deleteall()
    }
}

     fun deleteall() = viewModelScope.launch{repository.deleteall() }

     fun update(entity: Nameentity) = viewModelScope.launch{repository.update(entity)
     inputName.value=null
     isupdateordelete=false
     saveorupdatebuttontext.value= "Save"
     clearallordeletebuttontext.value = "Clear All"}

     fun insert(entity: Nameentity) =viewModelScope.launch { repository.insert(entity) }

    fun delete(entity: Nameentity) = viewModelScope.launch { repository.delete(entity)
    inputName.value=null
    isupdateordelete=false
        saveorupdatebuttontext.value= "Save"
        clearallordeletebuttontext.value = "Clear All"}

    fun initupdateanddelete(entity: Nameentity){
        inputName.value=entity.name
        isupdateordelete=true
        usertoupdateordelte=entity
        saveorupdatebuttontext.value = "Update"
        clearallordeletebuttontext.value= "Delete"
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}