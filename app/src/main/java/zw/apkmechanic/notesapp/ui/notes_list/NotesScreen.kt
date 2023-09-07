package zw.apkmechanic.notesapp.ui.notes_list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import zw.apkmechanic.notesapp.R
import zw.apkmechanic.notesapp.ui.Screen
import zw.apkmechanic.notesapp.ui.notes_list.components.AddBtn
import zw.apkmechanic.notesapp.ui.notes_list.components.FormDialogue
import zw.apkmechanic.notesapp.ui.notes_list.components.NoteCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(navController: NavController,
                viewModel: NotesListViewModel
              )
{
    val showDialog =  remember { mutableStateOf(false) }

    val clicked = { newShowDialogState: Boolean ->
        showDialog.value = newShowDialogState
    }


    if(showDialog.value)
        FormDialogue( setShowDialog = clicked,
            saveNote = {
                viewModel.addNote(it)
            })

    var notes = viewModel.getAllNotes()
   Scaffold(modifier = Modifier.fillMaxSize(),
         containerColor = MaterialTheme.colorScheme.secondary,
       topBar = {
           TopAppBar(
               title = {
                   Text(
                       text = stringResource(id = R.string.title)
                   )
               },
               colors = TopAppBarDefaults.mediumTopAppBarColors(
                   titleContentColor = Color.White
               ),
               actions = {
                AddBtn(clicked =  clicked )
               }

           )
       }
   ) {
       
      values-> LazyColumn(modifier = Modifier.padding(values),
          ){
     items(notes){note->
       NoteCard(
           note = note,
           onClick = {
               navController.navigate(Screen.NoteDetailScreen.route + "/${note.id}")}

       )
     }
   }

}}