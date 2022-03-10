package com.mogakko.secretmemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mogakko.secretmemo.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnConfirm.setOnClickListener {
            val email = binding.edtInputEmail.text.toString()
            val password = binding.edtInputPassword.text.toString()
            if (email == "koolunkle@test.com") {
                if (password == "koolunkle") {
                    val myIntent = Intent(mContext, MemoActivity::class.java)
                    startActivity(myIntent)
                    finish()
                    Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(mContext, "로그인 실패: 비밀번호 오류", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(mContext, "로그인 실패: 이메일 오류", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {

    }
}