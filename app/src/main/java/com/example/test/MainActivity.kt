package com.example.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sumButton.setOnClickListener {
            if (firstNumber.text.isEmpty() || secondNumber.text.isEmpty()) {
                showSnackbar(it, "Some field is empty")
                return@setOnClickListener
            }

            val firstVal = firstNumber.text.toString().toIntOrNull(10)
            val secondVal = secondNumber.text.toString().toIntOrNull(10)

            if (firstVal == null || secondVal == null) {
                showSnackbar(it, "Some number is wrong")
                return@setOnClickListener
            }

            val result = "Result: " + (firstVal + secondVal).toString()
            resultText.text = result

            showSnackbar(it, result)
        }
    }

    private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}