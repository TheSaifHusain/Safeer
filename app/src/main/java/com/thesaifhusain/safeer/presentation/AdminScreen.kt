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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.thesaifhusain.safeer.R

@Composable
fun AdminScreen(navController: NavHostController) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (adminText, insText, rules, adminButton, row, footer) = createRefs()
        Text(
            text = stringResource(id = R.string.admin),
            fontWeight = FontWeight.SemiBold,
            fontSize = 50.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(adminText) {
                    top.linkTo(parent.top, 14.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = stringResource(id = R.string.ins),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(insText) {
                    top.linkTo(parent.top, 82.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.adminfooter),
            contentDescription = "a",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = stringResource(id = R.string.never),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(rules) {
                    top.linkTo(insText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(adminButton.top)
                }
        )
//Console Button
        Button(
            onClick = {
                      navController.navigate("console")
                      },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.constrainAs(adminButton) {
                bottom.linkTo(parent.bottom, 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(
                text = stringResource(id = R.string.adminconsole),
                fontSize = 35.sp,
                color = Color(red = 206, green = 145, blue = 56)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.constrainAs(row) {
                top.linkTo(adminButton.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text(
                text = stringResource(id = R.string.never),
                color = Color.White,
                fontSize = 14.sp
            )
            Checkbox(
                checked = false,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(red = 206, green = 145, blue = 56),
                    uncheckedColor = Color.DarkGray)
            )
        }
    }
}

@Preview(name = "AdminScreen", showSystemUi = true)
@Composable
fun PreviewAdminScreen() {
    //AdminScreen()
}
