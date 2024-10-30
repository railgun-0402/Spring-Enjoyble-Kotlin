package com.example.samuraitravel.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import java.sql.Timestamp

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null,

    @field:NotBlank(message = "氏名を入力してください。")
    @Column(name = "name")
    val name: String? = null,

    @field:NotBlank(message = "フリガナを入力してください。")
    @Column(name = "furigana")
    val furigana: String? = null,

    @field:NotBlank(message = "郵便番号を入力してください。")
    @Column(name = "postal_code")
    val postalCode: String? = null,

    @field:NotBlank(message = "住所を入力してください。")
    @Column(name = "address")
    val address: String? = null,

    @field:NotBlank(message = "電話番号を入力してください。")
    @Column(name = "phone_number")
    val phoneNumber: String? = null,

    @field:NotBlank(message = "メールアドレスを入力してください。")
    @field:Email(message = "メールアドレスは正しい形式で入力してください。")
    @Column(name = "email")
    val email: String? = null,

    @Column(name = "password")
    val password: String,

    @ManyToOne
    @JoinColumn(name = "role_id")
    val role: Role? = null,

    @Column(name = "enabled")
    var enabled: Boolean = false,

    @Column(name = "created_at", insertable = false, updatable = false)
    val createdAt: Timestamp? = null,

    @Column(name = "updated_at", insertable = false, updatable = false)
    val updatedAt: Timestamp? = null
) {
    constructor() : this(null, null, null, null, null, null, null, "", null, false, null, null)
}
