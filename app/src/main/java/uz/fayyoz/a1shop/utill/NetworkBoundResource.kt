package uz.fayyoz.a1shop.utill

import kotlinx.coroutines.flow.*


inline fun <DB, REMOTE> networkBoundResource(
    crossinline  query: () -> Flow<DB>,
    crossinline  fetch: suspend () -> REMOTE,
    crossinline  saveFetchResult: suspend (REMOTE) -> Unit,
    crossinline  shouldFetch: (DB) -> Boolean = { true },
) = flow {

    val data = query().first() // collection 1 time

    val flow = if (shouldFetch(data)) {
        log("Fetching from remote")
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        log("emitLocalDB")
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}