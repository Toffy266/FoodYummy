package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class DessertFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dessert, container, false)

        val btn1 = view.findViewById<ImageButton>(R.id.dessert1)
        val btn2 = view.findViewById<ImageButton>(R.id.dessert2)
        val btn3 = view.findViewById<ImageButton>(R.id.dessert3)
        val btn4 = view.findViewById<ImageButton>(R.id.dessert4)
        val btn5 = view.findViewById<ImageButton>(R.id.dessert5)
        val btn6 = view.findViewById<ImageButton>(R.id.dessert6)
        val btn7 = view.findViewById<ImageButton>(R.id.dessert7)
        val btn8 = view.findViewById<ImageButton>(R.id.dessert8)
        val btn9 = view.findViewById<ImageButton>(R.id.dessert9)
        val btn10 = view.findViewById<ImageButton>(R.id.dessert10)

        btn1.setOnClickListener { onSelectDessert1() }
        btn2.setOnClickListener { onSelectDessert2() }
        btn3.setOnClickListener { onSelectDessert3() }
        btn4.setOnClickListener { onSelectDessert4() }
        btn5.setOnClickListener { onSelectDessert5() }
        btn6.setOnClickListener { onSelectDessert6() }
        btn7.setOnClickListener { onSelectDessert7() }
        btn8.setOnClickListener { onSelectDessert8() }
        btn9.setOnClickListener { onSelectDessert9() }
        btn10.setOnClickListener { onSelectDessert10() }

        return view
    }

    private fun onSelectDessert1() {
        val n1 = "dessert1"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert2() {
        val n1 = "dessert2"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert3() {
        val n1 = "dessert3"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert4() {
        val n1 = "dessert4"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert5() {
        val n1 = "dessert5"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert6() {
        val n1 = "dessert6"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert7() {
        val n1 = "dessert7"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert8() {
        val n1 = "dessert7"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert9() {
        val n1 = "dessert9"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectDessert10() {
        val n1 = "dessert10"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

}