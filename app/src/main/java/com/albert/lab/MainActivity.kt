package com.albert.lab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var person: MutableList<Person> = mutableListOf()
    private lateinit var lvPerson: ListView
    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvMobile: TextView
    private lateinit var btnAdd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val intent = intent
//        val data = intent.getSerializableExtra("data")

        bind()

//        var test = listOf<String>("test", "123")

        btnAdd.setOnClickListener {
            startActivityForResult(Intent(this, AddStudentActivity::class.java),200)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 200 && resultCode == Activity.RESULT_OK){

            var tmp = data?.getSerializableExtra("data")
            println(tmp)
            person.add(tmp as Person)

            var adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                person
            )
            lvPerson.adapter = adapter
            lvPerson.setOnItemClickListener { parent, view, position, id ->
                val data = parent.getItemAtPosition(position).toString()
                tvName.text = person[id.toInt()].name
                tvAddress.text = person[id.toInt()].address
                tvGender.text = person[id.toInt()].gender
                tvMobile.text = person[id.toInt()].mobile
            }
        }
    }
    private fun bind(){
        lvPerson = findViewById(R.id.lvPerson)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobile = findViewById(R.id.tvMobile)
        btnAdd = findViewById(R.id.btnAdd)
//        reset
        tvName.text = ""
        tvAddress.text = ""
        tvGender.text = ""
        tvMobile.text = ""
    }
}