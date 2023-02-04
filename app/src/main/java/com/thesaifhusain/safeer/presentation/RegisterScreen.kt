package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.genericButton
import com.thesaifhusain.safeer.utils.genericEditText
import com.thesaifhusain.safeer.utils.genericHeading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (registerText, registerBox, footer) = createRefs()
        genericHeading(
            text = stringResource(id = R.string.register),
            modifier = Modifier
                .constrainAs(registerText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Box(
            modifier = Modifier.constrainAs(registerBox) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                genericEditText(text = "", label = stringResource(id = R.string.name), onClick = {})
                genericEditText(text = "", label = stringResource(id = R.string.city), onClick = {})
                genericEditText(
                    text = "",
                    label = stringResource(id = R.string.phone),
                    onClick = {}
                )
                genericEditText(
                    text = "",
                    label = stringResource(id = R.string.email),
                    onClick = {}
                )
                genericEditText(
                    text = "",
                    label = stringResource(id = R.string.password),
                    onClick = {}
                )
                genericEditText(
                    text = "",
                    label = stringResource(id = R.string.repassword),
                    onClick = {}
                )
                genericButton(
                    buttonText = stringResource(id = R.string.submit),
                    onClick = { /*TODO*/ }
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(bottom = 5.dp)
                        .height(30.dp),
                    colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))
                ) {
                    Text(
                        text = stringResource(id = R.string.alredyregister),
                        fontSize = 12.sp
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.footer),
            contentDescription = "a",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(name = "RegisterScreen", showSystemUi = true)
@Composable
private fun PreviewRegisterScreen() {
    RegisterScreen()
}
