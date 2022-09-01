package uz.fayyoz.a1shop.utill

sealed class Resource<T>(

    val data: T? = null,
    val error: Throwable? = null,
) {

    class InitialState<T>:Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>(data, throwable)
}