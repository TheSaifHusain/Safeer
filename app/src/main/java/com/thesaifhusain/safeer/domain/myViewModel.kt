package com.thesaifhusain.safeer.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thesaifhusain.safeer.data.MainData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class myViewModel @Inject constructor(
    val repo: FirestoreRepository
) : ViewModel() {

    fun insertMasjid(item: MainData.MasjidData) = viewModelScope.launch {
        repo.insertMasjid(item)
    }

}
