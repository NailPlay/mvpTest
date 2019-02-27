package nailapps.mvp.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.Toast
import nailapps.mvp.R

import kotlinx.android.synthetic.main.activity_central.*

class CentralActivity : AppCompatActivity(), CentralView {

    private val presenter = CentralPresenter(this, FindItemsInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_central)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
        list.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        list.adapter = CentralAdapter(items, presenter::onItemClicked)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
