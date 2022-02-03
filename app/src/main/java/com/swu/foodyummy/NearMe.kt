package com.swu.foodyummy

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class NearMe : Fragment() {
    private var mRecyclerView:RecyclerView? = null
    private var mAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    private var  mLayoutManager:RecyclerView.LayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout.fragment_near_me, container, false)

        mRecyclerView = v.findViewById(R.id.eventRecyclerView)
        mRecyclerView?.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(activity)
        mRecyclerView?.layoutManager = mLayoutManager

        GlobalScope.launch(Dispatchers.Main) {
            val preferences: SharedPreferences? = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val lat : String? = preferences?.getString("lat", "")
            val lng : String? = preferences?.getString("lng", "")
            if (lat != null && lng != null) {
                val result = httpGetEvents("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${lat},${lng}&radius=1000&type=restaurant|food|bakery|cafe&language=th&rankby=prominence&key=AIzaSyBp_8gCqlmlV5fmrIT0JYB-6OXKGW97Hm4")
                if (result!=null) parseJsonEvent(result)
            }
        }

        return v
    }

    //****** HTTP Request ******
    private suspend fun httpGetEvents(eventUrlStr: String):String? = withContext(Dispatchers.IO) {
        val eventUrl:URL = URL(eventUrlStr)
        val conn:HttpURLConnection = eventUrl.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.connect()

        val inStream:InputStream = conn.inputStream
        val inStreamReader:InputStreamReader = InputStreamReader(inStream, "UTF-8")
        val buffReader:BufferedReader = BufferedReader(inStreamReader)

        var sb:StringBuilder = StringBuilder()
        var line_read:String? = buffReader.readLine()
        while (line_read!=null) {
            sb.append(line_read)
            line_read = buffReader.readLine()
        }
        inStream.close()
        sb.toString()
    }

    //****** JSON Parsing ******
    private var eventObjects = ArrayList<JSONObject>()
    private fun parseJsonEvent(jsonStr:String)
    {
        eventObjects.clear()
        val eventArray = JSONObject(jsonStr)
        val eventJson = eventArray.getJSONArray("results")
        for (i in 0 until eventJson.length())
        {
            val eventObj = eventJson.getJSONObject(i)
            eventObjects.add(eventObj)
        }
        mAdapter = EventListAdapter(eventObjects)
        mRecyclerView?.adapter = mAdapter
    }

    //****** RecyclerView Management ******
    private class EventItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val resNameTxt:TextView = itemView.findViewById(R.id.resNameTxt)
        val rateTxt:TextView = itemView.findViewById(R.id.rateTxt)
        val reviewTxt:TextView = itemView.findViewById(R.id.reviewTxt)
        val addTxt:TextView = itemView.findViewById(R.id.addTxt)
        val openTxt:TextView = itemView.findViewById(R.id.openTxt)
    }

     class EventListAdapter(var eventObjects:ArrayList<JSONObject>):RecyclerView.Adapter<RecyclerView.ViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val viewInflater: LayoutInflater = LayoutInflater.from(parent.context)
            val entryView: View = viewInflater.inflate(R.layout.event_entry, parent, false)
            return EventItemViewHolder(entryView)
        }

        override fun getItemCount(): Int {
            return eventObjects.size
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  {
            val eventObj = eventObjects[position]
            var openStatus : String? = null

            val resName = eventObj.getString("name")
            val rate: Double = try {
                eventObj.getDouble("rating")
            } catch(a: JSONException) {
                0.00
            }
            val review: Int = try {
                eventObj.getInt("user_ratings_total")
            } catch(b: JSONException) {
                0
            }
            val address = eventObj.getString("vicinity")
            val open: Boolean? = try {
                eventObj.getJSONObject("opening_hours").getBoolean("open_now")
            } catch(c: JSONException) {
                false
            }
            val lat = eventObj.getJSONObject("geometry").getJSONObject("location").getDouble("lat")
            val lng = eventObj.getJSONObject("geometry").getJSONObject("location").getDouble("lng")


            openStatus = if(open == true) {
                "Open"
            } else {
                "Close"
            }

            if (holder is EventItemViewHolder)
            {
                val eventViewHolder:EventItemViewHolder = holder

                eventViewHolder.resNameTxt.text = resName
                eventViewHolder.rateTxt.text = rate.toString()+String(Character.toChars(0x2B50))
                eventViewHolder.reviewTxt.text = "\t($review รีวิว)"
                eventViewHolder.addTxt.text = address
                eventViewHolder.openTxt.text = openStatus

                eventViewHolder.addTxt.setOnClickListener { v ->
                    val context = v.context
                    val intent = Intent(context, Maps::class.java)
                    intent.putExtra("rn", resName)
                    intent.putExtra("lat", lat)
                    intent.putExtra("lng", lng)
                    context.startActivity(intent)
                }
            }
        }
    }
}