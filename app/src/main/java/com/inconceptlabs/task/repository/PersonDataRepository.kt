package com.inconceptlabs.task.repository

import com.inconceptlabs.task.database.PersonDao
import com.inconceptlabs.task.model.Person
import kotlinx.coroutines.flow.Flow

class PersonDataRepository(private val personDb: PersonDao) {

    fun getPersonData(): Flow<Array<Person>> =
        personDb.getPersonData()

    fun getPersonOrderedData(sort: String) =
        personDb.getPersonData(sort == "ASC")
}


