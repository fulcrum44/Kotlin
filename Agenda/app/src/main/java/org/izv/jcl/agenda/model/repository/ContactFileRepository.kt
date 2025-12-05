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
            val file = getFile()

            var list = mutableListOf<Contact>()
            // Se devolverá la lista de dentro del if si se cumple la condición
            if (file.exists()) {
                file.forEachLine { linea ->
                    val elementos = linea.split(';')

                    val id = elementos[0].trim()
                    val name = elementos[1].trim()
                    val phone = elementos[2].trim()

                    list.add(Contact(Integer.parseInt(id), name, phone))
                }
            }

            list

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