package mobile.forkit.forkit_client.apis.apiHelpers;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import mobile.forkit.forkit_client.settings.URLs;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by horimori on 6/23/17.
 */

public class RetroHelper {
    public static Retrofit getRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(URLs.FULL_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
}
