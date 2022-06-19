package com.ishwar.kotlineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.ishwar.kotlineretrofit.api.ApiInterface
import com.ishwar.kotlineretrofit.api.ApiUtilities
import com.ishwar.kotlineretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val userApi=ApiUtilities.getInstance().create(ApiInterface::class.java)
        GlobalScope.launch {
            val result=userApi.getUsers()

            if (result.body()!=null){
                result.body()!!.iterator().forEach { data->
                    Log.d("ISP", "onCreate: ${data.login}")
                }

            }
        }

    }
}