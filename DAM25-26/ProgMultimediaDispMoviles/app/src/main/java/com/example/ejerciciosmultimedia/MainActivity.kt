package com.example.ejerciciosmultimedia

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var imageViewSelected: ImageView
    private lateinit var textViewPath: TextView

    private var imageUris: MutableList<Uri> = mutableListOf()
    private var imagePaths: MutableList<String> = mutableListOf()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            loadImages()
        } else {
            Toast.makeText(this, "Permiso denegado. No se pueden cargar imágenes.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridViewImages)
        imageViewSelected = findViewById(R.id.imageViewSelected)
        textViewPath = findViewById(R.id.textViewPath)

        checkPermissionsAndLoadImages()

        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedUri = imageUris[position]
            imageViewSelected.setImageURI(selectedUri)
            textViewPath.text = "Ruta de la imagen: ${imagePaths[position]}"
        }
    }

    private fun checkPermissionsAndLoadImages() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        when {
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED -> {
                loadImages()
            }
            else -> {
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    private fun loadImages() {
        imageUris.clear()
        imagePaths.clear()

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA
        )

        val cursor: Cursor? = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val pathColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)

            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toString())
                val path = it.getString(pathColumn)
                imageUris.add(uri)
                imagePaths.add(path)
            }
        }

        if (imageUris.isNotEmpty()) {
            val adapter = ImageAdapter(this, imageUris)
            gridView.adapter = adapter
        } else {
            Toast.makeText(this, "No se encontraron imágenes.", Toast.LENGTH_SHORT).show()
        }
    }
}