package com.github.bleszerd.mvvmexample.model

import android.net.Uri

data class PhotoCard(
    var photoUrl: Uri?,
    val photoName: String,
)
