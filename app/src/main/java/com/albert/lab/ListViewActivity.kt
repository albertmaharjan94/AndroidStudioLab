package com.albert.lab

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity : AppCompatActivity() {

    private var person = mutableListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val intent = intent
        person.add(intent.getSerializableExtra("person") as Person)
        val tvDesc: TextView = findViewById(R.id.tvDesc)


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            person
        )


        val lvName: ListView = findViewById(R.id.lvName)
        lvName.adapter = adapter


        lvName.setOnItemClickListener { parent, view, position, id ->
            val p = parent.getChildAt(position).toString()
            tvDesc.text = "${person[id.toInt()].Name}\n" +
                    "Address: ${person[id.toInt()].Address}\n" +
                    "Gender: ${person[id.toInt()].Gender}\n" +
                    "Mobile: ${person[id.toInt()].Mobile}\n"

        }

    }
}