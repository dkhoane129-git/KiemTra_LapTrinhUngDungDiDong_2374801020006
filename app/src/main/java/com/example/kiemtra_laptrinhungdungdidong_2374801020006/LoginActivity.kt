package com.example.kiemtra_laptrinhungdungdidong_2374801020006

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { validateLogin() }
    }

    private fun validateLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        val error = when {
            email.isEmpty() && password.isEmpty() -> "Lỗi: Vui lòng nhập Email và Mật khẩu!"
            email.isEmpty() -> "Lỗi: Email không được để trống!"
            password.isEmpty() -> "Lỗi: Mật khẩu không được để trống!"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Lỗi: Email không đúng định dạng!"
            password.length < 6 -> "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
            else -> null
        }

        if (error != null) {
            tvStatus.setTextColor(Color.RED)
            tvStatus.text = error
            return
        }

        tvStatus.setTextColor(Color.parseColor("#2E7D32"))
        tvStatus.text = "Xác thực thành công!"
    }
}