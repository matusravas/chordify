package project.mr.chordify.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

const val SECRET_KEY = "QpYKUpLjvFXUJ2zZD4l62Pg3iRyKbFcA"
const val TOKEN = "2lpbxtDLNIO4yKgIQOjaJxw8qBzSkbvh"

class TokenInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
//        Todo add TOKEN encryption
//        val cipher = Cipher.getInstance("RSA")
//        val key = SecretKeySpec(SECRET_KEY.toByteArray(), "RSA")
//        val iv = IvParameterSpec(ByteArray(16))
//        cipher.init(Cipher.ENCRYPT_MODE, key, iv)
//        val cipherText = cipher.doFinal(TOKEN.toByteArray())
//        val encryptedToken = Base64.getEncoder().encodeToString(cipherText)
        requestBuilder.addHeader("Authorization", TOKEN)
        return  chain.proceed(requestBuilder.build())
    }

}