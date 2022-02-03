package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class EngFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_eng, container, false)

        val btn1 = view.findViewById<ImageButton>(R.id.eng1)
        val btn2 = view.findViewById<ImageButton>(R.id.eng2)
        val btn3 = view.findViewById<ImageButton>(R.id.eng3)
        val btn4 = view.findViewById<ImageButton>(R.id.eng4)
        val btn5 = view.findViewById<ImageButton>(R.id.eng5)
        val btn6 = view.findViewById<ImageButton>(R.id.eng6)
        val btn7 = view.findViewById<ImageButton>(R.id.eng7)
        val btn8 = view.findViewById<ImageButton>(R.id.eng8)
        val btn9 = view.findViewById<ImageButton>(R.id.eng9)
        val btn10 = view.findViewById<ImageButton>(R.id.eng10)


        btn1.setOnClickListener { onSelectEng1() }
        btn2.setOnClickListener { onSelectEng2() }
        btn3.setOnClickListener { onSelectEng3() }
        btn4.setOnClickListener { onSelectEng4() }
        btn5.setOnClickListener { onSelectEng5() }
        btn6.setOnClickListener { onSelectEng6() }
        btn7.setOnClickListener { onSelectEng7() }
        btn8.setOnClickListener { onSelectEng8() }
        btn9.setOnClickListener { onSelectEng9() }
        btn10.setOnClickListener { onSelectEng10() }

        return view
    }

    private fun onSelectEng1() {
        val n1 = "eng1"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng2() {
        val n1 = "eng2"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng3() {
        val n1 = "eng3"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng4() {
        val n1 = "eng4"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng5() {
        val n1 = "eng5"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng6() {
        val n1 = "eng6"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng7() {
        val n1 = "eng7"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng8() {
        val n1 = "eng8"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng9() {
        val n1 = "eng9"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

    private fun onSelectEng10() {
        val n1 = "eng10"
        val i = Intent(activity, FoodDetail::class.java)
        i.putExtra("nch", n1)
        startActivity(i)
    }

}