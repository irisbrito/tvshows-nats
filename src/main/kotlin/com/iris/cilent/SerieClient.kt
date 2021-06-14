package com.iris.cilent

import com.iris.model.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface SerieClient {
    @Subject("series")
    fun send(eventsInformationDto: EventsInformationDto)
}