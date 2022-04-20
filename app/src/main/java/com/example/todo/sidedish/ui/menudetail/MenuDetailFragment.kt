package com.example.todo.sidedish.ui.menudetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.todo.sidedish.R
import com.example.todo.sidedish.databinding.FragmentMenuDetailBinding
import com.example.todo.sidedish.databinding.FragmentMenuDetailBindingImpl
import com.google.android.gms.common.util.DataUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuDetailFragment : Fragment() {

    private lateinit var binding: FragmentMenuDetailBinding
    private lateinit var detailHash: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_menu_detail, container, false)
        val args= requireArguments()
        detailHash= args.getString("detailHash","")
        return inflater.inflate(R.layout.fragment_menu_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}