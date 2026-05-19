package com.mindmatrix.janaushadhifinder

import org.apache.commons.text.similarity.LevenshteinDistance

object FuzzySearchEngine {
    private val levenshtein = LevenshteinDistance()

    fun searchMedicine(query: String, databaseList: List<Medicine>): List<Medicine> {
        val cleanQuery = query.trim().lowercase()
        if (cleanQuery.isEmpty()) return emptyList()

        return databaseList.map { medicine ->
            val brandDist = levenshtein.apply(cleanQuery, medicine.brandName.lowercase())
            val genericDist = levenshtein.apply(cleanQuery, medicine.genericName.lowercase())

            val bestScore = minOf(brandDist, genericDist)
            Pair(medicine, bestScore)
        }
            .filter { it.second <= 3 || it.first.brandName.lowercase().contains(cleanQuery) || it.first.genericName.lowercase().contains(cleanQuery) }
            .sortedBy { it.second }
            .map { it.first }
    }
}