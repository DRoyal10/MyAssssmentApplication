import com.example.myassssmentapplication.DashboardItem
import com.example.myassssmentapplication.DashboardResponse
import com.example.myassssmentapplication.LoginRequest
import com.example.myassssmentapplication.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call


interface ApiService {
    @POST("sydney/auth")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("dashboard/{keypass}")
    fun getDashboardData(
        @Path("keypass") keypass: String
    ): Call<DashboardResponse>
}
