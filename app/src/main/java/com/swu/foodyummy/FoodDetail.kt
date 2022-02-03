package com.swu.foodyummy

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FoodDetail : AppCompatActivity() {
    var playY: Button? = null
    var playM: Button? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        head = findViewById(R.id.fb_menutext)
        how = findViewById(R.id.takehowto)
        igd = findViewById(R.id.fb_ingred)
        png = findViewById(R.id.fb_iconfood)
        playY = findViewById(R.id.btn_yt)
        playM = findViewById(R.id.btn_map)

        GlobalScope.launch(Dispatchers.Main) {
            val d = intent.getStringExtra("nch")
            takeData(d)

            playM!!.setOnClickListener {
                val i = Intent(applicationContext, Maps::class.java)
                val tlat: Double? = mmf?.getLat()
                val tlng: Double? = mmf?.getLng()
                val rname: String? = mmf?.getRname()
                i.putExtra("rn", rname)
                i.putExtra("lat", tlat)
                i.putExtra("lng", tlng)
                startActivity(i)
            }
            playY!!.setOnClickListener {
                val i =  Intent(Intent.ACTION_VIEW, Uri.parse(mmf?.getYt()))
                startActivity(i)
            }
        }

    }

    private suspend fun takeData(a: String?) = withContext(Dispatchers.IO){
        FirebaseApp.initializeApp(applicationContext)
        val f = FirebaseDatabase.getInstance()
        dbf = f.reference
        dbf!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(@NonNull dataSnapshot: DataSnapshot) {
                val map = dataSnapshot.child("Food").child(a!!).value as Map<*, *>?
                val namef = map!!["name"].toString()
                val howto = map["howto"].toString()
                val igd = map["ingredient"].toString()
                val urly = map["link"].toString()
                val urlp = map["img"].toString()
                val nlat = map["lat"].toString()
                val lat = nlat.toDouble()
                val nlng = map["lng"].toString()
                val lng = nlng.toDouble()
                val rName = map["rname"].toString()
                mmf = MenuFood(namef, howto, igd, urly, rName, lat, lng)
                head?.text = mmf!!.getName()
                how?.text = mmf!!.getHow()
                Companion.igd?.text = mmf!!.getIgd()
                Picasso.with(applicationContext).load(urlp).into(png)
            }

            override fun onCancelled(@NonNull databaseError: DatabaseError) {}
        })
    }

    companion object {
        var dbf: DatabaseReference? = null
        var mmf: MenuFood? = null
        @SuppressLint("StaticFieldLeak")
        var head: TextView? = null
        @SuppressLint("StaticFieldLeak")
        var how: TextView? = null
        @SuppressLint("StaticFieldLeak")
        var igd: TextView? = null
        @SuppressLint("StaticFieldLeak")
        var png: ImageView? = null
    }
}