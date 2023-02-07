package com.example.devilpetsforme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    API api = API.retrofit.create(API.class);
    final Call<Pets> call = api.repoPets(676767);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView;
        ImageView imageView;

        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView2);

        call.enqueue(new Callback<Pets>() {
            @Override
            public void onResponse(Call<Pets> call, Response<Pets> response) {
                if(response.isSuccessful()){
                    Pets pet = response.body();
                    ArrayList photo = pet.getImage();
                    textView.setText(pet.getName());
                    if(photo != null){
                        Picasso.get().load((String) photo.get(0)).into(imageView);
                    }
                }
            }

            @Override
            public void onFailure(Call<Pets> call, Throwable t) {
                textView.setText("f");
            }
        });
    }
    public void OnClick(View view){
        EditText inputId;
        EditText inputName;
        EditText inputStatus;

        inputId = findViewById(R.id.editTextTextPersonName);
        inputName = findViewById(R.id.editTextTextPersonName2);
        inputStatus = findViewById(R.id.editTextTextPersonName3);
        call.enqueue(new Callback<Pets>() {
            @Override
            public void onResponse(Call<Pets> call, Response<Pets> response) {
                Pets pet = response.body();
                pet.setId(Integer.parseInt(inputId.getText().toString()));
                pet.setName(inputName.getText().toString());
                pet.setStatus(inputStatus.getText().toString());
            }

            @Override
            public void onFailure(Call<Pets> call, Throwable t) {
                inputId.setText(t.toString());
                inputName.setText("F");
                inputStatus.setText("F");
            }
        });
        }
    }
}