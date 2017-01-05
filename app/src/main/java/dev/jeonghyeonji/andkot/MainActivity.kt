package dev.jeonghyeonji.andkot

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
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

    internal val show_fab_1 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab1_show)
    }
    internal val hide_fab_1 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab1_hide)
    }
    internal val show_fab_2 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab2_show)
    }
    internal val hide_fab_2 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab2_hide)
    }
    internal val show_fab_3 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab3_show)
    }
    internal val hide_fab_3 by lazy {
        AnimationUtils.loadAnimation(this, R.anim.fab3_hide)
    }
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
        val layoutParams = fab1.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab1.width * 1.7).toInt()
        layoutParams.bottomMargin += (fab1.height * 0.25).toInt()
        fab1.layoutParams = layoutParams
        fab1.startAnimation(show_fab_1)
        fab1.isClickable = true

        //Floating Action Button 2
        val layoutParams2 = fab2.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin += (fab2.width * 1.5).toInt()
        layoutParams2.bottomMargin += (fab2.height * 1.5).toInt()
        fab2.layoutParams = layoutParams2
        fab2.startAnimation(show_fab_2)
        fab2.isClickable = true

        //Floating Action Button 3
        val layoutParams3 = fab3.layoutParams as FrameLayout.LayoutParams
        layoutParams3.rightMargin += (fab3.width * 0.25).toInt()
        layoutParams3.bottomMargin += (fab3.height * 1.7).toInt()
        fab3.layoutParams = layoutParams3
        fab3.startAnimation(show_fab_3)
        fab3.isClickable = true
    }

    private fun hideFAB() {
        //Floating Action Button 1
        val layoutParams = fab1.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab1.width * 1.7).toInt()
        layoutParams.bottomMargin -= (fab1.height * 0.25).toInt()
        fab1.layoutParams = layoutParams
        fab1.startAnimation(hide_fab_1)
        fab1.isClickable = false

        //Floating Action Button 2
        val layoutParams2 = fab2.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin -= (fab2.width * 1.5).toInt()
        layoutParams2.bottomMargin -= (fab2.height * 1.5).toInt()
        fab2.layoutParams = layoutParams2
        fab2.startAnimation(hide_fab_2)
        fab2.isClickable = false

        //Floating Action Button 3
        val layoutParams3 = fab3.layoutParams as FrameLayout.LayoutParams
        layoutParams3.rightMargin -= (fab3.width * 0.25).toInt()
        layoutParams3.bottomMargin -= (fab3.height * 1.7).toInt()
        fab3.layoutParams = layoutParams3
        fab3.startAnimation(hide_fab_3)
        fab3.isClickable = false
    }
}

