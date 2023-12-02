package com.ibsuleiman9.quotegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ibsuleiman9.quotegenerator.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
        }

        getQuote()
    }

    private fun getQuote() {
        setInprogress(true)

        GlobalScope.launch {
            try {
                val response = RetrofitInstance.quoteAPI.getRandomQuote()
            }catch (e : Exception){

            }
        }
    }

    private fun setInprogress(inProgress : Boolean){
        if(inProgress){
            binding.apply {
                progressBar.visibility = View.VISIBLE
                btnNext.visibility = View.GONE
            }
        }else{
            binding.apply {
                progressBar.visibility = View.GONE
                btnNext.visibility = View.VISIBLE
            }
        }
    }
}