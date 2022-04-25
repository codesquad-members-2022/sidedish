package com.codesquadhan.sidedish.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesquadhan.sidedish.data.model.DetailImage
import com.codesquadhan.sidedish.data.model.detail.DetailResponse
import com.codesquadhan.sidedish.data.model.detail.TopImageData
import com.codesquadhan.sidedish.data.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository) : ViewModel() {

    private val _detailResponseLd = MutableLiveData<DetailResponse>()
    val detailResponseLd = _detailResponseLd

    private val _detailImageListLd = MutableLiveData<List<TopImageData>>()
    private val detailImageList = mutableListOf<TopImageData>()
    val detailImageListLd: LiveData<List<TopImageData>> = _detailImageListLd

    private val _vpImageListLd = MutableLiveData<List<TopImageData>>()
    private val vpImageList = mutableListOf<TopImageData>()
    val vpImageListLd: LiveData<List<TopImageData>> = _vpImageListLd


    fun addViewPagerImageTest(){
        vpImageList.add(TopImageData(1,"https://ww.namu.la/s/32b66f77ef969034adcbce3840d362f66470c1ade8b3b67e9859954467a61a77ffe24051fd4db50a6a5251acd242a9140df6fc120653c85407c5508b00e763d8b2b09754bbe86f5ec315d6c2bfa597a8dc287028f3608155e80c67801d60595d"))
        vpImageList.add(TopImageData(2,"https://imagescdn.gettyimagesbank.com/500/21/442/935/0/1298312835.jpg"))
        _vpImageListLd.value = vpImageList
    }

    fun getMenuDetail(id: Int){
        viewModelScope.launch {
            val detailResponse = detailRepository.getMenuDetail(id) ?: throw RuntimeException("why..?")
            _detailResponseLd.value = detailResponse

            detailResponse.mainImage.forEachIndexed { index, url ->
                vpImageList.add(TopImageData(index+1, url))
            }
            detailResponse.detailImage.forEachIndexed{ index, url ->
                detailImageList.add(TopImageData(index+1, url))
            }

            _vpImageListLd.value = vpImageList
            _detailImageListLd.value = detailImageList
        }
    }

}