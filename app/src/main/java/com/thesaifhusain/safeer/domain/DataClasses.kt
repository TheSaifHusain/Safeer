package com.thesaifhusain.safeer.data

data class MainData(
    val place: String
) {
    data class MasjidData(
        val image: String,
        val city: String,
        val place: String,
        val address: String,
        val nearest: String,
        val pin: String,
        val contactPerson: String,
        val contact: String,
        val stay: String,
        val dailyJamat: Boolean,
        val ramdanOnlyJamat: Boolean,
        val woman: Boolean,
        val weeklyJamat: List<String>,
        val parking: List<String>,
    )
}
