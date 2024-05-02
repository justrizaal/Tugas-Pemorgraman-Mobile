package com.example.inputtelepon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val phoneNumberEditText: EditText = findViewById<EditText>(R.id.phoneNumberEditText)
        val submitButton: Button = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString()

            // Validasi nomor telepon
            if (isValidPhoneNumber(phoneNumber)) {
                // Nomor telepon valid, lakukan sesuatu di sini
                // Contoh: Tampilkan pesan atau lanjutkan ke aktivitas berikutnya
                showToast("Nomor telepon valid: $phoneNumber")
            } else {
                // Nomor telepon tidak valid, berikan pesan kesalahan
                //phoneNumberEditText.error = "Nomor telepon tidak valid"//
                showToast("Nomor telepon tidak valid")
            }
        }
    }
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Validasi nomor telepon sesuai dengan kebutuhan aplikasi Anda
        // Di sini, kita akan memeriksa apakah panjang nomor telepon adalah 10 digit
        return phoneNumber.length >= 10
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}