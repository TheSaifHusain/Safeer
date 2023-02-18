package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.genericHeading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        val (loginText, appText, loginBox, google, footer) = createRefs()
        genericHeading(
            text = stringResource(id = R.string.login),
            modifier = Modifier
                .constrainAs(loginText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Image(painter = painterResource(id = R.drawable.logo_)
            , contentDescription = ""
            , modifier = Modifier
                .size(180.dp)
                .constrainAs(appText){
                top.linkTo(loginText.bottom)
                bottom.linkTo(loginBox.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })
        Box(
            modifier = Modifier.constrainAs(loginBox) {
                top.linkTo(loginText.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
// Submit Button
                Button(
                    onClick = {
                        navController.navigate("console")
                    },
                    modifier = Modifier.padding(bottom = 5.dp)
                        .fillMaxWidth(0.7f),
                    colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))

                ) { Text(text = stringResource(id = R.string.submit)) }
// Register Button
                Button(
                    onClick = {
                        navController.navigate("register")
                    },
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
        Button(
            onClick = {},
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(google) {
                    top.linkTo(loginBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(footer.top)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "",
                Modifier.size(30.dp).padding(end = 12.dp)
            )
            Text(text = "SIGH IN WITH GOOGLE")
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

@Preview(name = "LoginScreen", showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}