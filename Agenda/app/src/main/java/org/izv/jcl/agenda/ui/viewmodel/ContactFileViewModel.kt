package org.izv.jcl.agenda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.izv.jcl.agenda.model.plain.Contact
import org.izv.jcl.agenda.model.repository.ContactFileRepository

class ContactFileViewModel(private val repository: ContactFileRepository): ViewModel() {

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())

    val contacts = _contacts.asStateFlow()

    fun readContacts() {
        viewModelScope.launch {
            _contacts.value = repository.readContacts()
        }
    }

    fun writeContact(contact: Contact) {
        viewModelScope.launch {
            repository.writeContact(contact)
        }
    }
}