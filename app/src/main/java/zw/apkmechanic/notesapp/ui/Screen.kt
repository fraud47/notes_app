package zw.apkmechanic.notesapp.ui

sealed class Screen(val route: String) {
    object NoteListScreen: Screen("note_list_screen")
    object NoteDetailScreen: Screen("note_detail_screen")
}