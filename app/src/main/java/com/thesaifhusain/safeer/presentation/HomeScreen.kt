package com.thesaifhusain.safeer.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.CheckCircleOutline
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thesaifhusain.safeer.MainActivity
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.genericTag

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.city),
                        style = MaterialTheme.typography.headlineLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                actions = {
                    Text(
                        text = "Want to \nAdd?",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    IconButton(
                        onClick = {
                            navController.navigate("login")
                        },
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {
        ConstraintLayout(
            Modifier.fillMaxSize()
        ) {
            val (headerText, card, footerImage) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.footer),
                contentDescription = "a",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {  }
                    .constrainAs(footerImage) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            NewsCard(
                modifier = Modifier.constrainAs(card) {
                    top.linkTo(parent.top, 72.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }

//        genericHeading(
//            text = stringResource(id = R.string.city),
//            modifier = Modifier
//                .clickable { navController.navigate("console") }
//                .verticalScroll(rememberScrollState())
//                .constrainAs(headerText) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NewsCard(modifier: Modifier) {
    var expandState by remember { mutableStateOf(false) }
    Card(
        modifier
            .padding(14.dp)
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable { expandState = !expandState }
    ) {
        Column(
            // modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardHeader()
            Image(
                imageVector = Icons.TwoTone.Place,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(5.dp)
                    .background(Color.LightGray).fillMaxWidth(0.9f)
                    .fillMaxHeight(0.2f)
                    .background(shape = RoundedCornerShape(20.dp), color = Color.Black)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "",
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "+91-9807424754",
                    fontSize = 12.sp,
                    modifier = Modifier.clickable { expandState = !expandState }
                        .padding(5.dp)
                )
            }

            if (expandState) {
                FlowColumn {
                    Text(text = "Services :", Modifier.padding(start = 14.dp))
                    FlowRow(Modifier.fillMaxWidth().padding(start = 14.dp, top = 5.dp, end = 14.dp)) {
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                        genericTag()
                    }
                    Text(text = "Events :", Modifier.padding(14.dp))
                    Card(
                        Modifier.fillMaxWidth()
                            .padding(start = 14.dp, end = 14.dp, bottom = 5.dp),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Text(
                            text = "Ashra e mohrram start in 22/08/2023",
                            Modifier.padding(5.dp).fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 5.dp, end = 2.dp, bottom = 5.dp)
    ) {
        Image(
            Icons.Rounded.CheckCircleOutline,
            contentDescription = "",
            Modifier.size(40.dp).padding(end = 5.dp)
                .weight(0.5f)
        )
        Column(modifier = Modifier.weight(2f)) {
            Text(
                text = "Masjid Bazam e salat",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Rath-Haveli Faizabad - 224001",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(name = "HomeScreen", showSystemUi = true)
@Composable
private fun PreviewHomeScren() {
    HomeScreen(navController = rememberNavController())
    // NewsCard(modifier = Modifier)
}
