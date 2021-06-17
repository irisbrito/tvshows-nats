package com.iris.cilent

import com.iris.model.Serie
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface SerieClient {
    @Subject("series")
    fun send(serie: Serie)
}