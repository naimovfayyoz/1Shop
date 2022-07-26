package uz.fayyoz.a1shop.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import uz.fayyoz.a1shop.R
import uz.fayyoz.a1shop.databinding.LoginFragmentBinding
import uz.fayyoz.a1shop.di.RepositoryModule
import uz.fayyoz.a1shop.ui.BaseFragment

class LoginFragment : BaseFragment<LoginFragmentBinding>(R.layout.login_fragment) {

    override fun initViewBinding(view: View): LoginFragmentBinding = LoginFragmentBinding.bind(view)
    private val repo = RepositoryModule.bindProductsRepo()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEd.text.toString()
            lifecycleScope.launchWhenStarted {
                binding.textView3.text= repo.login(email, password).toString()
            }
        }
        binding.signupBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_signUpFragment)

        }
    }
}