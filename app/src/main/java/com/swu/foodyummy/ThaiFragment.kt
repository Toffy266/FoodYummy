package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class ThaiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_thai, container, false)

        val btn1 = view.findViewById<ImageButton>(R.id.thai1)
        val btn2 = view.findViewById<ImageButton>(R.id.thai2)
        val btn3 = view.findViewById<ImageButton>(R.id.thai3)
        val btn4 = view.findViewById<ImageButton>(R.id.thai4)
        val btn5 = view.findViewById<ImageButton>(R.id.thai5)
        val btn6 = view.findViewById<ImageButton>(R.id.thai6)
        val btn7 = view.findViewById<ImageButton>(R.id.thai7)
        val btn8 = view.findViewById<ImageButton>(R.id.thai8)
        val btn9 = view.findViewById<ImageButton>(R.id.thai9)
        val btn10 = view.findViewById<ImageButton>(R.id.thai10)

        btn1.setOnClickListener { onSelectThai1() }
        btn2.setOnClickListener { onSelectThai2() }
        btn3.setOnClickListener { onSelectThai3() }
        btn4.setOnClickListener { onSelectThai4() }
        btn5.setOnClickListener { onSelectThai5() }
        btn6.setOnClickListener { onSelectThai6() }
        btn7.setOnClickListener { onSelectThai7() }
        btn8.setOnClickListener { onSelectThai8() }
        btn9.setOnClickListener { onSelectThai9() }
        btn10.setOnClickListener { onSelectThai10() }

        return view
    }

    private fun onSelectThai1() {
        val n1 = "thai1"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai2() {
        val n1 = "thai2"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai3() {
        val n1 = "thai3"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai4() {
        val n1 = "thai4"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai5() {
        val n1 = "thai5"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai6() {
        val n1 = "thai6"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai7() {
        val n1 = "thai7"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai8() {
        val n1 = "thai8"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai9() {
        val n1 = "thai9"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectThai10() {
        val n1 = "thai10"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

}