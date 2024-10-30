package com.example.samuraitravel.repository

import com.example.samuraitravel.entity.House
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HouseRepository : JpaRepository<House?, Int?> {
    fun findByNameLike(keyword: String?, pageable: Pageable?): Page<House?>?
}
