package zw.apkmechanic.notesapp.ui.notes_list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import zw.apkmechanic.notesapp.R
import zw.apkmechanic.notesapp.ui.Screen
import zw.apkmechanic.notesapp.ui.notes_list.components.AddBtn
import zw.apkmechanic.notesapp.ui.notes_list.components.FormDialogue
import zw.apkmechanic.notesapp.ui.notes_list.components.NoteCard
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(navController: NavController,
                viewModel: NotesListViewModel= hiltViewModel()
              )
{
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.loadNotes()
    }


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
                AddBtn(text = "add",
                    clicked = { navController.navigate(Screen.NoteDetailScreen.route+"/-1")} )
               }

           )
       }
   ) {
       
      values-> LazyColumn(modifier = Modifier.padding(values),
          ){
     items(state.notes){note->
       NoteCard(
           note = note,
           onClick = {

               navController.navigate(Screen.NoteDetailScreen.route + "/${note.id}")},
           onDeleteClick ={viewModel.deleteNote(note)}
       )
     }
   }

}}