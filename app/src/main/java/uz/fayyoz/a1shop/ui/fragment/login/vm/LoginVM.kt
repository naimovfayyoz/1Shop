package uz.fayyoz.a1shop.ui.fragment.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.fayyoz.a1shop.domain.LoginUseCase
import uz.fayyoz.a1shop.domain.SaveAccessTokenUseCase
import uz.fayyoz.a1shop.model.Token
import uz.fayyoz.a1shop.ui.BaseViewModel

class LoginVM(
    private val loginUseCase: LoginUseCase,
    private val saveAccessTokenUseCase: SaveAccessTokenUseCase,
) : BaseViewModel() {
    private val _loginToken: MutableLiveData<Token> = MutableLiveData()
    val loginToken: LiveData<Token> get() = _loginToken

    suspend fun login(email: String, password: String): LiveData<Token> {
        viewModelScope.launch(exceptionHandler) {
            val loginResponse = loginUseCase.execute(email, password)
            if (loginResponse.isSuccessful) {
                _loginToken.postValue(loginResponse.body())
            }
        }
        return loginToken
    }

    suspend fun saveAccessTokens(accessToken: String) {
        saveAccessTokenUseCase.execute(accessToken)
    }
}
