package com.mindmatrix.janaushadhifinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MedicineAdapter(private var medicineList: List<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvBrandName: TextView = itemView.findViewById(R.id.tvBrandName)
        val tvGenericSalt: TextView = itemView.findViewById(R.id.tvGenericSalt)
        val tvBrandedPrice: TextView = itemView.findViewById(R.id.tvBrandedPrice)
        val tvGenericPrice: TextView = itemView.findViewById(R.id.tvGenericPrice)
        val btnCheckStock: MaterialButton = itemView.findViewById(R.id.btnCheckStock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicineList[position]
        holder.tvBrandName.text = medicine.brandName
        holder.tvGenericSalt.text = "Salt: ${medicine.genericName}"
        holder.tvBrandedPrice.text = "Branded: ₹${medicine.brandPrice}"
        holder.tvGenericPrice.text = "Generic: ₹${medicine.genericPrice}"

        holder.btnCheckStock.setOnClickListener { context ->
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Stock Verification")
                .setMessage("Checking active inventory for ${medicine.genericName} at nearby outlets...")
                .setPositiveButton("OK", null)
                .show()
        }
    }

    override fun getItemCount(): Int = medicineList.size

    fun updateList(newList: List<Medicine>) {
        medicineList = newList
        notifyDataSetChanged()
    }
}