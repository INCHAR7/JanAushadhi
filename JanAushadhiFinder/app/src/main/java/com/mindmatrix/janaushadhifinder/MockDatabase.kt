package com.mindmatrix.janaushadhifinder

object MockDatabase {
    fun getMedicines(): List<Medicine> {
        val list = mutableListOf<Medicine>()

        list.add(Medicine(brandName = "Paracetamol", genericName = "Acetaminophen", brandPrice = 40.0, genericPrice = 12.0))
        list.add(Medicine(brandName = "Crocin", genericName = "Paracetamol", brandPrice = 35.0, genericPrice = 10.0))
        list.add(Medicine(brandName = "Metformin", genericName = "Metformin Hydrochloride", brandPrice = 90.0, genericPrice = 18.0))
        list.add(Medicine(brandName = "Amoxicillin", genericName = "Amoxicillin", brandPrice = 120.0, genericPrice = 35.0))
        list.add(Medicine(brandName = "Lipitor", genericName = "Atorvastatin", brandPrice = 250.0, genericPrice = 45.0))
        list.add(Medicine(brandName = "Zantac", genericName = "Ranitidine", brandPrice = 65.0, genericPrice = 15.0))
        list.add(Medicine(brandName = "Omez", genericName = "Omeprazole", brandPrice = 80.0, genericPrice = 22.0))

        for (i in 1..500) {
            list.add(
                Medicine(
                    brandName = "BrandedMed$i",
                    genericName = "GenericSalt$i",
                    brandPrice = (50..300).random().toDouble(),
                    genericPrice = (10..50).random().toDouble()
                )
            )
        }
        return list
    }
}