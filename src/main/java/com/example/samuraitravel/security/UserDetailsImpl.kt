package com.example.samuraitravel.security

import com.example.samuraitravel.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(val user: User?, private val authorities: Collection<GrantedAuthority>) :
    UserDetails {
    // ハッシュ化済みのパスワードを返す
    override fun getPassword(): String? {
        return user?.password
    }

    // ログイン時に利用するユーザー名（メールアドレス）を返す
    override fun getUsername(): String? {
        return user?.email
    }

    // ロールのコレクションを返す
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    // アカウントが期限切れでなければtrueを返す
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    // ユーザーがロックされていなければtrueを返す
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    // ユーザーのパスワードが期限切れでなければtrueを返す
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    // ユーザーが有効であればtrueを返す
    override fun isEnabled(): Boolean {
        return user?.enabled!!
    }
}
