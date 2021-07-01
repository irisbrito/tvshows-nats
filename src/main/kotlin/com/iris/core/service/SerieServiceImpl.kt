package com.iris.core.service

import com.iris.infrastructure.cilent.SerieClient
import com.iris.core.model.Serie
import com.iris.core.port.SerieServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieClient: SerieClient) : SerieServicePort {

    private val logger = LoggerFactory.getLogger(SerieServiceImpl::class.java)

    override fun send(serie: Serie): Serie {
        serieClient.send(serie)
        logger.info("msg enviada")
        return serie
    }

}