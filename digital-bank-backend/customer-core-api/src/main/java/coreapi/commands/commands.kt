package com.dev.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id: T    // val ==> only getters

)

data class CreateCustomerCommand(
    override val id: String,
    val name: String,
    val email: String
) : BaseCommand<String>(id)


data class UpdateCustomerCommand(
    override val id: String,
    val name: String,
    val email: String
) : BaseCommand<String>(id)
