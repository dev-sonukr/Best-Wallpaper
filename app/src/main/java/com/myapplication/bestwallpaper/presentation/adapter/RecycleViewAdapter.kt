package com.myapplication.bestwallpaper.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapplication.bestwallpaper.R
import com.myapplication.bestwallpaper.domain.entities.WallpaperLink

class RecycleViewAdapter(private var dataSet: List<WallpaperLink>) :
      RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val imageView: AppCompatImageView

        init {
            imageView = view.findViewById(R.id.ImageView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }
//    2nd data set ke lie
//    fun setItems(dataSet: List<WallpaperLink>) {
//        this.dataSet = dataSet
//    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = dataSet[position]
        Glide.with(viewHolder.imageView.context)
             .load(dataSet[position].wallpaperLink)
             .into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}