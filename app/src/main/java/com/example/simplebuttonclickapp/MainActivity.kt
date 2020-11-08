package com.example.simplebuttonclickapp

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
private const val Contents ="TextViewContents"
class MainActivity : AppCompatActivity() {

    private var textView: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText:EditText = findViewById(R.id.etBLANK)
        val Button:Button= findViewById(R.id.btnSUBMIT)

        textView =findViewById(R.id.tvRESULT)
        textView?.text=""
        textView?.movementMethod= ScrollingMovementMethod()




        Button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                textView?.append(editText.text)
                textView?.append("\n")
                editText.setText("")

            }
        })


    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text= savedInstanceState?.getString(Contents, "")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(Contents,textView?.text.toString())
    }
}


