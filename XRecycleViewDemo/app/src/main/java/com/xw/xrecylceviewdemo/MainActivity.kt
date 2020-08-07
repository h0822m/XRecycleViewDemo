package com.xw.xrecylceviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val TAG = "MainActivity"
    }
    // 添加成功按钮
    private lateinit var btnAddSuccess: Button
    // 添加失败按钮
    private lateinit var btnAddFail: Button
    // 删除数据按钮
    private lateinit var btnDelete: Button
    // 清空数据按钮
    private lateinit var btnClear: Button
    // recyclerview
    private var recyclerView: RecyclerView? = null
    // 适配器数据源
    private var listData: MutableList<String> = ArrayList()
    // 适配器
    private lateinit var adapter: RecyclerViewAdapter
    // 添加的数据
    private var addNumber = "3"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 实例化控件
        btnAddSuccess = findViewById(R.id.btn_add_success)
        btnAddFail = findViewById(R.id.btn_add_fail)
        btnDelete = findViewById(R.id.btn_delete)
        btnClear = findViewById(R.id.btn_clear)

        // 设置点击监听
        btnAddSuccess.setOnClickListener(this)
        btnAddFail.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        // 初始化数据
        initData()

        // 创建适配器
        adapter = RecyclerViewAdapter(this, listData)

        // 设置适配器
        recyclerView?.adapter = adapter
    }

    private fun initData() {
        for (i in 0..3) {
            listData.add(i.toString())
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_add_success -> {
                listData.add(addNumber)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "数据源: $listData")
            }
            R.id.btn_add_fail -> {
                initData()
                listData.add(addNumber)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "数据源：$listData")
            }
            R.id.btn_delete -> {
                if (listData.isNotEmpty()) {
                    val deleteNumber = listData[listData.size - 1]
                    listData.remove(deleteNumber)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "删除数据", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "数据源：$listData")
                }
            }
            R.id.btn_clear -> {
                listData.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "清空数据", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "数据源：$listData")
            }
        }
    }
}
