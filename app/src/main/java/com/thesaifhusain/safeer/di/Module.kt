package com.thesaifhusain.safeer.di


import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.thesaifhusain.safeer.data.FirestoreRepositoryImpl
import com.thesaifhusain.safeer.domain.FirestoreRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun provideFirestoreDb() : FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirestoreRepo(impl :  FirestoreRepositoryImpl) : FirestoreRepository = impl
}