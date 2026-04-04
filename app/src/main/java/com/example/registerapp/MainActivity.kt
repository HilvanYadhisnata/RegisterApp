package com.example.registerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

/**
 * MainActivity adalah entry point aplikasi.
 * Menginisialisasi tampilan dan meluncurkan RegisterActivity.
 *
 * @author Student
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktifkan edge-to-edge display untuk tampilan modern
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Langsung navigasi ke RegisterActivity
        val intent = android.content.Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
