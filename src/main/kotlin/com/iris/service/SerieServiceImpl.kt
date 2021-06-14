package com.iris.service

import com.iris.cilent.SerieClient
import com.iris.model.Serie
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieClient: SerieClient ) : SerieService {

    override fun send(serie: Serie): Serie {
        serieClient.send(serie)
        return serie
    }

}