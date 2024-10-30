package com.example.samuraitravel.entity

import jakarta.persistence.*
import lombok.Data
import java.sql.Timestamp

@Entity
@Table(name = "verification_tokens")
@Data
class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User? = null

    @Column(name = "token")
    val token: String? = null

    @Column(name = "created_at", insertable = false, updatable = false)
    val createdAt: Timestamp? = null

    @Column(name = "updated_at", insertable = false, updatable = false)
    val updatedAt: Timestamp? = null
}