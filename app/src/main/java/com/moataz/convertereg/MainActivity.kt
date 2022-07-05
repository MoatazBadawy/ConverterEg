package com.moataz.convertereg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moataz.convertereg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            convertEgyInput()
        }
    }

    private fun convertEgyInput() {
        val textFromEgyInput = binding.EGYInput.text.toString()
        val convertEgyInputToDouble = textFromEgyInput.toDouble()
        val egyResult = egyToDollar(egy = convertEgyInputToDouble)
        binding.DollarInput.setText(egyResult.toString())
    }

    private fun convertUSAInput() {
        val textFromUSAInput = binding.DollarInput.text.toString()
        val convertUSAInputToDouble = textFromUSAInput.toDouble()
        val usaResult = dollarToEgy(dollar = convertUSAInputToDouble)
        binding.EGYInput.setText(usaResult.toString())
    }

    private fun egyToDollar(egy: Double, dollar: Double = 0.053): Double {
        return egy * dollar
    }

    private fun dollarToEgy(egy: Double = 18.53, dollar: Double): Double {
        return dollar * egy
    }
}