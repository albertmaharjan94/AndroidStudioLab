package com.albert.lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class Lab6 : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etMobile: EditText
    private lateinit var rdMale: RadioButton
    private lateinit var rdFemale: RadioButton
    private lateinit var btnSubmit: Button
    private var counter = 0
    var person = arrayListOf<Person>()
    private var gender = "MALE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6)
        bind()

        btnSubmit.setOnClickListener{
            val p = Person(
                etName.text.toString(),
                etAddress.text.toString(),
                etMobile.text.toString(),
                gender
            )
            person.add(p)
            startActivity(Intent(this, ListViewActivity::class.java).putExtra("person", person))



        }
        rdMale.setOnClickListener{
            gender = "MALE"
        }
        rdFemale.setOnClickListener{
            gender = "FEMALE"
        }
    }
    
    private fun bind(){
        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rdMale = findViewById(R.id.rdMale)
        rdFemale = findViewById(R.id.rdFemale)
        btnSubmit = findViewById(R.id.btnSubmit)
    }
}