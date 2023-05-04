package kz.kd.practice

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity() {

    private lateinit var tbDrawer: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var nvDrawer: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        initToolbar()
        initUpButton()
        initViews()
        initClickListeners()
        initActionBarDrawerToggle()
    }

    private fun initToolbar() {
        tbDrawer = findViewById(R.id.tb_navigation_drawer)
        setSupportActionBar(tbDrawer)
    }

    private fun initUpButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        drawerLayout = findViewById(R.id.drawer_layout)
        nvDrawer = findViewById(R.id.nvView)
    }

    private fun initClickListeners() {
        nvDrawer.setNavigationItemSelectedListener {
            Toast.makeText(this, "${it.title} was selected", Toast.LENGTH_SHORT).show()
            drawerLayout.close()
            true
        }
    }

    private fun initActionBarDrawerToggle() {
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, tbDrawer, R.string.nav_opened, R.string.nav_closed
        )
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        actionBarDrawerToggle.syncState()
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}