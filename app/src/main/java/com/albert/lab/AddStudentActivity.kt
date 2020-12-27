package com.albert.lab

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class AddStudentActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAddress: EditText
    private lateinit var rdMale: RadioButton
    private  lateinit var rdFemale: RadioButton
    private lateinit var etMobile: EditText
    private lateinit var btnSubmit: Button
    var gender = "Male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        bind()

        rdFemale.setOnClickListener {
            gender = "Female"
        }
        rdMale.setOnClickListener {
            gender = "Male"
        }
        btnSubmit.setOnClickListener {
            val p: Person = Person(etName.text.toString(),
                etAddress.text.toString(),
                gender,
                etMobile.text.toString())
            var intent = intent
            println(p)

            intent.putExtra("data", p)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun bind() {
        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        rdMale = findViewById(R.id.rdMale)
        rdFemale = findViewById(R.id.rdFemale)
        etMobile = findViewById(R.id.etMobile)
        btnSubmit = findViewById(R.id.btnSubmit)
    }

}