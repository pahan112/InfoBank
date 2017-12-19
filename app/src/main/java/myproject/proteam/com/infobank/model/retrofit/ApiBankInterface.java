package myproject.proteam.com.infobank.model.retrofit;


import myproject.proteam.com.infobank.model.ModelBank;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiBankInterface {
    @GET("ru/public/currency-cash.json")
    Call<ModelBank> getNews();
}
