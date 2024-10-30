package com.example.samuraitravel.controller

import com.example.samuraitravel.entity.User
import com.example.samuraitravel.event.SignupEventPublisher
import com.example.samuraitravel.form.SignupForm
import com.example.samuraitravel.service.UserService
import com.example.samuraitravel.service.VerificationTokenService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class AuthController(
    private val userService: UserService,
    private val signupEventPublisher: SignupEventPublisher,
    private val verificationTokenService: VerificationTokenService
) {
    @GetMapping("/login")
    fun login(): String {
        return "auth/login"
    }

    @GetMapping("/signup")
    fun signup(model: Model): String {
        model.addAttribute("signupForm", SignupForm())
        return "auth/signup"
    }

    @PostMapping("/signup")
    fun signup(
        @ModelAttribute @Validated signupForm: SignupForm,
        bindingResult: BindingResult,
        redirectAttributes: RedirectAttributes,
        httpServletRequest: HttpServletRequest,
        model: Model
    ): String {
        // メルアド登録済なら、エラー内容追加
        if (userService.isEmailRegistered(signupForm.email)) {
            val fieldError = FieldError(bindingResult.objectName, "email", "すでに登録済みのメールアドレスです。")
            bindingResult.addError(fieldError)
        }

        // パスワードとパスワード（確認用）の入力値が一致しなければ、BindingResultオブジェクトにエラー内容を追加する
        if (!userService.isSamePassword(signupForm.password, signupForm.passwordConfirmation)) {
            val fieldError = FieldError(bindingResult.objectName, "password", "パスワードが一致しません。")
            bindingResult.addError(fieldError)
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("signupForm", signupForm)

            return "auth/signup"
        }

        val createdUser = userService.createUser(signupForm)
        val requestUrl = String(httpServletRequest.requestURL)
        signupEventPublisher.publishSignupEvent(createdUser, requestUrl)
        redirectAttributes.addFlashAttribute(
            "successMessage",
            "ご入力いただいたメールアドレスに認証メールを送信しました。メールに記載されているリンクをクリックし、会員登録を完了してください。"
        )

        return "redirect:/"
    }

    @GetMapping("/signup/verify")
    fun verify(@RequestParam(name = "token") token: String?, model: Model): String {
        // DBにtokenが存在することを確認し、ユーザを有効にする
        val verificationToken = verificationTokenService.getVerificationToken(token)

        if (verificationToken != null) {
            val user: User? = verificationToken.user
            userService.enableUser(user)
            val successMessage = "会員登録が完了しました。"
            model.addAttribute("successMessage", successMessage)
        } else {
            val errorMessage = "トークンが無効です。"
            model.addAttribute("errorMessage", errorMessage)
        }
        return "auth/verify"
    }
}
