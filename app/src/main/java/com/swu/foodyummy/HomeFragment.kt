package com.swu.foodyummy

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.*
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener


class HomeFragment : Fragment() {

    var imageArray:ArrayList<Int> = ArrayList()
    var carouselView: CarouselView? = null

    private val LOCATION_PERMISSION_REQ_CODE:Int = 111

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val gStatus:Int = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity)

        if (gStatus == ConnectionResult.SUCCESS)
        {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
            manageLocation()
        }
        else {
            Toast.makeText(activity, "Cannot Use Google Play", Toast.LENGTH_LONG).show()
        }

        imageArray.add(R.drawable.home1)
        imageArray.add(R.drawable.home2)
        imageArray.add(R.drawable.home3)
        imageArray.add(R.drawable.home4)
        imageArray.add(R.drawable.home5)

        carouselView = view.findViewById(R.id.carouselView)

        carouselView!!.pageCount = imageArray.size

        carouselView!!.setImageListener(imageListener)

        return view
    }

    var imageListener = ImageListener { position, imageView -> imageView.setImageResource(imageArray[position]) }

    //User Location
    private fun manageLocation() {
        if (ContextCompat.checkSelfPermission(activity!!, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED)
        {
            //permission missing, request it
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQ_CODE)
        }
        else
        {
            //permission granted
            val locationCb = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)
                    var last_location: Location? = p0?.lastLocation
                    if (last_location!=null)
                    {
                        val latUser = last_location.latitude.toString()
                        val lonUser = last_location.longitude.toString()
                        val preferences: SharedPreferences? = activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
                        val editor : SharedPreferences.Editor? = preferences?.edit()
                        editor?.putString("lat", latUser)
                        editor?.putString("lng", lonUser)
                        editor?.apply()
                    }
                }
            }
            val req = LocationRequest()
            req.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            req.interval = 0
            req.fastestInterval = 0
            fusedLocationClient.requestLocationUpdates(req, locationCb, null)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==LOCATION_PERMISSION_REQ_CODE && permissions.isNotEmpty())
        {
            var granted:Boolean = false
            for (i in permissions.indices)
            {
                if (permissions[i].equals(android.Manifest.permission.ACCESS_FINE_LOCATION)
                    && grantResults[i]== PackageManager.PERMISSION_GRANTED)
                {
                    // user grant permission
                    granted = true
                    manageLocation()
                    break
                }
            }
            if (!granted) {
                Toast.makeText(activity, "No permission to access location!", Toast.LENGTH_LONG).show()
            }
        }
    }

}
