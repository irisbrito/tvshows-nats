package com.iris.model

import java.util.*

data class EventsInformationDto(
    val events: Events = Events.SAVE_SERIE,
    val product: Serie = Serie(UUID.fromString(""),"", "","","")
)
