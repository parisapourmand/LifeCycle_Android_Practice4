package com.example.exercise4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private val TAG : String = "LifeCycle"

    lateinit var btnAdd : Button
    lateinit var btnReduce : Button
    lateinit var txtResult : TextView

    lateinit var mainViewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "OnCreate...")

        btnAdd = findViewById(R.id.btn_add)
        btnReduce = findViewById(R.id.btn_reduce)
        txtResult = findViewById(R.id.txt_score)

        Log.i("MainViewModel", "MainActivity Created")
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        btnAdd.setOnClickListener {
            mainViewModel.add(Integer.parseInt(txtResult.text.toString()))
        }

        btnReduce.setOnClickListener {
            mainViewModel.reduce(Integer.parseInt(txtResult.text.toString()))
        }

        mainViewModel.score.observe(this, Observer {
            txtResult.text = it.toString()
        })

    }

//    override fun onResume() {
//        super.onResume()
//        Log.i(TAG, "OnResume...")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.i(TAG, "OnStart...")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i(TAG, "OnPause...")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i(TAG, "OnStop...")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i(TAG, "OnDestroy...")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.i(TAG, "OnRestart...")
//    }

}