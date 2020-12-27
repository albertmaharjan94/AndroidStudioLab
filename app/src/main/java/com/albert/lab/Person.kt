package com.albert.lab

import java.io.Serializable

class Person constructor(val name: String, val address: String, val gender:String, val mobile: String): Serializable {
    override fun toString(): String {
        return name
    }
}