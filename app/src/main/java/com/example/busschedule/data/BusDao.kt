package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {

    @Query("Select * from BusSchedule Order by arrivalTimeInMillis ASC")
    fun getAllItems() : Flow<List<BusSchedule>>

    @Query("Select * from BusSchedule where stopName = :name Order by arrivalTimeInMillis ASC")
    fun getItem(name : String) : Flow<List<BusSchedule>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bus: BusSchedule)
}