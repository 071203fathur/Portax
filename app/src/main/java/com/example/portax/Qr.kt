package com.example.portax

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.portax.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class Qr : AppCompatActivity() {
    var edit_input: EditText? = null
    var bt_generate: Button? = null
    var iv_qr: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        edit_input = findViewById<EditText>(R.id.edit_input)
        bt_generate = findViewById<Button>(R.id.bt_generate)
        iv_qr = findViewById<ImageView>(R.id.iv_qr)

        bt_generate?.let { button ->
            button.setOnClickListener { generateQR() }
        }
    }

    private fun generateQR() {
        val text = edit_input?.text.toString().trim { it <= ' ' }
        val writer = MultiFormatWriter()
        try {
            val matrix: BitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 600, 600)
            val encoder = BarcodeEncoder()
            val bitmap: Bitmap = encoder.createBitmap(matrix)
            iv_qr?.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }
}
