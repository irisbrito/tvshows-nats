package com.iris.service

import com.iris.core.model.Serie
import com.iris.core.service.SerieServiceImpl
import com.iris.infrastructure.cilent.SerieClient
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.UUID

@MicronautTest
class SerieServiceImplTest : AnnotationSpec() {

    val client = mockk<SerieClient>()
    val serieService = SerieServiceImpl(client)
    lateinit var serie : Serie
    val id : UUID = UUID.randomUUID()

    @BeforeEach
    fun setUp(){
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should send serie to the subscriber`(){
        every {client.send(any())} returns Unit
        val result = serieService.send(serie)
        result shouldBe serie
    }


}