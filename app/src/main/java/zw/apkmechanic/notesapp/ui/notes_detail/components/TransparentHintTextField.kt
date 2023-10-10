package zw.apkmechanic.notesapp.ui.notes_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    isHintVisible: Boolean,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChanged: (FocusState) -> Unit
) {

    Box(modifier = modifier.padding(start = 5.dp)) {
        BasicTextField(

            value = text,
            onValueChange = onValueChanged,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { state ->
                    onFocusChanged(state)
                },
            cursorBrush = SolidColor(Color.White)
        )
        if(isHintVisible) {
            Text(
                text = hint,
                style = textStyle,

            )
        }
    }
}