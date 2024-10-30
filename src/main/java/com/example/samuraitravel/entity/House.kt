package com.example.samuraitravel.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "houses")
class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "image_name")
    var imageName: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "price")
    var price: Int? = null

    @Column(name = "capacity")
    var capacity: Int? = null

    @Column(name = "postal_code")
    var postalCode: String? = null

    @Column(name = "address")
    var address: String? = null

    @Column(name = "phone_number")
    var phoneNumber: String? = null

    @Column(name = "created_at", insertable = false, updatable = false)
    var createdAt: Timestamp? = null

    @Column(name = "updated_at", insertable = false, updatable = false)
    var updatedAt: Timestamp? = null
}
