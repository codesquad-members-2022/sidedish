package com.codesquadhan.sidedish.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityMainBinding
import com.codesquadhan.sidedish.ui.common.Common
import com.codesquadhan.sidedish.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter

    private val viewModel: MainViewModel by viewModels()

    private var JSESSIONID = ""

    private var isWebviewError = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setMainRv()
        setBtnGitHub()
        setRefreshLayout()
    }

    private fun setRefreshLayout(){
        binding.splLoginWebView.setOnRefreshListener {
            binding.webView.loadUrl("http://3.34.207.233:8080/login")
            binding.splLoginWebView.isRefreshing = false
        }
    }

    private fun setBtnGitHub() {
        binding.btnGithub.setOnClickListener {
            /* binding.clLogin.visibility = View.GONE
             binding.clMain.visibility = View.VISIBLE

             // 로그인 후 가정
             viewModel.getMainUIMenu()*/
            binding.clLogin.visibility = View.GONE
            binding.splLoginWebView.visibility = View.VISIBLE
            setWebView()
        }
    }

    private fun setWebView() {
        binding.webView.webViewClient = CustomWebViewClient()
        binding.webView.settings.javaScriptEnabled = true

        binding.webView.loadUrl("http://3.34.207.233:8080/login")
    }

    private fun setMainRv() {
        mainAdapter = makeMainAdapter()
        binding.rvMain.adapter = mainAdapter
        viewModel.menuMainListLiveData.observe(this) {
            mainAdapter.submitList(it.toList())
        }
    }


    private fun makeMainAdapter(): MainAdapter {
        return MainAdapter { it ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
    }

    inner class CustomWebViewClient() : WebViewClient() {

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)

            isWebviewError = true
            Log.d("AppTest", "webView Error!!!!!")
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            Log.d("AppTest", "onPageFinished/ url : ${url}")

            if(!isWebviewError) {
                val cookies = CookieManager.getInstance().getCookie(url)
                Log.d("AppTest", "onPageFinished/ cookie : ${cookies}")

                cookies?.let {
                    if (it.contains("JSESSIONID")) {
                        JSESSIONID = it
                        Common.JESSIONID = it
                        Log.d("AppTest", "login success, JSESSIONID : ${JSESSIONID}")

                        binding.splLoginWebView.isVisible = false
                        binding.clMain.isVisible = true
                        viewModel.getMainUIMenu()
                    }
                }
            }
            isWebviewError = false
        }
    }

}