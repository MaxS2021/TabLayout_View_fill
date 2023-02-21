package com.example.tablayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayoutapp.databinding.MainFragmentBinding


class MainFragment : Fragment() {
    private lateinit var bind: MainFragmentBinding
    private val model: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = MainFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.button.setOnClickListener {
            model.plant.value = PlantModel(
                R.drawable.pict5,
                "Информация фылвофдывофлыволфыов фывдылвофлдыволфыд фылвфдлыводлфыв фыдлвофыдлв офлдыв фыдлводлфыво фдылв",
                "лфылвофывло фдылвдфылвдфылвдфжылвджфылвдфылв жфдылвджфылв фжыдвлдфжылв жфдылвджлфыв ждфлывж фыжвджфдылв ждфылвдж"
            )
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.holder, ContentFragment.newInstance()).commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =  MainFragment()

    }
}