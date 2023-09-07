package zw.apkmechanic.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zw.apkmechanic.notesapp.ui.Screen
import zw.apkmechanic.notesapp.ui.notes_detail.NoteDetailScreen
import zw.apkmechanic.notesapp.ui.notes_list.NotesListViewModel
import zw.apkmechanic.notesapp.ui.notes_list.NotesScreen
import zw.apkmechanic.notesapp.ui.theme.NotesappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesappTheme {
                val noteViewModel:NotesListViewModel by viewModels()
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NoteListScreen.route
                    ) {
                        composable(
                            route = Screen.NoteListScreen.route
                        ) {
                            NotesScreen(navController,noteViewModel)
                        }
                        composable(
                            route = Screen.NoteDetailScreen.route + "/{id}"
                        ) {
                            NoteDetailScreen()
                        }
                    }
                }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun NotesScreenPreview() {
//    NotesappTheme {
//        NotesScreen()
//    }
//}

}