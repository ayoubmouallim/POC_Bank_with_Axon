package com.dev.coreapi.events

abstract class BaseEvent<T>(

    open val id: T    // val ==> only getters

)

data class CustomerCreatedEvent(
    override val id: String,
    val name: String,
    val email: String
) : BaseEvent<String>(id)


data class CustomerUpdatedEvent(
    override val id: String,
    val name: String,
    val email: String
) : BaseEvent<String>(id)
