package org.avstream.mvp_demo

interface MainActivityContract {

    interface View {
        fun onSuccess(message: String)
        fun onError(message: String)
    }

    interface Presenter {
        fun doLogin(email: String, password: String)
    }
}