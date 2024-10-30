package com.example.samuraitravel.service

import com.example.samuraitravel.entity.User
import com.example.samuraitravel.form.SignupForm
import com.example.samuraitravel.repository.RoleRepository
import com.example.samuraitravel.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    open fun createUser(signupForm: SignupForm): User {
        val role = roleRepository.findByName("ROLE_GENERAL")

        val user = User(
            name = signupForm.name,
            furigana = signupForm.furigana,
            postalCode = signupForm.postalCode,
            address = signupForm.address,
            phoneNumber = signupForm.phoneNumber,
            email = signupForm.email,
            password = passwordEncoder.encode(signupForm.password),
            role = role,
            enabled = false
        )

        return userRepository.save(user)
    }

    // メールアドレスが登録済か確認
    fun isEmailRegistered(email: String?): Boolean {
        val user = userRepository.findByEmail(email)
        return user != null
    }

    // パスワードとパスワード（確認用）の入力値が一致するかどうかをチェックする
    fun isSamePassword(password: String?, passwordConfirmation: String?): Boolean {
        return password == passwordConfirmation
    }

    // ユーザ有効
    @Transactional
    open fun enableUser(user: User?) {
        if (user != null) {
            user.enabled = true
            userRepository.save(user)
        }
    }
}
