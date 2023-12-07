package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusRepository {

    fun getAllItems() : Flow<List<BusSchedule>>

    fun getItem(name : String) : Flow<List<BusSchedule>>
}