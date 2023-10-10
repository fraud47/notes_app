package zw.apkmechanic.notesapp.ui.notes_list.components

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import zw.apkmechanic.notesapp.domain.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDialogue(
                 setShowDialog: (Boolean) -> Unit,
                 saveNote: (Note)->Unit)
                  {


    var title by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),

        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Add Note",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Edit item",
                                tint = colorResource(R.color.darker_gray),
                                modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .width(16.dp)
                                    .height(16.dp)

                            )

                        }

                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "close",
                            tint = colorResource(R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    InputText(text = title,
                        label = "enter title",
                        lines = 1,
                        setValue ={
                        if(it.all{char ->
                                char.isLetter()||char.isWhitespace()
                            })
                            title=it
                    } )

                    Spacer(modifier = Modifier.height(20.dp))

                    InputText(

                        text = desc,
                        label = "enter description",
                        lines = 1,setValue ={
                        if(it.all{char ->
                                char.isLetter()||char.isWhitespace()
                            })
                            desc=it
                    } )






                    Spacer(modifier = Modifier.height(20.dp))


                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if(title.isNotEmpty()||desc.isNotEmpty()){
                                  saveNote(
                                      Note(title=title,
                                      desc=desc)
                                  )

                                setShowDialog(false)}
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Done")
                        }
                    }
                }
            }
        }
    }
}