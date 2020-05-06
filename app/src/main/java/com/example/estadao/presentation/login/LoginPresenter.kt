package com.example.estadao.presentation.login

import android.util.Log
import com.example.estadao.core.common.BasePresenter
import com.example.estadao.presentation.login.actions.AutenticateLogin
import com.example.estadao.presentation.login.actions.SaveToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(
    private val contract: LoginContract,
    private val autenticateLogin : AutenticateLogin,
    private val saveToken : SaveToken
) : BasePresenter() {

    fun autenticateLogin() {
        contract.loadingShow()
        autenticateLogin.execute(contract.username(), contract.password())
            .flatMap {
               val token = it.body()!!.token
                saveToken.execute(token)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    contract.loadingHide()
                    contract.navigateToNews()

                },
                {
                    contract.loadingHide()
                    Log.e(AUTOCARD_ERRORS, "TODO: Error Handler - LoginPresenter") }
            ).also { addDisposable(it) }
    }

}