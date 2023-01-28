package com.example.samrab

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    var pref: SharedPreferences?=null
    lateinit var res:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        res=findViewById(R.id.counterText)
        pref=getSharedPreferences("Table", MODE_PRIVATE)
        counter=pref?.getInt("counter",0)!!
        res.text=counter.toString()
    }

    fun up(view: View) {
        counter++
        res.text=counter.toString()
    }
    fun down(view: View) {
        counter--
        res.text=counter.toString()
    }
    fun save(view: View){
        saveData(counter)
    }
    fun saveData(resultat:Int) {
        val editor = pref?.edit()
        editor?.putInt("counter", resultat)
        editor?.apply()
    }
}