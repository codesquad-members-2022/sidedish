package com.example.todo.sidedish.ui.login

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.todo.sidedish.R
import com.example.todo.sidedish.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var gso: GoogleSignInOptions
    private lateinit var gsc: GoogleSignInClient
    private lateinit var googleLoginLauncher: ActivityResultLauncher<Intent>
    private lateinit var parentContext: Context
    private lateinit var navigator: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        loginBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return loginBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(parentContext, gso)
        gsc.signOut()
        navigator = Navigation.findNavController(view)
        registerLoginLauncher()
        loginBinding.signInButton.setOnClickListener {
            val signInIntent = gsc.signInIntent
            googleLoginLauncher.launch(signInIntent)
        }
    }

    override fun onAttach(context: Context) {
        parentContext = context
        super.onAttach(context)
    }

    private fun registerLoginLauncher() { googleLoginLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    val pref = this.activity?.getSharedPreferences("userName", AppCompatActivity.MODE_PRIVATE)
                    //displayName을 sharedPreference 저장
                    val edit = pref?.edit() // 수정모드
                    edit?.putString("name", account.displayName) // 값 넣기
                    edit?.apply()
                    signIn()
                } catch (e: ApiException) {
                    Snackbar.make(this.requireView(), "Google Login API Error", Snackbar.LENGTH_LONG).show()
                }
            }
            else{
                Snackbar.make(this.requireView(), "Failed To Google Login", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun signIn() {
        navigator.navigate(R.id.action_loginFragment_to_menuFragment)
    }

}