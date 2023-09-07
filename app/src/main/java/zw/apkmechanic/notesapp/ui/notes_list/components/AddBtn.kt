package zw.apkmechanic.notesapp.ui.notes_list.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import zw.apkmechanic.notesapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import zw.apkmechanic.notesapp.ui.theme.DarkBg


@Composable
fun AddBtn( clicked: (Boolean)->Unit){

        Button( modifier=Modifier.padding(8.dp),
                colors =  ButtonDefaults.buttonColors(
            
                containerColor = DarkBg
        ) ,
                onClick = {

                        clicked(true)
                },
                content={
                Text(text = stringResource(id = R.string.add_btn))
        })

}