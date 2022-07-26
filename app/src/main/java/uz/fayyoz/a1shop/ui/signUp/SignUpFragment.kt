package uz.fayyoz.a1shop.ui.signUp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import uz.fayyoz.a1shop.R
import uz.fayyoz.a1shop.databinding.LoginFragmentBinding
import uz.fayyoz.a1shop.databinding.RegisterFragmentBinding
import uz.fayyoz.a1shop.navigate
import uz.fayyoz.a1shop.ui.BaseFragment

class SignUpFragment : BaseFragment<RegisterFragmentBinding>(R.layout.register_fragment) {
    override fun initViewBinding(view: View): RegisterFragmentBinding =
        RegisterFragmentBinding.bind(view)

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogRegister.setOnClickListener {
            Log.d("TAG", "onViewCreated: ")
        }
    }
}