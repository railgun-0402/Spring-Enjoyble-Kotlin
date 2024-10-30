package com.example.samuraitravel.security

import com.example.samuraitravel.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        try {
            val user = userRepository.findByEmail(email)
            val userRoleName: String = user?.role?.name.toString()
            val authorities: MutableCollection<GrantedAuthority> = ArrayList()
            authorities.add(SimpleGrantedAuthority(userRoleName))
            return UserDetailsImpl(user, authorities)
        } catch (e: Exception) {
            throw UsernameNotFoundException("ユーザーが見つかりませんでした。")
        }
    }
}
