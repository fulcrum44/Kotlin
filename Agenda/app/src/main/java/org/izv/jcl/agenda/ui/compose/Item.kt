package org.izv.jcl.agenda.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.izv.jcl.agenda.R
import org.izv.jcl.agenda.model.plain.Contact
import org.izv.jcl.agenda.ui.viewmodel.ContactFileViewModel

@Composable
fun Item(navController: NavController, viewModel: ContactFileViewModel, contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        //onClick = { navController.navigate("edit_contact")}
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = contact.name)
            Text(text = contact.phone)

            IconButton(
                onClick = { navController.navigate("edit_contact/${contact.id}")}
            ) {
                Icon(
                    painter = painterResource(R.drawable.edit_24px),
                    contentDescription = "Edit button"
                )
            }
            IconButton(
                onClick = {
                    viewModel.deleteContact(contact.id)
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.delete_24px),
                    contentDescription = "Delete button"
                )
            }
        }
    }
}