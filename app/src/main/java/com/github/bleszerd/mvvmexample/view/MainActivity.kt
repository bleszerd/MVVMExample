package com.github.bleszerd.mvvmexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.bleszerd.mvvmexample.databinding.ActivityMainBinding
import com.github.bleszerd.mvvmexample.viewmodel.PhotoCardViewModel

class MainActivity : AppCompatActivity() {

    private val photoCardViewModel = PhotoCardViewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        //Observers
        photoCardViewModel.activityToStart.observe(this, { intent ->
            startActivityForResult(intent, 0)
        })
        
        photoCardViewModel.photoCardModel.observe(this, { photoCard ->
            binding.imageView.setImageURI(photoCard.photoUrl)
            binding.textView.text = photoCard.photoName
        })


        //Listeners
        binding.root.setOnClickListener {
            photoCardViewModel.updatePhotoCard()
        }

        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == RESULT_OK){
            photoCardViewModel.updatePhotoCardData(data)
        }
    }
}