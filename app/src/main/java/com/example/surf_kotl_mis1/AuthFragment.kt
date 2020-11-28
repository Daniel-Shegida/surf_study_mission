package com.example.surf_kotl_mis1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication4.api.networkService
import com.example.surf_kotl_mis1.model.LoginPost
import com.example.surf_kotl_mis1.model.LoginService
import com.example.surf_kotl_mis1.model.User
import kotlinx.android.synthetic.main.authorization.*
import kotlinx.android.synthetic.main.authorization.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthFragment : Fragment(R.layout.authorization) {

    private lateinit var comunicator: comunicator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comunicator = activity as comunicator

        var User = User(
            login = "qwerty",
            password = "qwerty"
        )


        //custombtn.showLoading() make it myself later

        val retrofit = networkService.buildService(LoginService::class.java)

        view.login1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                hide_error()
                login.error = null
            }
        })

        view.password1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                hide_error()
                password.error = null
                if (password.editText?.text.toString().isNotEmpty()) {
                    password.isPasswordVisibilityToggleEnabled = true
                } else {
                    password.isPasswordVisibilityToggleEnabled = false
                }
            }
        })


        button.setOnClickListener {
            if (login.editText?.text.toString().isNotEmpty()
                && password.editText?.text.toString().isNotEmpty()
            ) {
                User.login = login.editText?.text.toString()
                User.password = password.editText?.text.toString()
                button.showLoading()
                retrofit.postLogin(User).enqueue(
                    object : Callback<LoginPost> {
                        override fun onFailure(call: Call<LoginPost>, t: Throwable) {
                            button.hideLoading()
                            show_error()
                        }

                        override fun onResponse(
                            call: Call<LoginPost>,
                            response: Response<LoginPost>
                        ) {
                            button.hideLoading()
                            show_error()
                            var JustString: String? = response.body()?.accessToken
                            if (JustString != null) {
                                comunicator.passData(JustString)
                            }
                        }
                    }
                )
            } else {
                is_error()
            }
        }
    }

    private fun is_error() {
        is_login()
        is_password()

    }

    private fun is_password() {
        if (password.editText?.text.toString().isEmpty()) {
            password.error = getString(R.string.error1)
        }
    }

    private fun is_login() {
        if (login.editText?.text.toString().isEmpty()) {
            login.error = getString(R.string.error1)
        }
    }

    private fun show_error() {
        button.visibility = View.GONE
        errorr.visibility = View.VISIBLE
    }

    private fun hide_error() {
        button.visibility = View.VISIBLE
        errorr.visibility = View.GONE
    }
}


//Toast.makeText(getActivity(), t.message, Toast.LENGTH_LONG).show()