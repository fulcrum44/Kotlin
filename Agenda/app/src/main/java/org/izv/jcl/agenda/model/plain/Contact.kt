package org.izv.jcl.agenda.model.plain

data class Contact(
    val id: Int,
    val name: String,
    val phone: String


) {
    override fun toString(): String {
        return "$id;$name;$phone"
    }
}