package com.example.tablayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayoutapp.databinding.ContentFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator


class ContentFragment : Fragment() {
    private lateinit var bind: ContentFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private val fragList = listOf(
        InfoFragment.newInstance(),
        UseCaseFragment.newInstance())
    private val fragText = listOf(
        "Описание",
        "Пременение",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = ContentFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner) {
            bind.iMain.setImageResource(it.imageId)

        }
        val adapter = VpAdapter(activity as AppCompatActivity, fragList)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabLayout, bind.vp2){
                tab, pos -> tab.text = fragText[pos]
        }.attach()
    }

    companion object {

        @JvmStatic
        fun newInstance() =  ContentFragment()

    }
}