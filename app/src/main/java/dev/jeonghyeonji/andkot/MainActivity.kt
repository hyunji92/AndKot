package dev.jeonghyeonji.andkot

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private val toolbar by lazy {
        findViewById(R.id.toolbar) as Toolbar
    }

    val fab1 by lazy {
        findViewById(R.id.fab_1) as FloatingActionButton
    }
    val fab2 by lazy {
        findViewById(R.id.fab_2) as FloatingActionButton
    }
    val fab3 by lazy {
        findViewById(R.id.fab_3) as FloatingActionButton
    }

    internal val show_fab_1: Animation? = null
    internal var hide_fab_1: Animation? = null
    internal var show_fab_2: Animation? = null
    internal var hide_fab_2: Animation? = null
    internal var show_fab_3: Animation? = null
    internal var hide_fab_3: Animation? = null

    private var FAB_Status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener({

            //Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()
            if (FAB_Status == false) {
                //Display FAB menu
                expandFAB()
                FAB_Status = true
            } else {
                //Close FAB menu
                hideFAB()
                FAB_Status = false
            }
        })

        val fab1 = findViewById(R.id.fab_1) as FloatingActionButton
        fab1.setOnClickListener({

        })
        val fab2 = findViewById(R.id.fab_2) as FloatingActionButton
        fab2.setOnClickListener({

        })
        val fab3 = findViewById(R.id.fab_3) as FloatingActionButton
        fab3.setOnClickListener({

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {

            R.id.action_settings -> return true

            R.id.action_profile -> return true
        }

        return super.onOptionsItemSelected(item)
    }


    private fun expandFAB() {
        //Floating Action Button 1
        val layoutParams = fab1.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab1.getWidth() * 1.7) as Int
        layoutParams.bottomMargin += (fab1.getHeight() * 0.25) as Int
        fab1.setLayoutParams(layoutParams)
        fab1.startAnimation(show_fab_1)
        fab1.setClickable(true)
        //Floating Action Button 2
        val layoutParams2 = fab2.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams2.rightMargin += (fab2.getWidth() * 1.5) as Int
        layoutParams2.bottomMargin += (fab2.getHeight() * 1.5) as Int
        fab2.setLayoutParams(layoutParams2)
        fab2.startAnimation(show_fab_2)
        fab2.setClickable(true)
        //Floating Action Button 3
        val layoutParams3 = fab3.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams3.rightMargin += (fab3.getWidth() * 0.25) as Int
        layoutParams3.bottomMargin += (fab3.getHeight() * 1.7) as Int
        fab3.setLayoutParams(layoutParams3)
        fab3.startAnimation(show_fab_3)
        fab3.setClickable(true)
    }

    private fun hideFAB() {
        //Floating Action Button 1
        val layoutParams = fab1.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab1.getWidth() * 1.7) as Int
        layoutParams.bottomMargin -= (fab1.getHeight() * 0.25) as Int
        fab1.setLayoutParams(layoutParams)
        fab1.startAnimation(hide_fab_1)
        fab1.setClickable(false)
        //Floating Action Button 2
        val layoutParams2 = fab2.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams2.rightMargin -= (fab2.getWidth() * 1.5) as Int
        layoutParams2.bottomMargin -= (fab2.getHeight() * 1.5) as Int
        fab2.setLayoutParams(layoutParams2)
        fab2.startAnimation(hide_fab_2)
        fab2.setClickable(false)
        //Floating Action Button 3
        val layoutParams3 = fab3.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams3.rightMargin -= (fab3.getWidth() * 0.25) as Int
        layoutParams3.bottomMargin -= (fab3.getHeight() * 1.7) as Int
        fab3.setLayoutParams(layoutParams3)
        fab3.startAnimation(hide_fab_3)
        fab3.setClickable(false)
    }
}
