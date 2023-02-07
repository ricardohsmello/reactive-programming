package br.com.ricas.reactiveprogramming.core.usecase

import br.com.ricas.reactiveprogramming.adapters.repository.FundRepository
import br.com.ricas.reactiveprogramming.core.domain.Fund
import br.com.ricas.reactiveprogramming.core.port.FundPort
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FundUseCase(
    private val repository: FundRepository
) : FundPort {
    override fun save(fund: Fund): Mono<Fund> {
        return repository.save(fund)
     }

    override fun findAll(): Flux<Fund> {
        return repository.findAll()
    }

    override fun findById(id: String): Mono<Fund> {
        return repository.findById(id)
    }

    override fun delete(fund: Fund): Mono<Void> {
         return repository.delete(fund)
    }
}