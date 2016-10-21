package com.logan19gp.items;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.logan19gp.items.api.Ads;
import com.logan19gp.items.api.ApiService;
import com.logan19gp.items.api.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AdsAdapter productAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new AdsAdapter(this);
        recyclerView.setAdapter(productAdapter);

        final ApiService apiService = HttpClient.getApiService();
        final Call<Ads> providersCall = apiService.getAds(236, "OVUJ1DJN", 4288, "4230", "techtestsession", 10, "Huiban");

        providersCall.enqueue(new Callback<Ads>() {
            @Override
            public void onResponse(Call<Ads> call, Response<Ads> response) {
                if (response.isSuccessful()) {
                    final Ads newProviders = response.body();
                    productAdapter.addAds(newProviders.getAd());
                }
            }

            @Override
            public void onFailure(Call<Ads> call, Throwable t) {
                Log.e("NETWORK", "fail" + t.getLocalizedMessage());
                t.printStackTrace();
            }
        });
    }
}
