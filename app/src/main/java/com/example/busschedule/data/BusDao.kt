package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {

    @Query("Select * from Schedule Order by arrival_time ASC")
    fun getAllItems() : Flow<List<BusSchedule>>

    @Query("Select * from Schedule where stop_name = :name Order by arrival_time ASC")
    fun getItem(name : String) : Flow<List<BusSchedule>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bus: BusSchedule)
}