package com.mancomunidadmontejurra.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mancomunidadmontejurra.myapp.Conexion.MySQLConnection;

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    private final String tabla = "users";
    TextView erroLbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        erroLbl = findViewById(R.id.txtErrorShow);

        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM "+tabla);
            consulta.executeQuery();
        }catch (Exception e){
          erroLbl.setText(e.toString());

        }
    }
}