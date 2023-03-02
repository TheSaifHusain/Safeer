package com.thesaifhusain.safeer.data

import com.google.firebase.firestore.FirebaseFirestore
import com.thesaifhusain.safeer.domain.FirestoreRepository
import com.thesaifhusain.safeer.domain.ResultState
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirestoreRepositoryImpl @Inject constructor(private val db: FirebaseFirestore) :
    FirestoreRepository {

    override suspend fun insertMasjid(item: MainData.MasjidData): Flow<ResultState<String>> = callbackFlow {
        trySend(ResultState.Loading)
        db.collection(item.city).add(item).await()
    }

    override suspend fun getItems(): Flow<ResultState<MainData>> {
        TODO("Not yet implemented")
    }
}
