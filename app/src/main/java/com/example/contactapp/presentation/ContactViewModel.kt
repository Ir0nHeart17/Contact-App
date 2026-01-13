package com.example.contactapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapp.data.database.Contact
import com.example.contactapp.data.database.ContactDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val database: ContactDatabase) : ViewModel() {
    private var isSortedByName = MutableStateFlow(true)
    private var contact = isSortedByName.flatMapLatest {
        if (it) {
            database.getDao().getContactsSortedByName()
        } else {
            database.getDao().getContactsSortedByDateOfCreation()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(ContactState())
    val state = combine(_state, contact, isSortedByName) { state, contacts, isSortedByName ->
        state.copy(contacts = contacts)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun saveContacts() {
        val contact = Contact(
            id = state.value.id.value,
            name = _state.value.name.value,
            phone = _state.value.phone.value,
            email = _state.value.email.value,
            isActive = true,
            dateOfCreation = System.currentTimeMillis().toLong(),
            image = state.value.image.value,
        )
        viewModelScope.launch {
            database.getDao().upsertContact(contact)
            resetState()
        }



    }

    private fun resetState(){
        _state.value.id.value = 0
        _state.value.name.value = ""
        _state.value.phone.value = ""
        _state.value.email.value = ""
        _state.value.image.value = null

    }

    fun changeIsSorting() {
        isSortedByName.value = !isSortedByName.value
    }


    fun deleteContacts() {
        val contact = Contact(
            id = state.value.id.value,
            name = _state.value.name.value,
            phone = _state.value.phone.value,
            email = _state.value.email.value,
            isActive = false,
            dateOfCreation = System.currentTimeMillis().toLong(),
            image = state.value.image.value
        )

        viewModelScope.launch {
            database.getDao().deleteContact(contact)
            resetState()
        }


    }
}