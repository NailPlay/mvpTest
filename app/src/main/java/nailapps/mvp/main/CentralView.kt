package nailapps.mvp.main

interface CentralView {
    fun showProgress()
    fun hideProgress()
    fun setItems(items: List<String>)
    fun showMessage(message: String)
}