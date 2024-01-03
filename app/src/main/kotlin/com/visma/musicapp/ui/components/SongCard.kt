package com.visma.musicapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.visma.musicapp.R
import com.visma.musicapp.data.models.Song
import com.visma.musicapp.utils.formatSongTime

@Composable
fun SongCard(song: Song) {
    val configuration = LocalConfiguration.current
    val orientation = LocalConfiguration.current.orientation

    val width =
        if (orientation == Configuration.ORIENTATION_PORTRAIT) configuration.screenWidthDp.dp / 3 else configuration.screenWidthDp.dp / 5
    val height =
        if (orientation == Configuration.ORIENTATION_PORTRAIT) configuration.screenHeightDp.dp / 5 else configuration.screenHeightDp.dp / 2

    Column(
        modifier = Modifier
            .size(width, height)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://media.istockphoto.com/id/154918294/photo/happy-dog.jpg?s=612x612&w=0&k=20&c=eJinKm5Qb0xvap17wk4HKTy7Ao0WpufTfx3V3XMAlbw=")
                .crossfade(true)
                .build(),
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_image_placeholder),
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .weight(0.6F)
                .align(Alignment.CenterHorizontally)
        )
        Column(modifier = Modifier.weight(0.4F).padding(bottom = 2.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = song.title,
                fontSize = 13.sp,
                lineHeight = 1.em,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row {
                Text(text = "${song.size}MB", fontSize = 11.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = song.duration.formatSongTime(), fontSize = 11.sp)
            }
        }
    }
}

