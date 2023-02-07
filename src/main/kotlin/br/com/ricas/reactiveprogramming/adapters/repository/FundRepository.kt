package br.com.ricas.reactiveprogramming.adapters.repository

import br.com.ricas.reactiveprogramming.core.domain.Fund
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FundRepository: ReactiveCrudRepository<Fund, String>