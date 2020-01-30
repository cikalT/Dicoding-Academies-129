package com.dicoding.academies.ui.academy

import androidx.lifecycle.ViewModel
import com.dicoding.academies.data.source.AcademyRepository
import com.dicoding.academies.data.source.local.entity.CourseEntity
import com.dicoding.academies.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

//    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses() //dummy
    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
}