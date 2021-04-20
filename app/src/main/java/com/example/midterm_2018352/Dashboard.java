package com.example.midterm_2018352;

import android.os.Bundle;

import com.example.midterm_2018352.models.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dashboard extends AppCompatActivity {

    private Result users;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonAPI service = retrofit.create(JsonAPI.class);

        Call<Result> call = service.getPosts();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {


                Result results = response.body();
                users = results;
                TextView textView = findViewById(R.id.data);

                textView.setText("");
                //textView.append(users.getTitle() + " " + users.getUserId());
                String id;
                Integer title;
                Log.d("test", users.getTitle());
               // for(i: users)
                {
                 /*   id=users.getTitle();
                    title=users.getUserId();
                    textView.append(id + " " + title + "\n");*/
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                Log.e("", t.getLocalizedMessage());

            }
        });


    }
}