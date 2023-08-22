package com.practicecoding.moneyreminder.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "entity", indices = [Index(value = ["name", "amount"],  unique = true)])

data class Nameentity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "amount")
    val amount:Int

)
