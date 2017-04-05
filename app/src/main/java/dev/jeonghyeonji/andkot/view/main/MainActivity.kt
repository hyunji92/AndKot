package dev.jeonghyeonji.andkot.view.main

import android.animation.Animator
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import dev.jeonghyeonji.andkot.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fab_layout.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onClick(v: View?) {
        when(v) {
            fab_1 -> Toast.makeText(applicationContext,"와아아앙", 1)

            fab_2 -> Toast.makeText(applicationContext,"와아아앙", 2)

            fab_3 -> Toast.makeText(applicationContext,"와아아앙", 3)
        }
    }
    private var FAB_Status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recycler_view.layoutManager = GridLayoutManager(this, 3)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener({

            if (!FAB_Status) {
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
}
