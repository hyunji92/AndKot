package dev.jeonghyeonji.andkot

import android.animation.Animator
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fab_layout.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onClick(v: View?) {
        when(v) {
            fab_1 -> Toast.makeText(applicationContext,"와아아앙", 1)

            fab_2 -> Toast.makeText(applicationContext,"와아아앙", 2)

            fab_3 -> Toast.makeText(applicationContext,"와아아앙", 3)
        }
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
        val coordinatorLayout = findViewById(R.id.coordinatorLayout) as CoordinatorLayout

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener({

            if (FAB_Status == false) {
                //Display FAB menu
                expand()
                FAB_Status = true
            } else {
                //Close FAB menu
                hide()
                FAB_Status = false
            }
        })

        fab_1.setOnClickListener(this)

        fab_2.setOnClickListener(this)

        fab_3.setOnClickListener(this)
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

    private fun expand() {
        fab_group.visibility = View.VISIBLE

        val dY = (fab.height + fab.height * 0.25).toFloat()

        fab_1.animate().translationY(-dY).start()
        fab_2.animate().translationY(-dY * 2).start()
        val animator = fab_3.animate().translationY(-dY * 3)
        animator.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            // scale  만 가지고 해본다 . object animation

            override fun onAnimationEnd(animation: Animator?) {
                fab_group.visibility = if (FAB_Status) View.VISIBLE else View.INVISIBLE
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        animator.start()
    }

    private fun hide() {
        fab_1.animate().translationY(0f).start()
        fab_2.animate().translationY(0f).start()
        fab_3.animate().translationY(0f).start()
    }


    private fun expandFAB() {
        //Floating Action Button 1
        val layoutParams = fab_1.layoutParams as FrameLayout.LayoutParams
        // layoutParams.rightMargin += (fab_1.width * 1.7).toInt()
        layoutParams.bottomMargin += (fab_1.height * 0.25).toInt()
        fab_1.layoutParams = layoutParams
        fab_1.startAnimation(show_fab_1)
        fab_1.isClickable = true

        //Floating Action Button 2
        val layoutParams2 = fab_2.layoutParams as FrameLayout.LayoutParams
        // layoutParams2.rightMargin += (fab_2.width * 1.5).toInt()
        layoutParams2.bottomMargin += (fab_2.height * 1.5).toInt()
        fab_2.layoutParams = layoutParams2
        fab_2.startAnimation(show_fab_2)
        fab_2.isClickable = true

        //Floating Action Button 3
        val layoutParams3 = fab_3.layoutParams as FrameLayout.LayoutParams
        // layoutParams3.rightMargin += (fab_3.width * 0.25).toInt()
        layoutParams3.bottomMargin += (fab_3.height * 1.7).toInt()
        fab_3.layoutParams = layoutParams3
        fab_3.startAnimation(show_fab_3)
        fab_3.isClickable = true
    }

    private fun hideFAB() {
        //Floating Action Button 1
        val layoutParams = fab_1.layoutParams as FrameLayout.LayoutParams
        // layoutParams.rightMargin -= (fab_1.width * 1.7).toInt()
        layoutParams.bottomMargin -= (fab_1.height * 0.25).toInt()
        fab_1.layoutParams = layoutParams
        fab_1.startAnimation(hide_fab_1)
        fab_1.isClickable = false

        //Floating Action Button 2
        val layoutParams2 = fab_2.layoutParams as FrameLayout.LayoutParams
        // layoutParams2.rightMargin -= (fab_2.width * 1.5).toInt()
        layoutParams2.bottomMargin -= (fab_2.height * 1.5).toInt()
        fab_2.layoutParams = layoutParams2
        fab_2.startAnimation(hide_fab_2)
        fab_2.isClickable = false

        //Floating Action Button 3
        val layoutParams3 = fab_3.layoutParams as FrameLayout.LayoutParams
        // layoutParams3.rightMargin -= (fab_3.width * 0.25).toInt()
        layoutParams3.bottomMargin -= (fab_3.height * 1.7).toInt()
        fab_3.layoutParams = layoutParams3
        fab_3.startAnimation(hide_fab_3)
        fab_3.isClickable = false
    }
}
