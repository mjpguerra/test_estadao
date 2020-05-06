package com.example.estadao.core.common

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

abstract class BaseDialogFragment : DialogFragment() {
    private var firstVisit = false
    protected var mView: View? = null

    protected abstract val resLayout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firstVisit = true

        this.arguments?.let {
            setupArguments(it)
        }

        mView = inflater.inflate(resLayout, container, false)?.apply {
            setupViews(this)
        }

       // dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return mView
    }

    override fun onResume() {
        super.onResume()

        if (firstVisit) {
            firstVisit = false
        } else {
            onRestart()
        }
    }

    protected open fun setupViews(view: View) {
    }

    protected open fun setupArguments(arguments: Bundle) {
    }

    protected open fun onRestart() {
    }

    protected fun withView(f: (View) -> Unit) {
        mView?.let {
            f(it)
        }
    }

    protected fun withActivity(f: (Activity) -> Unit) {
        activity?.let {
            f(it)
        }
    }

    protected fun withApplication(f: (Application) -> Unit) {
        activity?.application?.let {
            f(it)
        }
    }
}