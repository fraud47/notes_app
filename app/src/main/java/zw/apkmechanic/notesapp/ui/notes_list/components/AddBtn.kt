package zw.apkmechanic.notesapp.ui.notes_list.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import zw.apkmechanic.notesapp.ui.theme.DarkBg
import zw.apkmechanic.notesapp.ui.theme.TextColorSubtitle


@Composable
fun AddBtn(text: String? = null,
           icon: ImageVector? = null,
           clicked: ()->Unit){

        Button( modifier=Modifier.padding(8.dp),
                colors =  ButtonDefaults.buttonColors(
            
                containerColor = DarkBg
        ) ,
                onClick = {

                        clicked()
                },
                content={
                        if (icon != null) {
                                Icon(
                                        imageVector = icon,
                                        contentDescription = null, // Provide a proper content description
                                        tint = TextColorSubtitle,
                                        modifier = Modifier.size(24.dp)
                                )
                        } else if (text != null) {
                                Text(
                                        text = text,
                                        fontSize = 16.sp,
                                        color = TextColorSubtitle    )
                        }
        })

}