package com.swu.foodyummy

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawerLayout: DrawerLayout? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.nav_view)

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().replace(R.id.Fragment_container, HomeFragment())
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_draw_open,
            R.string.navigation_draw_close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.Fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.home)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, HomeFragment()).commit()
            R.id.thai -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, ThaiFragment()).commit()
            R.id.eng -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, EngFragment()).commit()
            R.id.dessert -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, DessertFragment()).commit()
            R.id.random -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, RandomFragment()).commit()
            R.id.resnear -> supportFragmentManager.beginTransaction()
                .replace(R.id.Fragment_container, NearMe()).commit()
        }
        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}