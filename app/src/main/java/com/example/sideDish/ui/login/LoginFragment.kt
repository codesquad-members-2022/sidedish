package com.example.sideDish.ui.login

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.example.sideDish.R
import com.example.sideDish.ui.foodlist.FoodListFragment
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "LoginFragment"

// https://velog.io/@jinny_0422/Android-Kotlin-Firebase%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%9D%B4%EB%A9%94%EC%9D%BC-Google-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%95%98%EA%B8%B0
@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var googleSignInButton: SignInButton
    private var auth: FirebaseAuth? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_login, container, false)
        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val data = Auth.GoogleSignInApi.getSignInResultFromIntent(it.data!!)
                if (data!!.isSuccess) {
                    val account = data.signInAccount
                    firebaseAuthWithGoogle(account)
                }
            }
        }

        googleSignInButton = layout.findViewById(R.id.btn_google_login)
        googleSignInButton.setSize(SignInButton.SIZE_STANDARD)
        googleSignInButton.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            result.launch(signInIntent)
        }

        return layout
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken!!, null)
        auth?.signInWithCredential(credential)
            ?.addOnCompleteListener {
                task ->
                if (task.isSuccessful) {
                    Log.d(TAG, task.result.user?.displayName.toString())
                    navigateMainFragment(task.result.user?.displayName.toString())
                }
        }
    }

    private fun navigateMainFragment(id: String) {
        parentFragmentManager.commit {
            replace(
                R.id.container,
                FoodListFragment::class.java,
                bundleOf("ID" to id)
            )
        }
    }
}