package com.practicecoding.moneyreminder.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StoreDao {
    @Insert
    fun insertUser(entity: Nameentity):Long

    @Update
    fun Update(entity: Nameentity)

    @Delete
    fun Delete(entity: Nameentity)

    @Query("DELETE FROM entity WHERE amount == 0")
    fun delete0()
    @Query("DELETE FROM entity")
    fun deleteall()
    @Query("SELECT * FROM entity")
    fun getallentityindb():LiveData<List<Nameentity>>
}