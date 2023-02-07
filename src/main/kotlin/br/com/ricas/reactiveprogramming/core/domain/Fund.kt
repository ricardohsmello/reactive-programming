package br.com.ricas.reactiveprogramming.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "fund")
data class Fund(@Id var id: String?,
                val name: String)