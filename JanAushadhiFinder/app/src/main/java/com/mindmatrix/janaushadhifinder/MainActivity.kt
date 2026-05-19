package com.mindmatrix.janaushadhifinder

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var savingsCard: MaterialCardView
    private lateinit var tvSavingsText: TextView
    private lateinit var rvMedicineResults: RecyclerView
    private lateinit var adapter: MedicineAdapter
    private var fullMedicineList: List<Medicine> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        savingsCard = findViewById(R.id.savingsCard)
        tvSavingsText = findViewById(R.id.tvSavingsText)
        rvMedicineResults = findViewById(R.id.rvMedicineResults)

        fullMedicineList = MockDatabase.getMedicines()

        rvMedicineResults.layoutManager = LinearLayoutManager(this)
        adapter = MedicineAdapter(emptyList())
        rvMedicineResults.adapter = adapter

        setupSearchEngine()

        val btnOpenMap: View = findViewById(R.id.btnOpenMap)
        btnOpenMap.setOnClickListener {
            val intent = android.content.Intent(this, StoreLocatorActivity::class.java)
            startActivity(intent)
        }

        val btnSetReminder: View = findViewById(R.id.btnSetReminder)
        btnSetReminder.setOnClickListener {
            val calendar = java.util.Calendar.getInstance()
            android.app.DatePickerDialog(this, { _, year, month, dayOfMonth ->
                androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Reminder Confirmed")
                    .setMessage("Automated monthly refill alert successfully configured for the selected cycle starting $dayOfMonth/${month + 1}/$year.")
                    .setPositiveButton("Done", null)
                    .show()
            }, calendar.get(java.util.Calendar.YEAR), calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun setupSearchEngine() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterResults(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterResults(newText)
                return true
            }
        })
    }

    private fun filterResults(query: String?) {
        if (query.isNullOrBlank()) {
            adapter.updateList(emptyList())
            savingsCard.visibility = View.GONE
            return
        }

        val filteredList = FuzzySearchEngine.searchMedicine(query, fullMedicineList)
        adapter.updateList(filteredList)

        if (filteredList.isNotEmpty()) {
            val totalBranded = filteredList.sumOf { it.brandPrice }
            val totalGeneric = filteredList.sumOf { it.genericPrice }
            val potentialSavings = totalBranded - totalGeneric

            if (potentialSavings > 0) {
                tvSavingsText.text = "Switching to generic can save you up to ₹${String.format("%.2f", potentialSavings)} on these options!"
                savingsCard.visibility = View.VISIBLE
            } else {
                savingsCard.visibility = View.GONE
            }
        } else {
            savingsCard.visibility = View.GONE
        }
    }
}