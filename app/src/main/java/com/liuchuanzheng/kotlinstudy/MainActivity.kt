package com.liuchuanzheng.kotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //否则nav里的item图标显示都是灰的
        nav.setItemIconTintList(null);
        fab.setOnClickListener{
            Snackbar.make(it,"hahah",Snackbar.LENGTH_SHORT)
                .setAction("no"){
                    Toast.makeText(this@MainActivity,"nonono",Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}
