package com.example.astro_wale.ui.pic_of_day.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.astro_wale.data.common.AstroPicData
import com.example.astro_wale.domain.repositories.AstroPicRepository
import com.example.astro_wale.others.Constants
import com.example.astro_wale.others.DateUtils
import com.example.astro_wale.others.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstroPicViewModel @Inject constructor(
    private val repository: AstroPicRepository,
) : ViewModel() {

    private val picUrl = ObservableField<String>()
    private val title = ObservableField<String>()
    private val subtitle = ObservableField<String>()
    private val showError = ObservableBoolean(false)
    private val errorText = ObservableField<String>()

    fun getPicUrl() = picUrl
    fun getTitle() = title
    fun getSubtitle() = subtitle
    fun getShowError() = showError
    fun getErrorText() = errorText

    fun fetchPicOfTheDay() = viewModelScope.launch {
        val astroPicData = repository.getPicOfTheDay()
        when (astroPicData.status) {
            Status.SUCCESS -> processAstroPicData(astroPicData.data)
            Status.ERROR -> processError(astroPicData.message)
        }
    }

    private fun processAstroPicData(data: AstroPicData?) {
        data?.let {
            title.set(data.title)
            subtitle.set(data.explanation)
            picUrl.set(data.url)
            insertDataIntoDb(it)
        }
    }

    private fun insertDataIntoDb(data: AstroPicData) {
        viewModelScope.launch {
            repository.insertAstroPicData(astroPicData = data.apply {
                id = Constants.ENTRY_ID
                if (timestamp == null) timestamp = System.currentTimeMillis()
            })
            checkForDateError(data)
        }
    }

    private fun checkForDateError(data: AstroPicData) {
        data.timestamp?.let { time ->
            if (DateUtils.isPrevDate(time))
                processError("We are not connected to the network, showing you the last image we have")
        }
    }

    private fun processError(message: String?) {
        message?.let {
            showError.set(true)
            errorText.set(message)
        }
    }
}