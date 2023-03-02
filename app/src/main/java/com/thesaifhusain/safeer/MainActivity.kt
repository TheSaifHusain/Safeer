package com.thesaifhusain.safeer

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thesaifhusain.safeer.domain.myViewModel
import com.thesaifhusain.safeer.domain.navigaion.Navigation
import com.thesaifhusain.safeer.utils.genericDropDown
import com.thesaifhusain.safeer.utils.genericHeading
import dagger.hilt.android.AndroidEntryPoint
import org.checkerframework.checker.units.qual.g
import java.util.Locale

lateinit var selectetLanguage: MutableState<String>

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: myViewModel by viewModels<myViewModel>()
            Navigation(viewModel)

            val window: Window = this.window
            window.navigationBarColor = MaterialTheme.colorScheme.primary.toArgb()
//            SafeerTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    // changeLanguage("hi")
//                    // val navController = rememberNavController()
//                    // Navigation(navController = navController)
//                    SelectLanguage()
//                    changeLanguage()
//                }
//            }
        }
    }

    fun changeLanguage() {
        Locale.setDefault(Locale(selectetLanguage.value))

        val config = Configuration()
        config.locale = Locale(selectetLanguage.value)
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectLanguage() {
    // selectetLanguage = remember{ mutableStateOf("") }
    FlowColumn(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericHeading(
            text = stringResource(R.string.selectcLanguage),
            textSize = 28.sp
        )
        Spacer(modifier = Modifier.padding(100.dp))
        Languages()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Languages(): String {
    selectetLanguage = remember { mutableStateOf("en") }
    val select = remember { mutableStateOf(false) }

    FlowColumn {
        Card(
            Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.1f)
                .selectableGroup()
                .clickable {
                    selectetLanguage.value = "en"
                }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    stringResource(R.string.English),
                    fontSize = 22.sp
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Card(
            Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.1f)
                .selectableGroup()
                .clickable {
                    selectetLanguage.value = "hi"
                }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    stringResource(R.string.Hindi),
                    fontSize = 22.sp
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Card(
            Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.1f)
                .clickable {
                    selectetLanguage.value = "ur"
                }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    stringResource(R.string.Urdu),
                    fontSize = 22.sp
                )
            }
        }
    }
    return selectetLanguage.value
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectCity() {
    Column(
        Modifier.background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericHeading(
            text = stringResource(R.string.selectCity),
            textSize = 28.sp
        )
        FlowColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            genericDropDown()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    SelectCity()
}
