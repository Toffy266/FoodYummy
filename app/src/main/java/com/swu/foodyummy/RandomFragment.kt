package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class RandomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_random, container, false)

        val btn1 = view.findViewById<ImageButton>(R.id.thaifood)
        val btn2 = view.findViewById<ImageButton>(R.id.engfood)
        val btn3 = view.findViewById<ImageButton>(R.id.dessertfood)
        val btn4 = view.findViewById<ImageButton>(R.id.custom)

        btn1.setOnClickListener { onSelectRandom1() }
        btn2.setOnClickListener { onSelectRandom2() }
        btn3.setOnClickListener { onSelectRandom3() }
        btn4.setOnClickListener { onSelectRandom4() }

        return view
    }

    private fun onSelectRandom1() {
        val n1 = "thai"
        val i = Intent(activity, RandomResult::class.java)
        i.putExtra("mch", n1)
        startActivity(i)
    }

    private fun onSelectRandom2() {
        val n1 = "eng"
        val i = Intent(activity, RandomResult::class.java)
        i.putExtra("mch", n1)
        startActivity(i)
    }

    private fun onSelectRandom3() {
        val n1 = "dessert"
        val i = Intent(activity, RandomResult::class.java)
        i.putExtra("mch", n1)
        startActivity(i)
    }

    private fun onSelectRandom4() {
        val n1 = "custom"
        val i = Intent(activity, RandomResult2::class.java)
        i.putExtra("mch", n1)
        startActivity(i)
    }

}