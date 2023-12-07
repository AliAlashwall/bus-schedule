package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusRepository(private val busDao: BusDao): BusRepository {

    override fun getAllItems(): Flow<List<BusSchedule>> = busDao.getAllItems()

    override fun getItem(name : String): Flow<List<BusSchedule>> =  busDao.getItem(name)
}