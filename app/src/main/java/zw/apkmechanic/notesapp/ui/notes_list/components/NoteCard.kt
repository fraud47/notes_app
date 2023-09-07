package zw.apkmechanic.notesapp.ui.notes_list.components



import android.service.autofill.OnClickAction
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.sharp.KeyboardArrowRight

import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zw.apkmechanic.notesapp.R
import zw.apkmechanic.notesapp.models.Note
import zw.apkmechanic.notesapp.ui.theme.SurfaceBg
import zw.apkmechanic.notesapp.ui.theme.TextColor


@Composable
fun NoteCard(
    note: Note,
    onClick: (Note)->Unit){
  Surface (modifier = Modifier
      .padding(horizontal = 10.dp, vertical = 10.dp)
      .clip(RoundedCornerShape(10.dp))
      .fillMaxWidth()
      .height(90.dp)
      .clickable { onClick(note)}

      , color = SurfaceBg

      ){
      Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
          Column(modifier =
          Modifier.padding(horizontal = 10.dp,
              vertical = 10.dp)

            ,
              verticalArrangement = Arrangement.Center) {
              Text(text = "${note.title}",
                  style = MaterialTheme.typography.titleSmall)
              Text(text = "${note.desc}",
                  style = MaterialTheme.typography.bodyLarge,
                  modifier = Modifier.width(300.dp).height(24.dp),
                  overflow = TextOverflow.Clip,




              )

          }

          IconButton(onClick = { /*TODO*/ },){
              Icon(imageVector = Icons.Sharp.KeyboardArrowRight,
                  contentDescription = "enter",
                  tint = TextColor,
                  modifier = Modifier.size(32.dp))
          }
      }

  }
}