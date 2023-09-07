package zw.apkmechanic.notesapp.ui.notes_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    text: String,
    setValue:(String)->Unit,
    label: String,
    lines:Int

){
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(
                    width = 0.dp,
                    color = Color.Transparent
                )
            ),
        shape =  RoundedCornerShape(10.dp),

        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = lines,


        placeholder = { Text(text = "$label") },
        value = text,

        onValueChange = setValue)
}