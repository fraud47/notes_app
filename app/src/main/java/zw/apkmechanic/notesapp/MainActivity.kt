package zw.apkmechanic.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import zw.apkmechanic.notesapp.ui.Screen
import zw.apkmechanic.notesapp.ui.notes_detail.NoteDetailScreen
import zw.apkmechanic.notesapp.ui.notes_detail.NotesDetailViewModel
import zw.apkmechanic.notesapp.ui.notes_list.NotesListViewModel
import zw.apkmechanic.notesapp.ui.notes_list.NotesScreen
import zw.apkmechanic.notesapp.ui.theme.NotesappTheme
import java.util.UUID

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesappTheme {

                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NoteListScreen.route
                    ) {
                        composable(
                            route = Screen.NoteListScreen.route
                        ) {
                            NotesScreen(navController=navController)
                        }
                        composable(
                            route = Screen.NoteDetailScreen.route + "/{id}",
                            arguments = listOf(
                                navArgument(name = "id") {
                                    type = NavType.StringType
                                    defaultValue = "-1"
                                }
                            )

                        ) {
                                backStackEntry ->
                            val id = backStackEntry.arguments?.getString("id") ?: ""
                            NoteDetailScreen(navController= navController)
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