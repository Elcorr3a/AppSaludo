package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnHello:AppCompatButton = findViewById(R.id.BtnHello)


        btnHello.setOnClickListener{
            val etName:AppCompatEditText = findViewById(R.id.etName)
            val name = etName.text.toString()
            //Log.i("Test","Boton pulsado")
            //Toast.makeText(this, "Hola $name!", Toast.LENGTH_LONG).show()
            /*if(name.isNotEmpty()){
                Snackbar.make(btnHello, "Hola $name!", Snackbar.LENGTH_SHORT).setAnchorView(btnHello).setAction("CLOSE"){finishAffinity()}.show()
                etName.setText(null)
            }*/
            val intentGA = Intent(this, MainActivity2::class.java)
            intentGA.putExtra("EXTRA_NAME", name)
            startActivity(intentGA)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}