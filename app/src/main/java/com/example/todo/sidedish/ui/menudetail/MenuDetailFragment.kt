package com.example.todo.sidedish.ui.menudetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
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

        registerOrderQuantityControlBtn()
        setMenuInfo()


        viewModel._detailInfo.observe(viewLifecycleOwner) {
            binding.detail = it
            menuDetailAdapter.submitDetailImages(it.detailImages)
        }
        viewModel._thumbnailImages.observe(viewLifecycleOwner){thumbs->
            viewPagerAdapter.submitThumbnails(thumbs)
            binding.vpItemDetailImg.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    private fun registerOrderQuantityControlBtn(){
        registerOrderIncreaseBtn()
        registerOrderDecreaseBtn()
    }

    private fun registerOrderIncreaseBtn(){
        binding.btnIncreaseOrderCount.setOnClickListener {
            val curCount=  binding.tvOrderCountValue.text.toString().toInt()
            binding.tvOrderCountValue.text= "${curCount+1}"
            setTotalPay()
        }
    }

    private fun registerOrderDecreaseBtn(){
        binding.btnDecreaseOrderCount.setOnClickListener {
            val curCount=  binding.tvOrderCountValue.text.toString().toInt()
            if(curCount>0) {
                binding.tvOrderCountValue.text = "${curCount - 1}"
                setTotalPay()
            }
        }
    }

    private fun splitMenuPrice(menuPrice: String): Int {
        val priceString = menuPrice.substring(0, menuPrice.length - 1)
        return priceString.replace(",", "").toInt()
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