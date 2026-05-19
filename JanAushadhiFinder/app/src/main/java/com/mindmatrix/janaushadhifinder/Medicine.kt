package com.mindmatrix.janaushadhifinder

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "brand_name") val brandName: String,
    @ColumnInfo(name = "generic_name") val genericName: String,
    @ColumnInfo(name = "brand_price") val brandPrice: Double,
    @ColumnInfo(name = "generic_price") val genericPrice: Double
)
