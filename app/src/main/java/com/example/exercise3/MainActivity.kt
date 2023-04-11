package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.exercise3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        createSpinner()

        binding.calculate.setOnClickListener{
            calculate()
        }
    }

    private fun createSpinner(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.ageSpinner.adapter = adapter
    }

    private fun calculate(){
        var price = 0
        if(binding.genderRadioGroup.checkedRadioButtonId != -1){
            if(binding.ageSpinner.selectedItem == "16 and below"){
                price = 60
            } else if(binding.ageSpinner.selectedItem == "17-25"){
                price = 70
                if(binding.maleRadioButton.isChecked){
                    price += 70
                }
                if(binding.smokerCheckbox.isChecked){
                    price += 100
                }
            } else if(binding.ageSpinner.selectedItem == "26-30"){
                price = 90
                if(binding.maleRadioButton.isChecked){
                    price += 100
                }
                if(binding.smokerCheckbox.isChecked){
                    price += 150
                }
            } else if(binding.ageSpinner.selectedItem == "31-40"){
                price = 120
                if(binding.maleRadioButton.isChecked){
                    price += 150
                }
                if(binding.smokerCheckbox.isChecked){
                    price += 200
                }
            } else if(binding.ageSpinner.selectedItem == "41-55"){
                price = 150
                if(binding.maleRadioButton.isChecked){
                    price += 200
                }
                if(binding.smokerCheckbox.isChecked){
                    price += 250
                }
            } else {
                price = 150
                if(binding.maleRadioButton.isChecked){
                    price += 200
                }
                if(binding.smokerCheckbox.isChecked){
                    price += 300
                }
            }

            val resultString = "Your insurance total is : \n RM $price"
            binding.result.text = resultString
        } else {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
        }
    }
}