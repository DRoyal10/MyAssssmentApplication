package com.example.myassssmentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DashboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val keypass = intent.getStringExtra("KEYPASS") ?: ""

        if (keypass.isNotEmpty()) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "No keypass provided", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        val call = RetrofitClient.instance.getDashboardData(keypass)

        call.enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(
                call: Call<DashboardResponse>,
                response: Response<DashboardResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val itemList = response.body()!!.entities
                    adapter = DashboardAdapter(itemList) { selectedItem ->
                        val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                        intent.putExtra("ITEM_NAME", selectedItem.name)
                        intent.putExtra("ITEM_CULTURE", selectedItem.culture)
                        intent.putExtra("ITEM_DOMAIN", selectedItem.domain)
                        intent.putExtra("ITEM_SYMBOL", selectedItem.symbol)
                        intent.putExtra("ITEM_PARENTAGE", selectedItem.parentage)
                        intent.putExtra("ITEM_ROMAN", selectedItem.romanEquivalent)
                        intent.putExtra("ITEM_DESCRIPTION", selectedItem.description)
                        startActivity(intent)
                    }
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(
                        this@DashboardActivity,
                        "Failed to load data",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}
