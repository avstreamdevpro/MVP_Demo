package org.avstream.mvp_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener, MainActivityContract.View {

    lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
        btn_login.setOnClickListener(this)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        v?.let {
            if (it.id != R.id.btn_login) {
                return
            }
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                onError("Field(s) Required")
            } else {
                presenter.doLogin(email, password)
            }
        }
    }
}