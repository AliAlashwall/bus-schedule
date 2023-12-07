package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [BusSchedule::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun busScheduleDao() : BusDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    name = "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }

    }
}
