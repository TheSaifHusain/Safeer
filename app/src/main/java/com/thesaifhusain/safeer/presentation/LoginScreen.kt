package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (loginText, loginBox, footer) = createRefs()
        Text(
            text = stringResource(id = R.string.login),
            fontWeight = FontWeight.SemiBold,
            fontSize = 72.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(loginText) {
                    top.linkTo(parent.top, 14.dp)
                    start.linkTo(loginBox.start)
                }
        )
        Box(
            modifier = Modifier.constrainAs(loginBox) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)  {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = stringResource(id = R.string.email)) },
                    modifier = Modifier.padding(bottom = 18.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = stringResource(id = R.string.email)) },
                    modifier = Modifier.padding(bottom = 18.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(bottom = 5.dp)
                        .fillMaxWidth(0.7f),
                    colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))

                ) { Text(text = stringResource(id = R.string.submit)) }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(bottom = 5.dp)
                        .height(30.dp),
                    colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))
                ) {
                    Text(
                        text = stringResource(id = R.string.registerhere),
                        fontSize = 12.sp
                    )
                }
            }
        }
        Image(painter = painterResource(id = R.drawable.footer),
            contentDescription = "a",
            modifier = Modifier.constrainAs(footer){
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
    }
}

@Preview(name = "LoginScreen", showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen()
}
