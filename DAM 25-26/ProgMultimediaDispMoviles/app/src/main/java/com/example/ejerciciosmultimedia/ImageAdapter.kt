package com.example.ejerciciosmultimedia

import android.content.Context
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context, private val imageUris: List<Uri>) : BaseAdapter() {

    override fun getCount(): Int = imageUris.size

    override fun getItem(position: Int): Any = imageUris[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView = convertView as? ImageView ?: ImageView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                120 // Altura fija para miniaturas
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        imageView.setImageURI(imageUris[position])
        return imageView
    }
}