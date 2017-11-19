package com.zj.demo.flexbox

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = Adapter(listOf(
                Item("demo-1:flexDirection 决定弹性子元素的排列方式", R.layout.demo1_layout),
                Item("demo-2:flexWrap 该属性定义如果一条轴线排不下, 如何换行", R.layout.demo2_layout),
                Item("demo-3:justifyContent 属性定义了项目在主轴上的对齐方式,官网的意思是这个属性控制沿着主轴对齐，也就是说，当flexDirection设置ROW的时候，主轴就是行，按行进行对齐，如果flexDirection设置的是Column，主轴就是列，那就按列进行对齐", R.layout.demo3_layout),
                Item("demo-4:alignItems ", R.layout.demo4_layout),
                Item("demo-5: ", FlexboxDemoActivity::class.java)
        ))
    }

    class Item(val title: String) {
        var layout: Int = 0
        lateinit var clazz: Class<*>

        constructor(title: String, layout: Int) : this(title) {
            this.layout = layout
        }

        constructor(title: String, clazz: Class<*>) : this(title){
            this.clazz = clazz
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView

        init {
            title = itemView.findViewById(android.R.id.text1)
        }
    }

    class Adapter(val list: List<Item>) : RecyclerView.Adapter<Holder>() {


        override fun getItemCount() = list.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.title.text = list.get(position).title
            holder.title.setOnClickListener {
                val item = list.get(holder.adapterPosition)
                if (item.layout != 0) {
                    val intent = Intent(holder.title.context, DemoActivity::class.java)
                    intent.putExtra("layout", item.layout)
                    holder.title.context.startActivity(intent)
                } else {
                    holder.title.context.startActivity(Intent(holder.title.context, item.clazz))
                }
            }
        }

    }
}
