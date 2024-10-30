package com.example.samuraitravel.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
open class WebSecurityConfig {
    @Bean
    @Throws(Exception::class)
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests(Customizer { requests: AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry ->
                requests
                    .requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/", "/signup/**")
                    .permitAll() // すべてのユーザーにアクセスを許可するURL
                    .requestMatchers("/admin/**").hasRole("ADMIN") // 管理者のみにアクセス許可
                    .anyRequest().authenticated()
            } // 上記以外のURLはログインが必要（会員または管理者のどちらでもOK）
            )
            .formLogin { form: FormLoginConfigurer<HttpSecurity?> ->
                form
                    .loginPage("/login") // ログインページのURL
                    .loginProcessingUrl("/login") // ログインフォームの送信先URL
                    .defaultSuccessUrl("/?loggedIn") // ログイン成功時のリダイレクト先URL
                    .failureUrl("/login?error") // ログイン失敗時のリダイレクト先URL
                    .permitAll()
            }
            .logout { logout: LogoutConfigurer<HttpSecurity?> ->
                logout
                    .logoutSuccessUrl("/?loggedOut") // ログアウト時のリダイレクト先URL
                    .permitAll()
            }

        return http.build()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
