package project.mr.chordify.model.api

//<T : Any> means T must not be null, plain <T> means that it can be nullable (which is represented by Any?)
sealed class APIResponse<T : Any> {
    class Success<T: Any>(val data: T) : APIResponse<T>()
    class Error<T: Any>(val code: Int, val message: String?) : APIResponse<T>()
    class Exception<T: Any>(val e: Throwable) : APIResponse<T>()
}

data class ResponseDTO <T>(
    val data: T,
    val ok: Boolean,
    val isError: Boolean?,
    val errorMessage: String?
)
