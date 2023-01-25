package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R

@Composable
fun WelcomeScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (appText, spacer, aboutText, startedText, goButton, Image) = createRefs()

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.SemiBold,
            fontSize = 72.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(appText) {
                    top.linkTo(parent.top, 14.dp)
                    start.linkTo(parent.start, 18.dp)
                }
        )
        Box(
            modifier = Modifier
                .background(Color.Black)
                .width(300.dp)
                .size(2.dp)
                .constrainAs(spacer) {
                    top.linkTo(appText.bottom)
                    start.linkTo(appText.start)
                }
        )
        Text(
            text = stringResource(id = R.string.about),
            fontSize = 26.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .size(300.dp)
                .constrainAs(aboutText) {
                    top.linkTo(spacer.bottom, 12.dp)
                    start.linkTo(parent.start, 14.dp)
                    // end.linkTo(spacer.end)
                }
        )
        Text(
            text = stringResource(id = R.string.getstarted),
            fontSize = 35.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(startedText) {
                    top.linkTo(goButton.top)
                    start.linkTo(parent.start, 14.dp)
                    end.linkTo(goButton.start)
                    bottom.linkTo(goButton.bottom)
                }
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(red = 124, blue = 220, green = 201)),
            modifier = Modifier.size(72.dp)
                .constrainAs(goButton) {
                    start.linkTo(startedText.end, 12.dp)
                    top.linkTo(aboutText.bottom, 12.dp)
                    end.linkTo(parent.end)
                    bottom.linkTo(Image.top, 14.dp)
                }
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(35.dp)
            )
        }
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.about),
            contentDescription = "",
            modifier = Modifier.constrainAs(Image) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewWelcomeScreen() {
    WelcomeScreen()
}
