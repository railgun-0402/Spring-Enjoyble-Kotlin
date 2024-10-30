package com.example.samuraitravel.form

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

class SignupForm {
    val name: @NotBlank(message = "氏名を入力してください。") String? = null

    val furigana: @NotBlank(message = "フリガナを入力してください。") String? = null

    val postalCode: @NotBlank(message = "郵便番号を入力してください。") String? = null

    val address: @NotBlank(message = "住所を入力してください。") String? = null

    val phoneNumber: @NotBlank(message = "電話番号を入力してください。") String? = null

    val email: @NotBlank(message = "メールアドレスを入力してください。") @Email(message = "メールアドレスは正しい形式で入力してください。") String? =
        null

    val password: @NotBlank(message = "パスワードを入力してください。") @Length(
        min = 8,
        message = "パスワードは8文字以上で入力してください。"
    ) String? = null

    val passwordConfirmation: @NotBlank(message = "パスワード（確認用）を入力してください。") String? = null
}
