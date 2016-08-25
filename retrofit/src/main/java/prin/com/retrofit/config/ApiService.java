package prin.com.retrofit.config;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import prin.com.retrofit.model.Repo;
import prin.com.retrofit.model.User;
import prin.com.retrofit.model.Widget;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by prin on 2016/8/24.
 * <p/>
 * Http API
 */
public interface ApiService {

    /**
     * Get url manipulation
     * (1)Path
     * (2)Query
     * (3)QueryMap
     */
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("group/{id}/users")
    Call<List<User>> groupUsers(@Path("id") int groupId, @Query("sort") String sort);

    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    /**
     * Post
     * (1)Body
     */
    @POST("users/new")
    Call<User> createUser(@Body User user);

    /**
     * Form encoded and multipart
     * (1)field
     * （2）part
     */
    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

    /**
     * Header manipulation
     */
    @Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
    Call<List<Widget>> widgetList();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);


}
