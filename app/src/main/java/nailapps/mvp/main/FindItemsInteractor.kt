package nailapps.mvp.main

import nailapps.mvp.postDelayed

class FindItemsInteractor {

    fun findItems(callback: (List<String>) -> Unit){
        postDelayed(2000){
            callback(createArrayList())
        }
    }

    private fun createArrayList():
            List<String> = (1..10).map{"Item $it"}
}