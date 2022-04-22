package com.example.todo.sidedish.ui.menudetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.todo.sidedish.R
import com.example.todo.sidedish.databinding.FragmentMenuDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuDetailFragment : Fragment() {

    private lateinit var binding: FragmentMenuDetailBinding
    private val detailHash: String by lazy {
        requireArguments().getString("KEY_HASH","")
    }
    private val title:String by lazy {
        requireArguments().getString("KEY_TITLE","")
    }
    private val badges:List<String>? by lazy {
        requireArguments().get("KEY_BADGE") as List<String>?
    }
    private val viewModel: MenuDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =  FragmentMenuDetailBinding.inflate(inflater, container, false)
        viewModel.getDetail(detailHash)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuDetailAdapter =  MenuDetailAdapter()
        val viewPagerAdapter= ViewPagerAdapter()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvDetail.adapter= menuDetailAdapter
        binding.vpItemDetailImg.adapter= viewPagerAdapter
        splitMenuPrice("12,600원")
        setMenuInfo()
        orderIncrease()
        orderDecrease()

        viewModel._detailInfo.observe(viewLifecycleOwner) {
            binding.detail = it
            menuDetailAdapter.submitDetailImages(it.detailImages)
        }
        viewModel._thumbImages.observe(viewLifecycleOwner){thumbs->
            viewPagerAdapter.submitThumbnails(thumbs)
            binding.vpItemDetailImg.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    private fun orderIncrease(){
        binding.btnIncreaseOrderCount.setOnClickListener {
            val curCount=  binding.tvOrderCountValue.text.toString().toInt()
            binding.tvOrderCountValue.text= "${curCount+1}"
            setTotalPay()
        }
    }

    private fun orderDecrease(){
        binding.btnDecreaseOrderCount.setOnClickListener {
            val curCount=  binding.tvOrderCountValue.text.toString().toInt()
            if(curCount>0) {
                binding.tvOrderCountValue.text = "${curCount - 1}"
                setTotalPay()
            }
        }
    }

    private fun splitMenuPrice(menuPrice:String):Int{
        var result = ""
        val splitFirst= menuPrice.split(",")
        result+= splitFirst[0]
        result+= splitFirst[1].split("원")[0]
        return result.toInt()
    }

    private fun setTotalPay(){
        val totalCount =  binding.tvOrderCountValue.text.toString().toInt()
        val menuPrice= splitMenuPrice(binding.tvMenuPrice.text.toString())
        binding.tvTotalPayValue.text = "${totalCount*(menuPrice)}원"
    }

    private fun setMenuInfo(){
        badges?.let{
            binding.badge= badges
        }
        binding.tvMenuTitle.text= title
    }

}