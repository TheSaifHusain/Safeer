package com.thesaifhusain.safeer.presentation.ConsoleScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.BikeScooter
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.People
import androidx.compose.material.icons.twotone.Woman
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.domain.myViewModel
import com.thesaifhusain.safeer.utils.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddMasjid(viewModel: myViewModel?) {
    val increaseContact = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        genericHeading(text = stringResource(id = R.string.addMasjid))
        FlowColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 25.dp, end = 25.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            genericImageSelect()
            Spacer(modifier = Modifier.size(12.dp))
            commonDetail()
            Spacer(modifier = Modifier.size(20.dp))
            personCard(
                modifier = Modifier
                    .clickable { increaseContact.value = ! increaseContact.value }
            )
            if(increaseContact.value){
                personCard(
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            serviceCard(modifier = Modifier)
            Spacer(modifier = Modifier.size(20.dp))
            genericButton(buttonText = "Submit", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun serviceCard(modifier: Modifier) {
    Column {
        Text(text = "Select Services", fontSize = 35.sp)
        Spacer(modifier = Modifier.size(12.dp))
        Card(
            modifier = modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary),
            elevation = CardDefaults.elevatedCardElevation(12.dp),
            shape = MaterialTheme.shapes.large
        ) {
            FlowRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                genericInputChip(
                    lable = stringResource(id = R.string.dailyJamat),
                    icon = Icons.TwoTone.People
                )
                if (
                    genericInputChip(
                        lable = stringResource(id = R.string.weeklyJamat),
                        icon = Icons.TwoTone.People
                    )
                ) {
                    FlowRow {
                        day(text = "Sun")
                        day(text = "Mon")
                        day(text = "Tue")
                        day(text = "Wed")
                        day(text = "Thu")
                        day(text = "Fri")
                        day(text = "Sat")
                    }
                }
                genericInputChip(
                    lable = stringResource(id = R.string.ramdanOnly),
                    icon = Icons.TwoTone.People
                )
                genericInputChip(
                    lable = stringResource(id = R.string.womanNamaz),
                    icon = Icons.TwoTone.Woman
                )
                genericInputChip(
                    lable = stringResource(id = R.string.parking),
                    icon = Icons.TwoTone.BikeScooter
                )
                if (
                    genericInputChip(
                        lable = stringResource(id = R.string.stay),
                        icon = Icons.TwoTone.Home
                    )
                ) {
                    FlowRow {
                        day(text = "Paid")
                        day(text = "Free")
                        day(text = "Both")
                    }
                }
            }
        }
    }
}

@Preview(name = "AddMasjid", showBackground = true)
@Composable
private fun PreviewAddMasjid() {
    AddMasjid(null)
}