package zw.apkmechanic.notesapp.ui.notes_detail


import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import zw.apkmechanic.notesapp.R
import zw.apkmechanic.notesapp.ui.Screen
import zw.apkmechanic.notesapp.ui.notes_detail.components.TransparentHintTextField
import zw.apkmechanic.notesapp.ui.notes_list.components.AddBtn
import zw.apkmechanic.notesapp.ui.notes_list.components.NoteCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen (
    viewModel: NotesDetailViewModel= hiltViewModel(),
    navController: NavController,
){
    val state by viewModel.state.collectAsState()
    val hasNoteBeenSaved by viewModel.hasNoteBeenSaved.collectAsState()
    LaunchedEffect(key1 = hasNoteBeenSaved) {
        if(hasNoteBeenSaved) {
            navController.popBackStack()
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = ""
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    titleContentColor = Color.White
                ),
                actions = {
                    AddBtn( icon =  Icons.Default.Check,
                        clicked =  viewModel::saveNote )
                }

            )
        }
    ) {

            values-> LazyColumn(modifier = Modifier.padding(values),
    ){

            item{
                TransparentHintTextField(
                    text = state.noteTitle,
                    hint = "Enter a title..",

                    isHintVisible = state.isNoteTitleHintVisible,
                    onValueChanged = viewModel::onNoteTitleChanged,
                    onFocusChanged = {
                        viewModel.onNoteTitleFocusChanged(it.isFocused)
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(20.dp))
                TransparentHintTextField(
                    text = state.noteContent,
                    hint = "Enter some content...",
                    isHintVisible = state.isNoteContentHintVisible,
                    onValueChanged = viewModel::onNoteContentChanged,
                    onFocusChanged = {
                        viewModel.onNoteContentFocusChanged(it.isFocused)
                    },
                    singleLine = false,
                    textStyle = MaterialTheme.typography.labelLarge,

                    )
            }
        }




    }



}



