package com.example.estadao.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.estadao.R
import com.example.estadao.core.common.BaseActivity
import com.example.estadao.databinding.ActivityLoginBinding
import com.example.estadao.presentation.news.NewsActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : BaseActivity(), LoginContract {

    private lateinit var binding: ActivityLoginBinding

    private val presenter: LoginPresenter by inject { parametersOf(this) }

    override fun context() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.presenter = presenter

        username.setText("devmobile")
        password.setText("uC&+}H4wg?rYbF:")

    }

    override fun username(): String {
        return username.text.toString()
    }

    override fun password(): String {
        return password.text.toString()
    }

    override fun navigateToNews() {
        startActivity<NewsActivity>()
        finish()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }

    override fun onDestroy() {
        presenter.dispose()
        super.onDestroy()
    }

    override fun loadingShow(){
        loading.visibility = View.VISIBLE
    }

    override fun loadingHide(){
        loading.visibility = View.GONE
    }

    companion object {
        fun buildIntent(context: Context): Intent = Intent(context, LoginActivity::class.java)
    }
}
