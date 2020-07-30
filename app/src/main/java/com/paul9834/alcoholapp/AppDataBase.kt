package com.paul9834.alcoholapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.paul9834.alcoholapp.data.model.DrinkEntity
import com.paul9834.alcoholapp.domain.TragosDAO

@Database(entities = arrayOf(DrinkEntity::class), version = 1)
abstract class AppDataBase :RoomDatabase() {

    abstract fun tragoDao(): TragosDAO

    companion object {
        private var INSTACE: AppDataBase? = null
        fun getDatabase(context: Context):AppDataBase {
            INSTACE = INSTACE ?: Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "tabla_tragos").build()
            return INSTACE!!
        }
        fun destroyInstance () {
            INSTACE = null
        }
    }

}