package com.practicecoding.moneyreminder.room

import androidx.room.Entity

class namerepo(private val dao:StoreDao) {
    val users = dao.getallentityindb()
    fun insert(entity: Nameentity):Long{
        return dao.insertUser(entity)
    }
    fun delete(entity: Nameentity){
        return dao.Delete(entity)
    }
    fun update(entity: Nameentity){
        return dao.Update(entity)
    }
    fun deleteall(){return dao.deleteall()}
    fun delete0(){return dao.delete0()}
}