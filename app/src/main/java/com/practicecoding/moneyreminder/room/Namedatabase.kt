package com.practicecoding.moneyreminder.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class],version=1)
abstract class Namedatabase:RoomDatabase() {
    abstract val storeDao:StoreDao

    //Singleton Design Patterns
    companion object{
        @Volatile
        private var INSTANCE:Namedatabase ?=null
        fun getInstance(context: Context):Namedatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(context.applicationContext,
                    Namedatabase::class.java,"name.db").build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}