package com.dicoding.academies.ui.academy


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.academies.R
import com.dicoding.academies.utils.DataDummy
import com.dicoding.academies.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_academy.*


/**
 * A simple [Fragment] subclass.
 */
class AcademyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_academy, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            //tanpa viewmodel
//            val courses = DataDummy.generateDummyCourses()
//            val academyAdapter = AcademyAdapter()
//            academyAdapter.setCourses(courses)
//
//            with(rv_academy) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = academyAdapter
//            }

            //dengan viewmodel
//            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()) [AcademyViewModel::class.java]
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[AcademyViewModel::class.java]
            val courses = viewModel.getCourses()

            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourses(courses)

            rv_academy.layoutManager = LinearLayoutManager(context)
            rv_academy.setHasFixedSize(true)
            rv_academy.adapter = academyAdapter
        }
    }
}

