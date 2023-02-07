package br.com.ricas.reactiveprogramming.core

import br.com.ricas.reactiveprogramming.core.domain.Fund

object FundFakeData {
    fun get() = Fund(
        id = "089fd080-721b-4f07-bf8d-97d61009fd35",
        name = "XCMP11"
    )
}