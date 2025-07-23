package com.example.myassssmentapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish() // Goes back to DashboardActivity
        }


        val tvName = findViewById<TextView>(R.id.tvName)
        val tvCulture = findViewById<TextView>(R.id.tvCulture)
        val tvDomain = findViewById<TextView>(R.id.tvDomain)
        val tvSymbol = findViewById<TextView>(R.id.tvSymbol)
        val tvParentage = findViewById<TextView>(R.id.tvParentage)
        val tvRoman = findViewById<TextView>(R.id.tvRoman)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)

        tvName.text = "Name: " + intent.getStringExtra("ITEM_NAME")
        tvCulture.text = "Culture: " + intent.getStringExtra("ITEM_CULTURE")
        tvDomain.text = "Domain: " + intent.getStringExtra("ITEM_DOMAIN")
        tvSymbol.text = "Symbol: " + intent.getStringExtra("ITEM_SYMBOL")
        tvParentage.text = "Parentage: " + intent.getStringExtra("ITEM_PARENTAGE")
        tvRoman.text = "Roman Equivalent: " + intent.getStringExtra("ITEM_ROMAN")
        tvDescription.text = "Description: " + intent.getStringExtra("ITEM_DESCRIPTION")
    }
}
