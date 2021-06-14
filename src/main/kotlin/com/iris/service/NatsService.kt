package com.iris.service

import com.iris.cilent.SerieClient
import com.iris.model.Events
import com.iris.model.EventsInformationDto
import com.iris.model.Serie
import com.iris.port.NatsServicePort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class NatsService(private val client: SerieClient) : NatsServicePort {

    val LOG: Logger = LoggerFactory.getLogger(NatsService::class.java)

    override fun sendNats(serie: Serie): Serie {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_SERIE,
            Serie(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
        )
        client.send(eventsInformation)
        LOG.info("message successfully sent to the broker {}", eventsInformation.events.event)

        return serie
    }
}