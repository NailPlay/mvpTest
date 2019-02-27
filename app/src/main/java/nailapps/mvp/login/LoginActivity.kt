package nailapps.mvp.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import nailapps.mvp.R
import nailapps.mvp.main.CentralActivity

class LoginActivity : AppCompatActivity(),LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun setUsernameError() {
        etLogin.error = "Ошибка";
    }

    override fun setPasswordError() {
        etPass.error = "Ошибка";
    }

    override fun navigateToHome() {
        startActivity(Intent(this, CentralActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOk.setOnClickListener{validateCredentials()};
    }

    private fun validateCredentials(){
        presenter.validateCredentials(etLogin.text.toString(),
            etPass.text.toString());
    }
}
