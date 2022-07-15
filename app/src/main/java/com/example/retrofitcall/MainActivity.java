package com.example.retrofitcall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String TAG = "milan";
    ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superListView = (ListView) findViewById(R.id.superListView);

        getSuperHeros();
    }

    private void getSuperHeros() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeros();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myHeroList = response.body();
                String[] oneHeros = new String[myHeroList.size()];

                for (int i = 0;i<myHeroList.size();i++)
                {
                    oneHeros[i] = myHeroList.get(i).getName();
                }
               Log.d(TAG,myHeroList.toString());

                //Log.d("message showing", Arrays.toString(oneHeros));
                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,oneHeros));


            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}