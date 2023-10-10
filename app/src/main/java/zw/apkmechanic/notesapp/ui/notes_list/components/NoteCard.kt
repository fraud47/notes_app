package zw.apkmechanic.notesapp.ui.notes_list.components



import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import zw.apkmechanic.notesapp.domain.models.Note
import zw.apkmechanic.notesapp.ui.theme.SurfaceBg
import zw.apkmechanic.notesapp.ui.theme.TextColor
import zw.apkmechanic.notesapp.ui.theme.TextColorSubtitle


@Composable
fun NoteCard(
    note: Note,
    onClick: (Note)->Unit,
    onDeleteClick: () -> Unit,
){
  Surface (modifier = Modifier
      .padding(horizontal = 10.dp, vertical = 10.dp)
      .clip(RoundedCornerShape(10.dp))
      .fillMaxWidth()
      .height(90.dp)
      .clickable { onClick(note) }

      , color = SurfaceBg

      ){
//      Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
//          Column(modifier =
//          Modifier.padding(horizontal = 10.dp,
//              vertical = 10.dp)
//
//            ,
//              verticalArrangement = Arrangement.Center) {
              Row(
                  horizontalArrangement = Arrangement.SpaceBetween,
                  modifier = Modifier.padding(horizontal = 10.dp,vertical = 10.dp)
                  ) {
                  Column(verticalArrangement = Arrangement.Center ) {
                      Text(text = "${note.title}",
                          style = MaterialTheme.typography.titleSmall)
                      Text(text = "${note.desc}",
                          style = MaterialTheme.typography.bodyLarge,
                          modifier = Modifier
                              .width(300.dp)

                            )

                  }
                  Icon(
                      imageVector = Icons.Default.Close,
                      tint = TextColorSubtitle,
                      contentDescription = "Delete note",
                      modifier = Modifier
                          .clickable(MutableInteractionSource(), null) {
                              onDeleteClick()
                          }
                  )


              }










      }

  }
