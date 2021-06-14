package com.iris.controller

import com.iris.model.Serie
import com.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/series")
class SerieController(private val serieService: SerieService) {

    private val logger = LoggerFactory.getLogger(SerieController::class.java)

    @Post
    fun create(@Body serie: Serie): HttpResponse<Any> {
        serieService.send(Serie(UUID.randomUUID(), serie.name, serie.description, serie.description, serie.whereToWatch))
        return HttpResponse.created(HttpStatus.ACCEPTED).body(this.serieService.send(serie))
    }

}