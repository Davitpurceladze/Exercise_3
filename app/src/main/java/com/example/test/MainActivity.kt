package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            informationVisibility()
        }

        binding.btnClear.setOnClickListener {
            clearInputs()
        }

        binding.btnAgain.setOnClickListener {
            resetProgram()
        }
    }

    private fun resetProgram() {
        clearInputs()
        binding.etFirstName.visibility = View.VISIBLE
        binding.tvFirstName.visibility = View.GONE

        binding.etLastName.visibility = View.VISIBLE
        binding.tvLastName.visibility = View.GONE

        binding.etEmail.visibility = View.VISIBLE
        binding.tvEmail.visibility = View.GONE

        binding.etUsername.visibility = View.VISIBLE
        binding.tvUsername.visibility = View.GONE

        binding.etAge.visibility = View.VISIBLE
        binding.tvAge.visibility = View.GONE

        binding.etCountry.visibility = View.VISIBLE
        binding.tvCountry.visibility = View.GONE

        binding.btnAgain.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
        binding.btnClear.visibility = View.VISIBLE

    }

    private fun informationVisibility( ) {
            if(validations()){
                profileInfoVisibility()
                binding.btnAgain.visibility = View.VISIBLE
                binding.btnSave.visibility = View.GONE
                binding.btnClear.visibility = View.GONE
            }
    }

    private fun validations(): Boolean {
        return  (firstNameValidation() && lastNameValidation() &&
                emailValidation() && usernameValidation() && ageValidation() && countryValidation())
    }

    private fun clearInputs() {
        binding.etFirstName.text?.clear()
        binding.etLastName.text?.clear()
        binding.etEmail.text?.clear()
        binding.etUsername.text?.clear()
        binding.etAge.text?.clear()
        binding.etCountry.text?.clear()
    }



    private fun profileInfoVisibility(){
//        First Name information visibility
        val firstNameValue: Editable? = binding.etFirstName.text
        binding.etFirstName.visibility = View.GONE
        binding.tvFirstName.text = firstNameValue
        binding.tvFirstName.visibility = View.VISIBLE

//        Last Name information visibility
        val lastNameValue: Editable? = binding.etLastName.text
        binding.etLastName.visibility = View.GONE
        binding.tvLastName.text = lastNameValue
        binding.tvLastName.visibility = View.VISIBLE

//        Email information visibility
        val emailValue: Editable? = binding.etEmail.text
        binding.etEmail.visibility = View.GONE
        binding.tvEmail.text = emailValue
        binding.tvEmail.visibility = View.VISIBLE

//        Username information visibility
        val usernameValue: Editable? = binding.etUsername.text
        binding.etUsername.visibility = View.GONE
        binding.tvUsername.text = usernameValue
        binding.tvUsername.visibility = View.VISIBLE

//        Age information visibility
        val ageValue: Editable? = binding.etAge.text
        binding.etAge.visibility = View.GONE
        binding.tvAge.text = ageValue
        binding.tvAge.visibility = View.VISIBLE

//        Country information visibility
        val countryValue: Editable? = binding.etCountry.text
        binding.etCountry.visibility = View.GONE
        binding.tvCountry.text = countryValue
        binding.tvCountry.visibility = View.VISIBLE


    }

    private fun firstNameValidation( ): Boolean{
        val firstNameValue: Editable? = binding.etFirstName.text

        return if(firstNameValue?.length.toString().toInt() <= 0) {
            Toast.makeText(this, "First Name have to filled", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun lastNameValidation( ): Boolean {
        val lastNameValue: Editable? = binding.etLastName.text

        return if(lastNameValue?.length.toString().toInt() <= 0) {
            Toast.makeText(this, "Last Name have to filled", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun emailValidation(): Boolean {
        val emailValue: Editable? = binding.etEmail.text
        val email = emailValue.toString()

        return if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Email example: example@gmail.com", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun usernameValidation(): Boolean{
        val usernameValue: Editable? = binding.etUsername.text

        return if(usernameValue.toString().length < 10) {
            Toast.makeText(this, "Username have to be more than 10 character", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun ageValidation( ): Boolean{
        val ageValue: Editable? = binding.etAge.text
        return if( ageValue?.length.toString().toInt() <= 0 ) {

            Toast.makeText(this, "Age field have to filled", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun countryValidation( ): Boolean{
        val countryValue: Editable? = binding.etCountry.text
        return if( countryValue?.length.toString().toInt() <= 0 ) {

            Toast.makeText(this, "Country field have to filled", Toast.LENGTH_LONG).show()
            false
        } else true
    }


}