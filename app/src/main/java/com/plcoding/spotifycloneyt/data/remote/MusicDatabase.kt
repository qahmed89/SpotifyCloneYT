package com.plcoding.spotifycloneyt.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.plcoding.spotifycloneyt.data.entites.Song
import com.plcoding.spotifycloneyt.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)


    suspend fun getAllSongs():List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e :Exception){
            emptyList()
        }
    }
}