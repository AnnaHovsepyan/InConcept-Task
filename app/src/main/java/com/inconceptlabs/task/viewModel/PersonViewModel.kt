package com.inconceptlabs.task.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.inconceptlabs.task.database.PersonDb
import com.inconceptlabs.task.repository.PersonDataRepository

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PersonDataRepository(
        PersonDb.create(
            application.applicationContext,
            viewModelScope
        ).personDao()
    )

    fun getPersonData() = repository.getPersonData().asLiveData()
    fun getPersonOrderedData(sort: String) = repository.getPersonOrderedData(sort).asLiveData()

}
