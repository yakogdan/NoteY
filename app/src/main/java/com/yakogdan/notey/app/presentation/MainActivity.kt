package com.yakogdan.notey.app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.yakogdan.notey.R
import com.yakogdan.notey.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
//    private val navController by lazy { findNavController(R.id.fragment_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    override fun onBackPressed() {
//        if (!navController.popBackStack()) {
//            super.onBackPressed()
//        }
//    }
}