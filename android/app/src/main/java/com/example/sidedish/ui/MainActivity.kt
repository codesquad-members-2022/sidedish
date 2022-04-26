package com.example.sidedish.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityMainBinding
import com.example.sidedish.ui.menu.HomeActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private val googleSignInIntent by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
        GoogleSignIn.getClient(this, gso).signInIntent
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object {
        const val RESULT_CODE = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.signInButton.setOnClickListener {
            startForResult.launch(googleSignInIntent)
            setResult(RESULT_CODE)
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            Log.d("TAG", currentUser.toString())
        }
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data?.let { Auth.GoogleSignInApi.getSignInResultFromIntent(it) }

                intent?.let {
                    if (it.isSuccess) {
                        it.signInAccount?.displayName //이름
                        it.signInAccount?.email //이메일
                        Log.e("Value", it.signInAccount?.email!!)
                        it.signInAccount?.let { account ->
                            firebaseLogin(account)
                        }
                    } else {
                        Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                        // 에러 처리
                    }
                }
            }
        }

    private fun firebaseLogin(googleAccount: GoogleSignInAccount) {

        val credential = GoogleAuthProvider.getCredential(googleAccount.idToken, null)

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                //사용자 이름
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("massage", "로그인 성공! ${it.result?.user?.displayName}님 환영합니다!")
                startActivity(intent)
            } else {
                Toast.makeText(this, "인증에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            //error 처리
            Toast.makeText(this, "인증에 실패하였습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}