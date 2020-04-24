package com.example.custos.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import android.widget.TextView
//import androidx.databinding.DataBindingUtil
//import com.example.custos.databinding.LoginFragmentBinding

import com.example.custos.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.login_fragment, container, false)
        val loginButton: Button = root.findViewById(R.id.btn_login)

        loginButton.setOnClickListener{
            val email: TextView = root.findViewById(R.id.input_email)
            val password: TextView = root.findViewById(R.id.input_password)

            NavHostFragment.findNavController(this).navigate(R.id.action_login_fragment_to_navigation_home)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel

    }

}
