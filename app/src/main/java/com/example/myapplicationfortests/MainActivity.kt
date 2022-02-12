package com.example.myapplicationfortests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplicationfortests.databinding.ActivityMainBinding
import java.lang.StringBuilder

private const val START = 0.2
private const val STEP = 1.5
private const val SIZE = 7

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()
    private val oldArray = arrayOf<Double>(9.9, 3.9, 2.3, 0.1, 1.11, 5.6, 7.8, 0.3).toDoubleArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.valid_email),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val errorEmail = getString(R.string.invalid_email)
                    emailInput.error = errorEmail
                    Toast.makeText(this@MainActivity, errorEmail, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        fun generateArray(
            start: Double = START,
            step: Double = STEP,
            size: Int = SIZE
        ): DoubleArray {
            var generatedArray: DoubleArray = DoubleArray(size)
            for (i in 0 until size) {
                generatedArray[i] = start + i * step
            }
            println("Generated array:  ${generatedArray.asList()}")
            return generatedArray

        }

        val originalStringBuilderInstance = StringBuilder("Hi!")
        val stringBuilderCopiedInstance = StringBuffer(originalStringBuilderInstance)
        val nullableString = null
        val sameStringBuilder = originalStringBuilderInstance
    }
}
