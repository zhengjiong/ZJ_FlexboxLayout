package com.zj.demo.flexbox

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by zhengjiong
 * date: 2017/11/19 15:59
 */
class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(intent.getIntExtra("layout", 0))
    }
}