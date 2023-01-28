package com.example.samrab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class InputActivity : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var pass:EditText
    val pattern=("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        mail=findViewById(R.id.emailText)
        pass=findViewById(R.id.passwordText)
    }

    fun emailValid(text:String):Boolean{
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun input(view: View) {
        if (mail.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty())
        {
            if (emailValid(mail.text.toString()))
            {
                val intent = Intent(this@InputActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "ошибка при заполнении поля email",
                Toast.LENGTH_LONG).show()
            }

        }
        else{
            Toast.makeText(this, "заполните текстовые поля",
            Toast.LENGTH_LONG).show()
        }
    }
}