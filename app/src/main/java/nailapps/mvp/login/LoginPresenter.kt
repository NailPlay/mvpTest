package nailapps.mvp.login

class LoginPresenter(var loginView: LoginView, val loginInteractor: LoginInteractor):
LoginInteractor.OnLoginFinishedListener{
    override fun onUsernameError() {
        loginView?.apply {
            setUsernameError()
            hideProgress()
        }
    }

    override fun onPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onSuccess() {
        loginView?.navigateToHome();
    }

    fun validateCredentials(username: String, password: String){
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }


}