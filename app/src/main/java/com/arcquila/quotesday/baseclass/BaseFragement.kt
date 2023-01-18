package com.arcquila.quotesday.baseclass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragement<B : ViewBinding, VM : ViewModel>(val bindingFactory: (LayoutInflater) -> B) :
    Fragment() {

    protected abstract val viewModel: VM
    private var _binding: B ?= null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingFactory(layoutInflater)
        initView()
        initObserver()
        return binding!!.root
    }

    abstract fun initView()
    abstract fun initObserver()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}