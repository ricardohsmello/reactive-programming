package br.com.ricas.reactiveprogramming.adapters.web

import br.com.ricas.reactiveprogramming.config.exception.NotFoundException
import br.com.ricas.reactiveprogramming.core.domain.Fund
import br.com.ricas.reactiveprogramming.core.port.FundPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@RestController
@RequestMapping(value = ["/fund"])
class FundController @Autowired constructor(
    private val fundPort: FundPort
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun post(@RequestBody fund: Fund): Mono<Fund> {
        fund.id = UUID.randomUUID().toString()
        return fundPort.save(fund)
     }

    @GetMapping("/all")
    fun get(): Flux<Fund> {
        return fundPort.findAll()
            .delayElements(Duration.ofSeconds(2))
    }

    @DeleteMapping(value = ["/delete/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String): Mono<Void> {
        return fundPort.findById(id)
            .switchIfEmpty(Mono.error(NotFoundException))
            .flatMap { fund -> fundPort.delete(fund) }
            .then(Mono.empty())
    }
}