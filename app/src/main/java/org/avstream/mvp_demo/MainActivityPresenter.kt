package org.avstream.mvp_demo

class MainActivityPresenter(private val view: MainActivityContract.View) : MainActivityContract.Presenter {

    override fun doLogin(email: String, password: String) {
        if (email == "test@tv.com" && password == "password!@#") {
            view.onSuccess("Success Login")
        } else {
            view.onError("Incorrect email or password.")
        }
    }
}