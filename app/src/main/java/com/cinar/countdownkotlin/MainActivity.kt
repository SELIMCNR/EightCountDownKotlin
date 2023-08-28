package com.cinar.countdownkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.cinar.countdownkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Abstract(Soyutlama) , Interface(Arayüz) ,Inheritance(Kalıtım)
        object :CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                //Her bir saniyede ne olsun
                binding.sayacText.setText("Left: ${p0 /1000}")
            }

            override fun onFinish() {
                //Bitince ne olsun
                binding.sayacText.text ="Left : 0"
                Toast.makeText(this@MainActivity,"Finished",Toast.LENGTH_LONG).show()
               val intent = Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(intent)
                finish()
            }

        } .start()

    }
}