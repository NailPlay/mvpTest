package nailapps.mvp.login

import nailapps.mvp.postDelayed

class LoginInteractor {
    interface OnLoginFinishedListener{
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String,
              listener: OnLoginFinishedListener){
        postDelayed(2000){
            when{
                username.isEmpty() -> listener.onUsernameError();
                password.isEmpty() -> listener.onPasswordError();
                else -> listener.onSuccess();
            }
        }
    }
}