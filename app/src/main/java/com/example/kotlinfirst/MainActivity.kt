package com.example.kotlinfirst

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinfirst.ui.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result?.resultCode == Activity.RESULT_OK) {
                text_view_first_activity.text = result.data?.getStringExtra(SecondActivity.KEY)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        putData()
    }

    private fun putData() {
        btn_first_activity.setOnClickListener {
            if (edit_text_first_activity.text.toString().isEmpty()) {
                edit_text_first_activity.error = R.string.error_for_edittext.toString()
            } else {
                btn_first_activity.setOnClickListener {
                    activityResultLauncher.launch(
                        Intent(this, SecondActivity::class.java)
                            .putExtra(SecondActivity.KEY, edit_text_first_activity.text.toString())
                    )
                    edit_text_first_activity.setText("")
                }
            }
        }
    }

    private fun getData() {
        val intent = intent
        text_view_first_activity.text = intent.getStringExtra(SecondActivity.KEY)
    }
}