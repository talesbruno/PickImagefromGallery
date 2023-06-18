package co.talesbruno.pickimagefromgallery.domain.repository

import android.net.Uri

interface SelectImage {
    suspend fun selectImage(): Uri?
}