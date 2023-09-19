package com.example.shimon.platziiapi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class baseFragment<VB : ViewBinding>(

    private var bindingInflater : (inflate:LayoutInflater)->VB

) : Fragment(){

    private var _binding:VB? = null
    val binding: VB
        get() = _binding as VB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(layoutInflater)

        return binding.root
    }

}