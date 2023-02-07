package br.com.ricas.reactiveprogramming.core.port

import br.com.ricas.reactiveprogramming.core.domain.Fund
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface FundPort {
    fun save(fund: Fund): Mono<Fund>
    fun findAll(): Flux<Fund>
    fun findById(id: String): Mono<Fund>
    fun delete(fund: Fund): Mono<Void>
}