package com.github.bleszerd.mvvmexample.viewmodel

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.bleszerd.mvvmexample.model.PhotoCard

class PhotoCardViewModel: ViewModel() {
    val photoCardModel = MutableLiveData<PhotoCard>()
    val activityToStart = MutableLiveData<Intent?>()

    fun updatePhotoCardData(data: Intent?) {
        photoCardModel.value = PhotoCard(data?.data, data?.data.toString())
    }

    fun updatePhotoCard() {
        val intent = Intent().apply {
            action = Intent.ACTION_PICK
            type = "image/*"
        }

        activityToStart.value = intent
    }
}