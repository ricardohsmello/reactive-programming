package br.com.ricas.reactiveprogramming.core.port

import br.com.ricas.reactiveprogramming.adapters.repository.FundRepository
import br.com.ricas.reactiveprogramming.core.FundFakeData
import br.com.ricas.reactiveprogramming.core.usecase.FundUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@SpringBootTest
class FundPortTest {

    @Autowired
    private lateinit var fundPort: FundPort

    @Test
    fun `should  save successfully`() {
        val repository = fundRepository()

        every { repository.save(any()) } returns Mono.just(FundFakeData.get())
        fundPort.save(FundFakeData.get())
    }

    @Test
    fun `should findAll successfully`() {
        val repository = fundRepository()

        every { repository.findAll() } returns Flux.just(FundFakeData.get())
        fundPort.findAll()
    }

    private fun fundRepository(): FundRepository {
        val repository = mockk<FundRepository>()
        fundPort = FundUseCase(repository = repository)
        return repository
    }
}