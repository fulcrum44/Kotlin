package org.izv.jcl.agenda.model.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.izv.jcl.agenda.model.plain.Contact
import java.io.File
import java.nio.file.Files

class ContactFileRepository(private val context: Context) {
    val fileName = "contacts.csv"

    private fun getFile(): File {
        return File(context.filesDir, fileName)
    }

    /* suspend -> corrutinas que se ejecutan en segundo plano */
    suspend fun readContacts(): List<Contact> {
        return withContext(Dispatchers.IO) {
//            emptyList()

            var list = mutableListOf<Contact>()



        }
    }

    suspend fun writeContact(contact: Contact) {
        return withContext(Dispatchers.IO) {

        }
    }

    suspend fun editContact(contact: Contact) {
        return withContext(Dispatchers.IO) {

        }
    }

    suspend fun deleteContact(contact: Contact) {
        return withContext(Dispatchers.IO) {

        }
    }
}