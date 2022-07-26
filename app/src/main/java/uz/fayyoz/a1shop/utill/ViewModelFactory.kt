package uz.fayyoz.a1shop.utill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.fayyoz.a1shop.di.RepositoryModule
import uz.fayyoz.a1shop.domain.GetByCategoryUseCase
import uz.fayyoz.a1shop.domain.LoginUseCase
import uz.fayyoz.a1shop.domain.SaveAccessTokenUseCase
import uz.fayyoz.a1shop.domain.SignUpUseCase
import uz.fayyoz.a1shop.ui.fragment.category.vm.CategoryVM
import uz.fayyoz.a1shop.ui.fragment.login.vm.LoginVM
import uz.fayyoz.a1shop.ui.fragment.signUp.vm.SignUpVM

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val productRepo = RepositoryModule.bindProductsRepo()
        val loginRepo = RepositoryModule.bindLoginRepo()
        val signUpRepo = RepositoryModule.bindSignUpRepo()
        return if (modelClass.isAssignableFrom(CategoryVM::class.java)) {
            CategoryVM(GetByCategoryUseCase(productRepo)) as T
        } else if (modelClass.isAssignableFrom(LoginVM::class.java)) {
            LoginVM(LoginUseCase(loginRepo), SaveAccessTokenUseCase(loginRepo)) as T
        } else if (modelClass.isAssignableFrom(SignUpVM::class.java)) {
            SignUpVM(SignUpUseCase(signUpRepo)) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}

