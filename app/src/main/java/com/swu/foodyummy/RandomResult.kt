package com.swu.foodyummy

import android.os.Bundle
import android.widget.*
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import java.util.*


class RandomResult : AppCompatActivity() {
    var ranButton: Button? = null
    var imagerandom: ImageView? = null
    private var textrandom: TextView? = null
    var data: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_result)

        ranButton = findViewById(R.id.clicktorandom)
        imagerandom = findViewById(R.id.eatthis)
        textrandom = findViewById(R.id.eatfood)

        val d = intent.getStringExtra("mch")
        var foodNameRan = arrayOf<String>()


        ranButton!!.setOnClickListener {
            when (d) {
                "thai" -> {
                    foodNameRan = arrayOf("thai1", "thai2", "thai3", "thai4", "thai5",
                                            "thai6","thai7", "thai8", "thai9", "thai10")
                }
                "eng" -> {
                    foodNameRan = arrayOf("eng1", "eng2", "eng3", "eng4", "eng5",
                                            "eng6","eng7", "eng8", "eng9", "eng10")
                }
                "dessert" -> {
                    foodNameRan = arrayOf("dessert1", "dessert2", "dessert3", "dessert4", "dessert5",
                                            "dessert6","dessert7", "dessert8", "dessert9", "dessert10")
                }
            }

            val random = Random()
                val n = random.nextInt(foodNameRan.size)
                val nch = foodNameRan[n]
                Toast.makeText(applicationContext, "รอซักครู่...", Toast.LENGTH_LONG).show()
                ranPic(nch)
        }
    }

    private fun ranPic(nch: String?) {
        FirebaseApp.initializeApp(applicationContext)
        val fdb = FirebaseDatabase.getInstance()
        data = fdb.reference
        data!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(@NonNull dataSnapshot: DataSnapshot) {
                val map = dataSnapshot.child("Food").child(nch!!).value as Map<*, *>?
                val urlp = map!!["img"].toString()
                val name = map!!["name"].toString()
                textrandom?.text = name
                Picasso.with(applicationContext).load(urlp).into(imagerandom)
            }

            override fun onCancelled(@NonNull databaseError: DatabaseError) {}
        })
    }
}