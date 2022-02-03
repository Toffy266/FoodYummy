package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*


class RandomResult2 : AppCompatActivity() {
    var ranButton: Button? = null
    var ranAgain: Button? = null
    var imagerandom: ImageView? = null
    private var textrandom: TextView? = null
    var custom: RelativeLayout? = null
    var bg: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_result2)

        ranButton = findViewById(R.id.clicktorandom)
        ranAgain = findViewById(R.id.inputagain)
        imagerandom = findViewById(R.id.eatthis)
        textrandom = findViewById(R.id.eatfood)
        custom = findViewById(R.id.inputcustom)
        bg = findViewById(R.id.bginput)

        val d = intent.getStringExtra("mch")

        if(d == "custom") {
            custom!!.visibility = View.VISIBLE
            bg!!.setBackgroundColor(R.drawable.bginput)
        }


        var foodNameRan: Array<String>? = null
        var value: String? = null

        ranAgain!!.setOnClickListener {
            custom!!.visibility = View.VISIBLE
            bg!!.setBackgroundColor(R.drawable.bginput)
        }

        ranButton!!.setOnClickListener {
            val random = Random()
            custom!!.visibility = View.GONE
            bg!!.setBackgroundColor(0x00000000)
            var input = findViewById<EditText>(R.id.editText)
            value = input.text.toString()
            foodNameRan = value!!.split("," , " ", ";", "\n").toTypedArray()
            Toast.makeText(applicationContext, "รอซักครู่...", Toast.LENGTH_LONG).show()
            val n = random.nextInt(foodNameRan!!.size)
            val nch = foodNameRan!![n]
            imagerandom!!.background = ContextCompat.getDrawable(applicationContext, R.drawable.random3);
            textrandom?.text = nch
        }

    }
}