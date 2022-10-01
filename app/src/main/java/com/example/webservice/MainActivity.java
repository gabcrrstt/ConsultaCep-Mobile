package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity
    {
    private Button btnRecupera;
    private TextView txtResultado;
    private EditText edtcep;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecupera = findViewById(R.id.btnRecupera);
        txtResultado = findViewById(R.id.txtResultado);
        edtcep        = findViewById(R.id.edtCEP);

        Activity    act = this;

        btnRecupera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
                {
                MyTask task = new MyTask();
                String urlApi = "https://viacep.com.br/ws/"+edtcep.getText().toString()+"/json/";

                task.AddTxtLoading(findViewById(R.id.txtResultado), act);
                edtcep.setText("");
                task.execute(urlApi);

                    txtResultado.setText("Carregando...");
                }
            });

        }

    }