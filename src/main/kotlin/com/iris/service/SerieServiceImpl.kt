package com.iris.service

import com.iris.cilent.SerieClient
import com.iris.model.Serie
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieClient: SerieClient ) : SerieService {

    private val logger = LoggerFactory.getLogger(SerieServiceImpl::class.java)

    override fun send(serie: Serie): Serie {
        serieClient.send(serie)
        logger.info("msg enviada")
        return serie
    }

}