package com.example.samuraitravel.service

import com.example.samuraitravel.entity.House
import com.example.samuraitravel.repository.HouseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class HouseService /* Constructor */(private val houseRepository: HouseRepository) {
    /* Get All Houses Data */
    fun findAllHouses(pageable: Pageable): Page<House?> {
        return houseRepository.findAll(pageable)
    }

    /* Get Hit Houses Data */
    fun findHousesByNameLike(keyword: String, pageable: Pageable?): Page<House?>? {
        return houseRepository.findByNameLike("%$keyword%", pageable)
    }
}
