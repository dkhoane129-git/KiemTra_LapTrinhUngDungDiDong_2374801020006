package com.example.kiemtra_laptrinhungdungdidong_2374801020006

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Nhận dữ liệu Email từ LoginActivity
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL)
        tvEmail.text = "Email: $email"

        // Đăng xuất
        btnLogout.setOnClickListener { finish() }

        // Dữ liệu danh sách môn học
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Gắn ArrayAdapter với layout mẫu simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // Click item -> Toast tên phần tử
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Bạn đã chọn: ${subjects[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}