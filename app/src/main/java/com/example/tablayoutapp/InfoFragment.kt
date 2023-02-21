package com.example.tablayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tablayoutapp.databinding.InfoFragmentBinding


class InfoFragment : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private lateinit var bind: InfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = InfoFragmentBinding.inflate(inflater, container,false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner) {
            bind.twInfo.text = it.info

        }
    }
    companion object {

        @JvmStatic
        fun newInstance() =  InfoFragment()

    }
}