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

    fun addContact(name: String, phone: String) {
        // Habría que añadir el nuevo contacto al contexto actual de la agenda
        // Creamos una copia para evitar cualquier corrupción de los datos.

        val currentList = _contacts.value

        // Definimos un id para el nuevo contacto. Buscaremos el id más alto de la lista.
        val id = if (currentList.isEmpty()) {
            1
        } else {
            currentList.maxOf { it.id } + 1
        }

        val newContact = Contact(id, name, phone)

        val newContactList = currentList + newContact

        _contacts.value = newContactList

        viewModelScope.launch {
            repository.addContact(newContact)
        }
    }

    fun editContact(id: Int, name: String, phone: String) {
        // Hay que modificar el contacto de la lista actual de la agenda

        val currentList = _contacts.value

        val newContactList = currentList.map { contact ->
            if (contact.id == id) {
                contact.copy(name = name, phone = phone)
            } else {
                contact
            }
        }

        _contacts.value = newContactList

        viewModelScope.launch {
            repository.editContact(newContactList)
        }

    }

    fun deleteContact(id: Int) {
        val currentList = _contacts.value

        val newContactList = currentList.filter { contact -> contact.id != id}

        _contacts.value = newContactList

        viewModelScope.launch {
            repository.editContact(newContactList)
        }
    }

}