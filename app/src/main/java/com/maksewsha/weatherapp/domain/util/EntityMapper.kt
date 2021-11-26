package com.maksewsha.weatherapp.domain.util

interface EntityMapper <Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel
}