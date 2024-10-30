package com.example.samuraitravel.repository

import com.example.samuraitravel.entity.VerificationToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VerificationTokenRepository : JpaRepository<VerificationToken?, Int?> {
    fun findByToken(token: String?): VerificationToken?
}

