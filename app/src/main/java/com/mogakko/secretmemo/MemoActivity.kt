package com.mogakko.secretmemo

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mogakko.secretmemo.databinding.ActivityMemoBinding

class MemoActivity : BaseActivity() {

    lateinit var binding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_memo)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.btnShare.setOnClickListener {
            val memo = binding.edtInputMemo.text.toString()
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, memo)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun setValues() {

    }
}