package nailapps.mvp.main

class CentralPresenter
    (var centralView: CentralView?,
     val findItemsInteractor: FindItemsInteractor){

    fun onResume(){
        centralView?.showProgress()
        findItemsInteractor.findItems(::onItemsLoader)
    }

    private fun onItemsLoader(items: List<String>){
        centralView?.apply {
            setItems(items)
            hideProgress()
        }
    }

    fun onItemClicked(item: String){
        centralView?.showMessage(item)
    }

    fun onDestroy(){
        centralView = null
    }
}