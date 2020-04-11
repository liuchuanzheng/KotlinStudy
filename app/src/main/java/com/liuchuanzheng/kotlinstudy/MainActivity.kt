package com.liuchuanzheng.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var fruits = mutableListOf<Fruit>(
        Fruit("apple0"),
        Fruit("apple1"),
        Fruit("apple2"),
        Fruit("apple3"),
        Fruit("apple4"),
        Fruit("apple5")
    )
    val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            //让导航按钮显示出来
            it.setDisplayHomeAsUpEnabled(true)
            //设置导航按钮的图标
//            it.setHomeAsUpIndicator(R.mipmap.ic_launcher)
        }
        //否则nav里的item图标显示都是灰的
        nav.setItemIconTintList(null);
        fab.setOnClickListener{
            Snackbar.make(it,"hahah",Snackbar.LENGTH_SHORT)
                .setAction("no"){
                    Toast.makeText(this@MainActivity,"nonono",Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(20) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
