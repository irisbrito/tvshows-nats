package com.iris.infrastructure.cilent

import com.iris.core.model.Serie
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface SerieClient {
    @Subject("series")
    fun send(serie: Serie)
}