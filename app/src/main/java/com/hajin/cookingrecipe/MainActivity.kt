package com.hajin.cookingrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.nav_menu)

        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, RecipeFragment())
                            .commit()

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.recipe -> {
                    Log.d("mytag", "recipe 클릭")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, RecipeFragment())
                        .commit()
                    true
                }
                R.id.memo -> {
                    Log.d("mytag", "memo 클릭")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MemoFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
}