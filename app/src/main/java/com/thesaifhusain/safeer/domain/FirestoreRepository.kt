package com.thesaifhusain.safeer.domain

import com.thesaifhusain.safeer.data.MainData
import kotlinx.coroutines.flow.Flow

interface FirestoreRepository {

    suspend fun insertMasjid(item: MainData.MasjidData): Flow<ResultState<String>>

    suspend fun getItems(): Flow<ResultState<MainData>>

}
