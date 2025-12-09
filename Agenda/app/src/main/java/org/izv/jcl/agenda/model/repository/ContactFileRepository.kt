package org.izv.jcl.agenda.model.repository

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.izv.jcl.agenda.model.plain.Contact
import java.io.File

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

    suspend fun addContact(contact: Contact) {
        return withContext(Dispatchers.IO) {
            val file = getFile()

            if (file.exists()) {
                file.appendText(contact.toString())
            } else {
                file.writeText(contact.toString())
            }
            file.appendText("\n")
        }
    }

    suspend fun editContact(contacts: List<Contact>) {
        return withContext(Dispatchers.IO) {
            val file = getFile()

            val sb = StringBuilder()
            for (contact in contacts) {
                sb.append(contact.toString())
                sb.append("\n")
            }

            file.writeText(sb.toString())
        }
    }

    // Por qué hacer uno para eliminar si se hace lo mismo que el editar el fichero.
}