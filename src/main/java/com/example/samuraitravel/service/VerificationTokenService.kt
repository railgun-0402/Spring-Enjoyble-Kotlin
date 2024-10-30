package com.example.samuraitravel.service

import com.example.samuraitravel.entity.User
import com.example.samuraitravel.entity.VerificationToken
import com.example.samuraitravel.repository.VerificationTokenRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class VerificationTokenService(private val verificationTokenRepository: VerificationTokenRepository) {
    @Transactional
    open fun create(user: User?, token: String?) {
        val verificationToken = VerificationToken()

        verificationToken.user
        verificationToken.token

        verificationTokenRepository.save(verificationToken)
    }

    // トークン文字列で検索した結果を返す
    fun getVerificationToken(token: String?): VerificationToken? {
        return verificationTokenRepository.findByToken(token)
    }
}
