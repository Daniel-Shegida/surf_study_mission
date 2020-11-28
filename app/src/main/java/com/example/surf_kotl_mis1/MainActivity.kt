package com.example.surf_kotl_mis1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity(), comunicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainfragment = MainFragment()
        val authfragment = AuthFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, mainfragment)
            addToBackStack(null)
            commit()
        }

       var r = Runnable {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, authfragment)
                addToBackStack(null)
                commit()
            }

        }

        var hand = Handler()
        hand.postDelayed(r,5000)

    }

    override fun passData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("messege",editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val MemeFragment = MemeFragment()
        MemeFragment.arguments = bundle
        transaction.replace(R.id.flFragment,MemeFragment)
        transaction.commit()
    }


}