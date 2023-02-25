package com.thesaifhusain.safeer.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.thesaifhusain.safeer.R
import java.util.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun genericHeading(
    text: String = "Heading",
    modifier: Modifier = Modifier,
    textSize: TextUnit = 50.sp
) {
    FlowRow(
        modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = textSize,
            color = MaterialTheme.colorScheme.onPrimary,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = 18.dp, top = 14.dp)
                .fillMaxWidth()

        )
    }
}

@Composable
fun genericImageSelect(modifier: Modifier = Modifier) {
    var selectImage by remember { mutableStateOf<Uri?>(null) }
    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectImage = uri }
    )

    Box(modifier = modifier) {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val (image, Button) = createRefs()
            AsyncImage(
                model = selectImage,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            androidx.compose.material3.Button(
                onClick = {
                    // Select Image
                    singlePhotoPicker.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                },
                modifier = Modifier.constrainAs(Button) {
                    bottom.linkTo(parent.bottom, 5.dp)
                    end.linkTo(parent.end, 5.dp)
                }
            ) {
                Image(
                    Icons.Default.Add,
                    contentDescription = "",
                    Modifier.padding(end = 5.dp),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = stringResource(id = R.string.picture),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun genericButton(
    buttonText: String,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier
        .padding(bottom = 5.dp)
        .fillMaxWidth(0.7f)
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))
    ) {
        Text(
            text = buttonText
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericEditText(
    text: String = "",
    label: String = "",
    inputType: KeyboardType = KeyboardType.Text,
    onClick: (() -> Unit)
): String {
    val textData = remember { mutableStateOf(text) }
    OutlinedTextField(
        value = textData.value,
        onValueChange = { textData.value = it },
        label = { Text(text = label) },
        modifier = Modifier
            .padding(bottom = 5.dp)
            .clickable { onClick }
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = inputType)
    )
    return textData.value
}

@Composable
fun genericTag(
    painter: Painter = painterResource(R.drawable.water_check_outline),
    text: String = "Service Name",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(60.dp)
            .padding(2.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "a",
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun genericDatePicker(text: String = "Choose Date"): String {
    val myCalender = Calendar.getInstance()
    val year = myCalender.get(Calendar.YEAR)
    val month = myCalender.get(Calendar.MONTH)
    val day = myCalender.get(Calendar.DAY_OF_MONTH)

    val context = LocalContext.current
    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year1, month1, day1 ->
            val month = month1 + 1
            date.value = "$day1 - $month - $year1"
        },
        year,
        month,
        day
    )
    Image(
        imageVector = Icons.Default.CalendarMonth,
        contentDescription = "",
        modifier = Modifier.clickable { datePickerDialog.show() }
    )
    return date.value
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericConsoleCard(
    painter: Painter = painterResource(id = R.drawable.mosque),
    text: String = stringResource(id = R.string.addMasjid),
    textSize: TextUnit = 26.sp,
    modifier: Modifier = Modifier.size(172.dp).padding(5.dp),
    onClick: (() -> Unit)?,
    modifier2: Modifier = Modifier
) {
    Card(onClick = { /*TODO*/ }, modifier = modifier) {
        ConstraintLayout(
            modifier2.padding(12.dp)
                .fillMaxSize()
        ) {
            val (text_, image) = createRefs()
            Image(
                painter = painter,
                contentDescription = "",
                Modifier.size(50.dp)
                    .alpha(0.5f)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .constrainAs(text_) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericDropDown() {
    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    // val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")
    val mCities = retrunListOfCites()

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(Modifier.padding(20.dp)) {
        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text("Label") },
            trailingIcon = {
                Icon(
                    icon,
                    "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded }
                )
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        mSelectedText = label
                        mExpanded = false
                    },
                    text = { Text(text = label) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun genericDropDown() {
//    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
//
//    var selectedItem by remember {
//        mutableStateOf("")
//    }
//
//    var expanded by remember {
//        mutableStateOf(false)
//    }
//
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = {
//            expanded = !expanded
//        }
//    ) {
//        OutlinedTextField(
//            value = selectedItem,
//            onValueChange = { selectedItem = it },
//            label = { Text(text = "Select City") },
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(
//                    expanded = expanded
//                )
//            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors()
//            , modifier = Modifier.fillMaxWidth()
//        )
//
//        // filter options based on text field value
//        val filteringOptions =
//            listItems.filter { it.contains(selectedItem, ignoreCase = true) }
//
//        if (filteringOptions.isNotEmpty()) {
//            ExposedDropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false }
//            ) {
//                filteringOptions.forEach { selectionOption ->
//                    DropdownMenuItem(
//                        onClick = {
//                            selectedItem = selectionOption
//                            expanded = false
//                        },
//                        text = { Text(text = selectionOption) }
//                    )
//                }
//            }
//        }
//    }
// }

@Composable
fun genericContactPerson() {
    Card(Modifier.padding(12.dp)) {
        Text(text = "Contact Person", fontSize = 20.sp)
        genericEditText(
            text = "",
            label = "Enter Person Name",
            onClick = {}
        )
        genericEditText(
            text = "",
            label = "Enter Contact No.",
            onClick = {},
            inputType = KeyboardType.Number
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericInputChip(
    lable: String = "Defualt Text",
    icon: ImageVector = Icons.TwoTone.WaterDrop
): Boolean {
    val selected = remember { mutableStateOf(false) }
    InputChip(
        selected = selected.value,
        onClick = { selected.value = !selected.value },
        label = { Text(text = lable) },
        leadingIcon = {
            Image(icon, contentDescription = null)
        },
        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
    )
    return selected.value
}

@Preview(showSystemUi = true)
@Composable
private fun a() {
    genericDropDown()
}

fun retrunListOfCites(): List<String> {
    val cites = listOf("Delhi", "Mumbai", "Kolkata", "Bangalore", "Chennai", "Hyderabad", "Pune", "Ahmedabad", "Allahabad", "Surat", "Lucknow", "Jaipur", "Cawnpore", "Mirzapur", "Nagpur", "Ghaziabad", "Vadodara", "Vishakhapatnam", "Indore", "Thane", "Bhopal", "Patna", "Bilaspur", "Ludhiana", "Agra", "Kalyan", "Madurai", "Jamshedpur", "Nasik", "Faridabad", "Aurangabad", "Rajkot", "Meerut", "Jabalpur", "Dhanbad", "Varanasi", "Srinagar", "Amritsar", "Aligarh", "Guwahati", "Bhilai", "Haora", "Ranchi", "Gwalior", "Bezwada", "Chandigarh", "Jodhpur", "Mysore", "Raipur", "Kota", "New Delhi", "Bareilly", "Coimbatore", "Solapur", "Trichinopoly", "Hubli", "Jalandhar", "Bhubaneshwar", "Moradabad", "Kolhapur", "Thiruvananthapuram", "Bhiwandi", "Saharanpur", "Warangal", "Salem", "Malegaon", "Kochi", "Gorakhpur", "Shimoga", "Guntur", "Tiruppur", "Raurkela", "Mangalore", "Nanded", "Cuttack", "Tumkur", "Chanda", "Dehra Dun", "Durgapur", "Asansol", "Bhavnagar", "Nellore", "Amravati", "Ajmer", "Tinnevelly", "Bikaner", "Agartala", "Ujjain", "Ulhasnagar", "Jhansi", "Davangere", "Jammu", "Belgaum", "Gulbarga", "Jamnagar", "Dhulia", "Gaya", "Jalgaon", "Kurnool", "Udaipur", "Bellary", "Sangli", "Tuticorin", "Calicut", "Akola", "Bhagalpur", "Quilon", "Sikar", "Bhatpara", "Kakinada", "Bhilwara", "Nizamabad", "Panihati", "Parbhani", "Rohtak", "Latur", "Rajapalaiyam", "Ahmadnagar", "Rajahmundry", "Cuddapah", "Muzaffarpur", "Alwar", "Brahmapur", "Kamarhati", "Mathura", "Patiala", "Saugor", "Bijapur", "Shahjanpur", "Junagadh", "Trichur", "Barddhaman", "Purnea", "Sambalpur", "Firozabad", "Hisar", "Rampur", "Bali", "Panipat", "Aizawl", "Karimnagar", "Bhuj", "Ichalkaranji", "Hospet", "Bhatinda", "Sannai", "Barasat", "Ratlam", "Drug", "Handwara", "Imphal", "Anantapur", "Etawah", "Raichur", "Bharatpur", "Begusarai", "Sonipat", "Shrirampur", "Hapur", "Ramgundam", "Uluberiya", "Puducherry", "Porbandar", "Vizianagaram", "Pali", "Nadiad", "Nagercoil", "Karnal", "Puri", "Tanjore", "Secunderabad", "Sambhal", "Shiliguri", "Naihati", "Shimla", "Kharagpur", "Dindigul", "Ingraj Bazar", "Ongole", "Ellore", "Haldia", "Gurgaon", "Bulandshahr", "Baharampur", "Chakradharpur", "Madhyamgram", "Burhanpur", "Khammam", "Bhiwani", "Ghandinagar", "Hugli", "Mahbubnagar", "Nandyal", "Raiganj", "Barakpur", "Mahesana", "Batala", "Bhusaval", "Bahraigh", "Tonk", "Sirsa", "Jaunpur", "Dam Dam", "Madanapalle", "Alleppey", "Vellore", "Titagarh", "Chandannagar", "Cuddalore", "Chirala", "Deo", "Bidar", "Machilipatnam", "Medinipur", "Baramula", "Fatehpur", "Tenali", "Udipi", "Sitalpur", "Conjeeveram", "Proddatur", "Navsari", "Godhra", "Budaun", "Chittoor", "Krishnanagar", "Bharuch", "Saharsa", "Haripur", "Pathankot", "Vidisha", "Nalgonda", "Balurghat", "Dibrugarh", "Veraval", "Fyzabad", "Silchar", "Shantipur", "Hindupur", "Erode", "Beawar", "Mauli", "Habra", "Ambala", "Etah", "Shillong", "Kolar", "Bhimavaram", "Mandsaur", "Kumbakonam", "Chicacole", "Tiruvannamalai", "Mandya", "Bankura", "Gondia", "Hassan", "Pilibhit", "Palghat", "Palakollu", "Abohar", "Kanchrapara", "Hanumangarh", "Hathras", "Basirhat", "Navadwip", "Guntakal", "Halisahar", "Rishra", "Baidyabati", "Dharmavaram", "Ghazipur", "Puruliya", "Darjeeling", "Gudivada", "Sopur", "Adilabad", "Narasaraopet", "Yavatmal", "Chittaurgarh", "Bansbaria", "Siddipet", "Valparai", "Osmanabad", "Champdani", "Khardah", "Bangaon", "Tadpatri", "Islamabad", "Jalpaiguri", "Suriapet", "Tadepallegudem", "Kalyani", "Negapatam", "Bundi", "Bhadreswar", "Chilakalurupet", "Port Blair", "Gangtok", "Dhulian", "Kohima", "Marmagao", "Jangipur", "Baj Baj", "Tanuku", "Siuri", "Tamluk", "Bankra", "Nagari", "Chakapara", "Itanagar", "Mundka", "Baruipur", "Mandapeta", "Bhimunipatnam", "Pithapuram", "Amalapuram", "Bodupal", "Gobardanga", "Diamond Harbour", "Daman", "Amudalavalasa", "Kankuria", "Pujali", "Chittaranjan", "Panaji", "Kaippakancheri", "Sankrail", "Elesvaram", "Tarakeswar", "Nibria", "Kuli", "Beldanga", "Saranga", "Jaynagar-Majilpur", "Panchla", "Mamidalapadu", "Jalhalli", "Poranki", "Sundararaopeta", "Bauria", "Dumjor", "Mahiari", "Mayahaura", "Dispur", "Malancha", "Raghudebbati", "Nahazari", "Giria", "Baharu", "Jagdispur", "Ramnagar", "Jaypul", "Dogachi", "Janai", "Bahagalpur", "Muragacha", "Chandi", "Saktipur", "Bhabanipur", "Bandlaguda", "Begampur", "Amtala", "Velivennu", "Begampur", "Kalinagar", "Natshal", "Chaital", "Dhamua", "Multi", "Chandpur", "Sahapur", "Amgachia", "Laskarpar", "Nimpot", "Harua", "Nazira", "Krishnapur", "Nalpur", "Mahadipur", "Iarpur", "Raspunji", "Nijgaon Paranpur", "Ballalpur", "Kavaratti", "Patra", "Chandnidaha", "Nabagram", "Hilora", "Imamnagar", "Serpur", "Dignagar", "Palta", "Beonta", "Andharmanik", "Balbalpara", "Bhandardaha", "Jajigram", "Alipur", "Burul", "Purbba Ramnagar", "Bansabati", "Bodai", "Uttarbhag", "Gacha", "Gotra", "Bamanpukur", "Padmarha", "Ramkrishnapur", "Iswaripur", "Nadabhanga", "Bishnupur", "Bhasa", "Bodra", "Tinsukia", "Khambhat", "Aurangabad", "Chakdaha", "Contai", "Rayachoti", "Kavali", "Mancheral", "Kairana", "Kadiri", "Madgaon", "Ootacamund", "Faridkot", "Anakapalle", "Garulia", "Sirsilla", "Katoya", "Kamareddipet", "Bolpur", "Gumla", "Simdega", "Kottagudem", "Koch Bihar", "Bodhan", "Karur", "Mangalagiri", "Bapatla", "Markapur", "Malaut", "Badvel", "Jorhat", "Basavakalyan", "Beypore", "Bishnupur", "Koratla", "Pulivendla", "Alipur Duar", "Jaisalmer", "Tadepalle", "Gadwal", "Jatani", "Kodad", "Nawalgarh", "Armur", "Jhargram", "Wanparti", "Chamrajnagar", "Ponnuru", "Chandralapadu", "Vinukonda", "Tezpur", "Narasapur", "Panskura", "Rampur Hat", "Lonavale", "Samalkot", "Kalna", "Kothapet", "Macherla", "Kandukur", "Sattenapalle", "Bobbili", "Vrindavan", "Gangarampur", "Kandi", "Belampalli", "Pithoragarh", "Puttur", "Islampur", "Punganuru", "Nandod", "Palmaner", "Jalor", "Kaliyaganj", "Vikarabad", "Baduria", "Dholka", "Tuni", "Jaggayyapeta", "Venkatagiri", "Sihor", "Jangaon", "Mandamari", "Diu", "Metpalli", "Repalle", "Peddapuram", "Bhadrachalam", "Ajodhya", "Bhainsa", "Prattipadu", "Jasdan", "Vuyyuru", "Nandikotkur", "Dhupgari", "Jammalamadugu", "Rameswaram", "Murshidabad", "Sainthia", "Charkhi Dadri", "Nandigama", "Nidadavole", "Addanki", "Nilothi", "Mahbubabad", "Berubari", "Akbarpur", "Karsiyang", "Rajgir", "Nalhati", "Memari", "Rajaori", "Pileru", "Peddapalli", "Naini Tal", "Kovvur", "Channarayapatna", "Maihar", "Junnar", "Kalimpong", "Atmakur", "Solan", "Vetapalem", "Taki", "Betamcherla", "Penumur", "Dwarka", "Kadiyam", "Dubrajpur", "Pathanamthitta", "Sitalkuchi", "Dalkola", "Ichchapuram", "Mahe", "Kanigiri", "Dinhata", "Huzurnagar", "Kodaikanal", "Udhampur", "Vempalle", "Medchal", "Uravakonda", "Guskhara", "Yellandu", "Giddalur", "Balarampur", "Angamali", "Vemalwada", "Narsipatnam", "Shrirangapattana", "Shamsabad", "Almora", "Kondapalle", "Debagram", "Fatehpur Sikri", "Jamikunta", "Darsi", "Umaria", "Kovur", "Erraguntla", "Naspur", "Kalyandrug", "Mangur", "Tummapala", "Pedana", "Pandua", "Lalgola", "Mussoorie", "Margram", "Podili", "Uran", "Mainaguri", "Egra", "Leh", "Chimakurti", "Koratgi", "Garaimari", "Devarkonda", "Pattikonda", "Atmakur", "Sonamukhi", "Khunti", "Nakrekal", "Kodumur", "Srungavarapukota", "Kalwakurti", "Banswada", "Silvassa", "Kotagiri", "Ramanayyapeta", "Tanguturu", "Varandarapilli", "Payakaraopeta", "Penukonda", "Bandipura", "Suluru", "Panchanandapur", "Pamidi", "Gilarchat", "Guruzala", "Narasannapeta", "Chintalapudi", "Renigunta", "Kottapeta", "Raghunathpur", "Attili", "Gajwel", "Singarayakonda", "Avanigadda", "Khed Brahma", "Aklvidu", "Mogalturru", "Balarampur", "Gorantla", "Mummidivaram", "Khajuraho", "Ashwaraopeta", "Yadiki", "Kosigi", "Chandrakona", "Gauripur", "Koilkuntla", "Bagula", "Kulgam", "Velugodu", "Asafabad", "Abu", "Singur", "Curchorem", "Pushkar", "Bukkarayasamudram", "Ganapavaram", "Pamarru", "Chagallu", "Sarapaka", "Pakala", "Maruturu", "Husnabad", "Kuppam", "Madakasira", "Mailavaram", "Tufanganj", "Nellimarla", "Kosgi", "Kaikalur", "Tehata", "Parkal", "Chagalamarri", "Umrapur", "Krishnapur", "Kattanam", "Nizampatam", "Gannavaram", "Ghatkesar", "Palashi", "Palkonda", "Andal", "Achampet", "Banganapalle", "Kamalapuram", "Vinjamur", "Karlapalem", "Nalua", "Mundra", "Chandragiri", "Marahra", "Sompeta", "Belur", "Kanniyakumari", "Namburu", "Ramjibanpur", "Kakdwip", "Kanekallu", "Jhalida", "Jaggampeta", "Dharmsala", "Somandepalle", "Sirvar", "Chinna Ganjam", "Srikhanda", "Narapala", "Badkulla", "Chilkuru", "Chautapal", "Rampur", "Tiruvur", "Bhagabanpur", "Jadcherla", "Mellacheruvu", "Tadikonda", "Rajmahal", "Debipur", "Kulu", "Vissannapeta", "Kotta Kalidindi", "Vayalpad", "Veldurti", "Maripad", "Belakoba", "Panchgram", "Inkollu", "Manthani", "Pernamitta", "Gokavaram", "Kembhavi", "Phirangipuram", "Kasimkota", "Dighirpar", "Dharmapuri", "Challapalle", "Kottapeta", "Bahutal", "Penugonda", "Mahalandi", "Gonegandla", "Gokarna", "Rentachintala", "Kamavarapukota", "Barnia", "Ramayampet", "Podalakur", "Chopadandi", "Khed", "Kompalle", "Khirpai", "Kolluru", "Mitrapur", "Islampur", "Bhagwangola", "Galivedu", "Raikal", "Kota", "Chennur", "Sultanabad", "Sanatikri", "Tadikalapudi", "Patapatnam", "Balkonda", "Porumamilla", "Kallur", "Udayagiri", "Kolakaluru", "Vontimitta", "Seven Pagodas", "Utnur", "Undi", "Hariharpara", "Vijayapuri North", "Antarvedi", "Viraghattam", "Chilamatturu", "Maddikera", "Tondangi", "Kambaduru", "Kohir", "Pyapali", "Haldibari", "Muttukuru", "Cumbum", "Relangi", "Konarka", "Putaparti", "Dattapulia", "Bara", "Antarvedipalem", "Chipurupalle", "Kankipadu", "Sindhnur", "Yellareddi", "Hanamsagar", "Cherrapunji", "Bikkavolu", "Madanpur", "Holalagondi", "Odlabari", "Kottavalasa", "Penuganchiprolu", "Bhanukumari", "Kottacheruvu", "Lingal", "Korangal", "Dornakal", "Barjora", "Unguturu", "Domkonda", "Karempudi", "Amaravati", "Belpukur", "Undrajavaram", "Daulatnagar", "Peddavadlapudi", "Yedapalli", "Tezu", "Duvva", "Bhimadolu", "Rajnagar", "Dundigal", "Sabang", "Kumirimora", "Chityal", "Kathevaram", "Polavaram", "Champadanga", "Kaladgi", "Paruchuru", "Ghoradal", "Uppada", "Nallajerla", "Amrabad", "Ponduru", "Sabbavaram", "Kollipara", "Patiram", "Gopalnagar", "Kankandighi", "Cossimbazar", "Panchgani", "Tirmaigiri", "Bichkunda", "Kalikiri", "Peddakurapadu", "Turbihal", "Panjipara", "Jami", "Duvvuru", "Venkatagirikota", "Kumarkhali", "Domahani", "Gurgunta", "Lokapur", "Kharar", "Battulapalle", "Parigi", "Kotra", "Mudhol", "Sirur", "Kesabpur", "Nagar", "Motkur", "Damarcherla", "Kaviti", "Madugula", "Karvetnagar", "Pebberu", "Pittalavanipalem", "Betma", "Karedu", "Dubak", "Savalgi", "Gundugolanu", "Kankon", "Chamarru", "Namchi", "Ichora", "Gopalpur", "Nandipeta", "Buttayagudem", "Doddanahalli", "Duggirala", "Sher Muhammadpuram", "Ghambiraopet", "Mangalkot", "Khem Karan", "Sonada", "Bukkapatnam", "Khargram", "Fakirtaki", "Prattipadu", "Chennur", "Antardipa", "Tetagunta", "Amarapuuram", "Mirik", "Kalipatnam", "Biknur", "Denduluru", "Pedda Adsarlapalli", "Tanakallu", "Chebrolu", "Allur", "Ganapavaram", "Lakhipur", "Pedda Vegi", "Falimari", "Edlapadu", "Doranala", "Balupur", "Krosuru", "Bara Belun", "Ambhua", "Rudra Nagar", "Kautalam", "Karanchedu", "Meghraj", "Nagalapuram", "Mayureswar", "Narayanavanam", "Talsur", "Dammapeta", "Kushmanchi", "Owk", "Kurabalakota", "Nandavaram", "Rajanagaram", "Amarchinta", "Kundurpi", "Srikrishnapur", "Kalakada", "Orchha", "Satyavedu", "Muzaffarnagar", "Fatehpur", "Rambilli", "Mortad", "Ramchandrapur", "Bhagirathpur", "Konakondla", "Kodmial", "Kadur Sahib", "Bhattiprolu", "Sonakhal", "Nekarikallu", "Naliya", "Ravutulapudi", "Patrasaer", "Perali", "Galsi", "Nalgora", "Sankhavaram", "Allahdurg", "Kasba", "Talupula", "Rolla", "Chota Mollakhali", "Ganga Sagar", "Kamargani", "Draksharama", "Pudimadaka", "Nallamada", "Ramabhadrapuram", "Kamalapuram", "Sangam", "Nadendla", "Petua", "Besagarahalli", "Chandur", "Karapa", "Akhnur", "Janapul", "Karimpur", "Pragadavaram", "Tripurantakam", "Munagapaka", "Chinnamandem", "Kattipudi", "Daulatpur", "Ketugram", "Koppaka", "Gok", "Gudlavalleru", "Kotur", "Komarolu", "Valaparla", "Jaipur", "Paikpara", "Narkatpalli", "Lakkireddipalle", "Khasbalanda", "Telkapalli", "Devanakonda", "Potavaram", "Para", "Borgampad", "Lepakshi", "Kirlampudi", "Samalpur", "Somireddipalle", "Mungod", "Kottapalem", "Ramannapeta", "Dhantola", "Lingampet", "Reddigudem", "Kanakpur", "Datian", "Srisailain", "Panasapadu", "Roddam", "Kalinagar", "Ganapavaram", "Belagola", "Manteswar", "Bellamkonda", "Bomareddipalli", "Kilkunda", "Tulin", "Manubolu", "Hadiaya", "Honwada", "Satgachia", "Basudebpur", "Elurupadu", "Malior", "Chunakhali", "Muragacha", "Panchgara", "Gopalpur", "Dhanwada", "Kinhalu", "Bilaspur", "Chilakhana", "Lakhya", "Kalaikunda", "Nutakki", "Ahmadpur", "Barwan", "Santamaguluru", "Dodarasinakere", "Pagidyala", "Zafargarh", "Kathia", "Kattamuru", "Kaikaram", "Konidena", "Dunigram", "Uppalaguptam", "Muddanuru", "Gandlapenta", "Dumargram", "Mashat", "Uppugunduru", "Udburu", "Dattapara", "Jujharpur", "Bhogapuram", "Kaliganj", "Nirna", "Damargidda", "Ayas", "Rajapudi", "Durgi", "Molagavalli", "Bahira", "Penaballi", "Gorsa", "Jajireddigudem", "Nagayalanka", "Maddur", "Bishnupur", "Saktigarh", "Munagala", "Kurichedu", "Belakvadi", "Nurpur", "Bhaluka", "Alipukur", "Chaubaria", "Kotabommali", "Guttikonda", "Dirusumarru", "Kotalpur", "Jigarhati", "Tummalacheruvu", "Dharmajigudem", "Kovvali", "Bhogalt", "Maisaram", "Hingalganj", "Gudluru", "Bandamurlanka", "Kalicherla", "Mustafabad", "Channubanda", "Islampur", "Ranjal", "Keregodu", "Gampalagudem", "Pullalacheruvu", "Makkuva", "Madnur", "Harike", "Adigoppula", "Panuria", "Chitvel", "Talgachhi", "Jagatballabhpur", "Kismatpur", "Kalkuni", "Barasat", "Teranikallu", "Virapalle", "Vidapanakallu", "Navipet", "Jasaikati", "Bhagabatipur", "Manipur", "Raiparthi", "Bagalvad", "Bontapalli", "Devarkadra", "Garbham", "Churulia", "Anantasagaram", "Yaragol", "Penumaka", "Chintakommadinne", "Korukollu", "Ginigera", "Udramsar", "Nakkapalle", "Gangajalghati", "Tungaturti", "Majlispur", "Peddapudi", "Chikhli", "Madnakal", "Galgali", "Kodakandla", "Chandpur", "Vidavaluru", "Gummadidola", "Khajuri", "Tamballapalle", "Ravinutala", "Tekmal", "Berghom", "Vijayapuri South", "Konada", "Dignagar", "Jagannathpur", "Bibinagar", "Venavanka", "Rangampeta", "Rodalkundi", "Kotturu", "Kethepalli", "Dupadu", "Chandipur", "Maliara", "Khandaghosh", "Kirugavalu", "Karatber", "Kolleti Kota", "Chiwemla", "Takkellapadu", "Dhanbela", "Dommaranandyala", "Anigandlapadu", "Kavuluru", "Danagalli", "Naushahra Panwan", "Nallacheruvu", "Peddakadaburu", "Palakurti", "Timmapuram", "Ravipadu", "Lakhanpur", "Pippara", "Chiluvuru", "Kaligiri", "Mulakalacheruvu", "Birkur", "Gopalganj", "Rebala", "Nandivelugu", "Bhatumra", "Bhandarhati", "Tulluru", "Narayanpur", "Niala Kondapalle", "Yazali", "Beraberi", "Gopalpur", "Mahishkuchi", "Pedda Ganjam", "Uchalon", "Huliyurdurga", "Nekunapuram", "Pokuru", "Bhadrapur", "Manali", "Mallepalli", "Baruipara", "Natavaram", "Agali", "Barua Gopalpur", "Surampalle", "Bara Bakra", "Dhalpal", "Bajanki", "Garladinne", "Hire Kotankal", "Datura", "Wajrakarur", "Indrani", "Pata Pandillapalle", "Rajavommangi", "Sante Kasalgere", "Mundlapadu", "Haripur", "Bujang", "Hatinda", "Mantur", "Kirnahar", "Baireddipalle", "Mathampalli", "Pachipenta", "Radhangar", "Meliyaputtu", "Baishata", "Damaramadugu", "Kruttivennu", "Bestavarapeta", "Namkhana", "Muglispur", "Sheakhala", "Ramasamudram", "Bargari", "Chelyama", "Palagara", "Gura", "Adwitnagar", "Ponnaluru", "Khatra", "Belsur", "Polaki", "Yadamari", "Chataparru", "Mulaguntapadu", "Nirmanvi", "Raniganj", "Krishnaranpur", "Upputuru", "Annaram", "Simlapal", "Gosanimari Bandar", "Chinnakakani", "Chilakapalem", "Nigan", "Bijnapalli", "Pipa", "Chandrasekharapuram", "Chennekottapalle", "Fatehpor", "Mogallu", "Beluguppa", "Rajbari", "Parakaram", "Chevella", "Karumanchi", "Belluru", "Bandi Atmakuru", "Khanta", "Kotauratla", "Havaligi", "Chintalavalasa", "Polba", "Mudinepalle", "Kurupam", "Hire Padsalgi", "Valigonda", "Sayampet", "Sibkalinagar", "Pedda Bhogila", "Kodekal", "Bagdaha", "Umarpur", "Battili", "Katangur", "Kunchanapalle", "Kalingapatnam", "Aspari", "Nekkonda", "Karalapadu", "Rudravaram", "Rangaipur", "Cherukuru", "Ramapur", "Ramthenga", "Devaruppal", "Morta", "Kennalu", "Dhola", "Bharatgarh", "Digambarpur", "Annavaram", "Topla", "Holavanhalli", "Arakeri", "Bagchara", "Dornipadu", "Kamarpalli", "Lingasamudram", "Mallarpur", "Muppalla", "Badampudi", "Maipadu", "Bagela", "Kandrakota", "Khopakati", "Dwarapudi", "Malkapuram", "Mohanpur", "Chaudepalle", "Sasan", "Madhura", "Katak Chincholi", "Amarkantak", "Kalla", "Salgundi", "Kongal", "Mohanpur", "Lakkavaram", "Vempa", "Bantumilli", "Kantalia", "Rimbik", "Morgim", "Palhalli", "Bondapalle", "Pulipadu", "Beliator", "Paidipadu", "Mandirtala", "Kanaganapalle", "Tipparti", "Etikoppaka", "Gadivemula", "Tarachua", "Kandlagunta", "Mudivarti", "Obuladevarcheruvu", "Dariapur", "Murarai", "Maddipadu", "Amadaguru", "Kondavidu", "Matsyapuri", "Moragudi", "Karimnagar", "Timmapuram", "Brahmanagudem", "Hebbur", "Elangi", "Palsa", "Ventrapragada", "Mandadam", "Kotananduru", "Ellanuru", "Sidhar", "Baswa", "Digalgram", "Kandaran", "Kavuru", "Kasimpur", "Balatgi", "Banpur", "Dumpagadapa", "Racherla", "Galaga", "Mahurapur", "Andimatam", "Begunkudar", "Kottapalle", "Gobindapur", "Kandgal", "Tallacheruvu", "Ramchandrapur", "Manoharpur", "Ratua", "Raipur", "Kodur", "Natabari Hat", "Bhelian", "Nizampur", "Baruva", "Khulna", "Kariali", "Kyadgeri", "Narathali", "Jakranpalli", "Nangli", "Algur", "Dodharye", "Bandhkhola", "Gavunipalli", "Phulbari", "Kanamarlapudi", "Harispur", "Peravali", "Rentapalla", "Kochcherla", "Narendranagar", "Ardavidu", "Elakkurichchi", "Mirkal", "Sathaur", "Varadayyapalaiyam", "Jejur", "Venkatakrishnarayapuram", "Jhikra", "Duttaluru", "Durgapur", "Khanta", "Karavadi", "Jagdeopur", "Chapirevula", "Somala", "Mehegram", "Khedra", "Uppalapadu", "Kukunuru", "Onda", "Muratpur", "Pedda Nandipadu", "Bhujabalapatnam", "Chopra", "Sandhwan", "Talgram", "Chinna Chintakunta", "Bhastara", "Ramakuppam", "Kottakki", "Nandigram", "Harvi", "Loutolim", "Kuderu", "Kalavalapalle", "Kondramutla", "Bajargaon", "Pusapatirega", "Kyalanur", "Attota", "Bisor", "Sarenga", "Kochara", "Murikipudi", "Medpalli", "Khata", "Musunuru", "Timmasamudram", "Chejerla", "Nirman", "Mirle", "Radhanagar", "Fatehpur", "Bhulki", "Ankapuram", "Tarapur", "Hatgacha", "Kerimeri", "Terlam", "Sakkarepatna", "Mungonda", "Bandarlapalli", "Bevur", "Konanki", "Ranasthalam", "Birajnagar", "Labpur", "Tummurukota", "Tondapi", "Kothakota", "Benior", "Nandalur", "Valluru", "Kakumanu", "Churakuti", "Panagarh", "Natalapadu", "Ambarpeta", "Majiyara", "Goyamara", "Pullampet", "Masarkal", "Sitarampuram", "Gajapatinagaram", "Hattikuni", "Putalapattu", "Kuvagam", "Rhenok", "Kondamanjuluru", "Addatigala", "Yelmanaid", "Chillakur", "Kotipalle", "Kaldhari", "Lingadahalli", "Golugonda", "Budhakhali", "Kosuvaripalle", "Pedda Orampadu", "Jaldhoa", "Kalmali", "Gottipadu", "Putluru", "Kapileswarapuram", "Utukur", "Sabakpur", "Piridi", "Goli", "Pogiri", "Indiri", "Barabari", "Lingareddipalem", "Singareni", "Mejia", "Tarlupadu", "Gopavaram", "Rayna", "Tadimarri", "Kistnapatam", "Karepalli", "Harirampur", "Fatehgarh Panjtur", "Pegadpalli", "Chinna Pandraka", "Matmari", "Lakshmisagar", "Kundapak", "Kallankurichchi", "Peddaravidu", "Puncha", "Gudipudi", "Cherlagudipadu", "Ramadugu", "Gote", "Vellalacheruvu", "Komarada", "Nujendla", "Lansdowne", "Dagadarti", "Bhrigubanda", "Kumargram", "Basudha", "Jukal", "Mantada", "Nambulapulikunta", "Kunaparajuparva", "Dandepalii", "Dammalapadu", "Vanamaladinne", "Kalavakuru", "Ramasamudram", "Virannapalem", "Sitampeta", "Gudivakalanka", "Hamidi", "Gazulmandiyam", "Burda", "Gosaba", "Mustur", "Korukonda", "Aripanthan", "Maddikera Agraharam", "Kolavennu", "Chingarali", "Veguru", "Nandavaram", "Nagareddipet", "Chandragudem", "Gorubathan", "Thode", "Rolugunta", "Velagaleru", "Sayipeta", "Byadanur", "Kulumur", "Talamarla", "Bandarupalle", "Machareddi", "Peddapasupula", "Reddicherla", "Manyapadu", "Samse", "Virapapur", "Kasipet", "Gundrevula", "Rebna", "Atluru", "Tirupati", "Rudravaram", "Tuggali", "Mulakalapalle", "Somapalle", "Mallavaram", "Venkatapuram")
    return cites
}
