package com.example.kotlinfirst.ui.second

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinfirst.MainActivity
import com.example.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getData()
        putData()
    }

    companion object {
        const val KEY: String = "key"
    }


    private fun putData() {
        btn_second_activity.setOnClickListener {
            if (edit_text_second_activity.text.toString().isEmpty()) {
                edit_text_second_activity.error = R.string.error_for_edittext.toString()
            } else {
                setResult(
                    Activity.RESULT_OK,
                    Intent(this, MainActivity::class.java).putExtra(
                        KEY,
                        edit_text_second_activity.text.toString()
                    )
                )
                edit_text_second_activity.setText("")
                finish()
            }
        }
    }

    private fun getData() {
        val intent = intent
        text_view_second_activity.text = intent.getStringExtra(KEY)
    }
}