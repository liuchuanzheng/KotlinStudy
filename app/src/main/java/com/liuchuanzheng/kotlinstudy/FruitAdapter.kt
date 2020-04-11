package com.liuchuanzheng.kotlinstudy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author 刘传政
 * @date 2020/4/9 17:19
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
class FruitAdapter(val context: Context, val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name: TextView = view.findViewById(R.id.tv_name)
        val iv_icon: ImageView = view.findViewById(R.id.iv_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = fruitList.get(position).name
        holder.iv_icon.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = fruitList.get(position)
            val intent = Intent(context, FruitActivity::class.java).apply {
                putExtra(FruitActivity.FRUIT_NAME, fruit.name)
            }
            context.startActivity(intent)
        }
    }


}