package com.example.todo.sidedish.ui.menudetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.todo.sidedish.R
import com.example.todo.sidedish.common.Constants
import com.example.todo.sidedish.databinding.FragmentMenuDetailBinding
import dagger.hilt.android.AndroidEntryPoint

const val ORDER_COUNT_ZERO = 0

@AndroidEntryPoint
class MenuDetailFragment : Fragment() {

    private lateinit var binding: FragmentMenuDetailBinding
    private lateinit var navigator: NavController
    private val detailHash: String by lazy { requireArguments().getString(Constants.HASH_KEY, Constants.EMPTY_DEFAULT) }
    private val title: String by lazy { requireArguments().getString(Constants.TITLE_KEY, Constants.EMPTY_DEFAULT) }
    private val badges: List<String>? by lazy { requireArguments().get(Constants.BADGE_KEY) as List<String>? }
    private val viewModel: MenuDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        viewModel.getDetail(detailHash)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuDetailAdapter = MenuDetailAdapter()
        val viewPagerAdapter = ViewPagerAdapter()
        navigator = Navigation.findNavController(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvDetail.adapter = menuDetailAdapter
        binding.vpItemDetailImg.adapter = viewPagerAdapter

        registerOrderQuantityControlBtn()
        setMenuInfo()
        bindViewPagerPageNum()
        registerOrderClickBtn()

        viewModel.detailInfo.observe(viewLifecycleOwner) { menuDetail ->
            binding.detail = menuDetail
            binding.totalPage = menuDetail.thumbnailImages.size
            menuDetailAdapter.submitDetailImages(menuDetail.detailImages)
            viewPagerAdapter.submitThumbnails(menuDetail.thumbnailImages)
        }

        viewModel.orderSuccess.observe(viewLifecycleOwner) { isSuccess ->
            when (isSuccess) {
                true -> OrderCompleteDialogFragment().show(parentFragmentManager, "order_complete")
                else -> OrderCancelDialogFragment(getString(R.string.label_order_fail)).show(parentFragmentManager, "order_fail")
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun bindViewPagerPageNum() {
        binding.nowPage = 1
        binding.totalPage = viewModel.detailInfo.value?.thumbnailImages?.size
        binding.vpItemDetailImg.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.nowPage = (position + 1)
            }
        })
    }

    private fun registerOrderClickBtn() {
        binding.btnOrder.setOnClickListener {
            when (val orderCount = binding.tvOrderCountValue.text.toString().toInt()) {
                ORDER_COUNT_ZERO -> OrderCancelDialogFragment(getString(R.string.label_order_cancel)).show(parentFragmentManager, "order_cancel")
                else -> {
                    val name = requireActivity().getSharedPreferences("userName", AppCompatActivity.MODE_PRIVATE).getString("name", null)
                    if (name == null) { navigator.navigate(R.id.action_menuDetailFragment_to_loginFragment) }
                    val message = "${name}님 주문사항: ${binding.tvMenuTitle.text} (개당 ${binding.tvMenuPrice.text})를 ${orderCount}개를 주문하셨습니다. 총 결재금액은 ${binding.tvTotalPayValue.text}입니다"
                    viewModel.saveOrder(message)
                }
            }
        }
    }

    private fun registerOrderQuantityControlBtn() {
        registerOrderIncreaseBtn()
        registerOrderDecreaseBtn()
    }

    private fun registerOrderIncreaseBtn() {
        binding.btnIncreaseOrderCount.setOnClickListener {
            val curCount = binding.tvOrderCountValue.text.toString().toInt()
            binding.tvOrderCountValue.text = "${curCount + 1}"
            setTotalPay()
        }
    }

    private fun registerOrderDecreaseBtn() {
        binding.btnDecreaseOrderCount.setOnClickListener {
            val curCount = binding.tvOrderCountValue.text.toString().toInt()
            if (curCount > 0) {
                binding.tvOrderCountValue.text = "${curCount - 1}"
                setTotalPay()
            }
        }
    }

    private fun splitMenuPrice(menuPrice: String): Int {
        val priceString = menuPrice.substring(0, menuPrice.length - 1)
        return priceString.replace(",", "").toInt()
    }

    private fun setTotalPay() {
        val totalCount = binding.tvOrderCountValue.text.toString().toInt()
        val menuPrice = splitMenuPrice(binding.tvMenuPrice.text.toString())
        binding.totalPay = totalCount * menuPrice
    }

    private fun setMenuInfo() {
        badges?.let {
            binding.badge = badges
        }
        binding.tvMenuTitle.text = title
    }

}