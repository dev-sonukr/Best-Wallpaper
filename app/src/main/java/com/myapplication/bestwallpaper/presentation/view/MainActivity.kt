package com.myapplication.bestwallpaper.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.myapplication.bestwallpaper.databinding.ActivityMainBinding
import com.myapplication.bestwallpaper.domain.entities.WallpaperLink
import com.myapplication.bestwallpaper.presentation.WallpaperUiState
import com.myapplication.bestwallpaper.presentation.adapter.RecycleViewAdapter
import com.myapplication.bestwallpaper.presentation.viewmodel.WallpaperViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val wallpaperViewModel: WallpaperViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        collectUiState()
        wallpaperViewModel.fetchWallpeper()
    }

    private fun setupViews(){
        binding.ImagesRecyclerView.apply {
            layoutManager = GridLayoutManager(context,2)
        }
    }

    private fun collectUiState(){
        lifecycleScope.launch(Dispatchers.Main){
            wallpaperViewModel.wallpaperList.collect(){ wallpaperUistate ->
                when(wallpaperUistate){
                    is WallpaperUiState.Loading ->{
                        binding.progressbar.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, "Wallpapers are currently empty", Toast.LENGTH_SHORT).show()
                    }is WallpaperUiState.EmptyList ->{
                        binding.progressbar.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, "Wallpapers are Loading", Toast.LENGTH_SHORT).show()
                    }is WallpaperUiState.Success ->{
                        binding.progressbar.visibility = View.GONE
                        populateDataInRecyclerView(wallpaperUistate.data)
                    }is WallpaperUiState.Error ->{
                        Toast.makeText(this@MainActivity, "Error comes Bro ", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun populateDataInRecyclerView(list:List<WallpaperLink>){
        val  wallpaperAdapter = RecycleViewAdapter(list)
        binding.ImagesRecyclerView.adapter = wallpaperAdapter
    }
}