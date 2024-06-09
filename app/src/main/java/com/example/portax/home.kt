package com.example.portax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class home : AppCompatActivity() {
    var LQr: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Menggunakan CardView di sini, bukan Button
        LQr = findViewById<CardView>(R.id.Qr)
        LQr?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@home, com.example.portax.Qr::class.java)
            startActivity(i)
            finish()
        })
    }
}
