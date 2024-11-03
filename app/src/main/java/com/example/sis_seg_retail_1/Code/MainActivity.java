package com.example.sis_seg_retail_1.Code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sis_seg_retail_1.Models.DtoLogin;
import com.example.sis_seg_retail_1.Models.DtoRespuestaLogin;
import com.example.sis_seg_retail_1.R;
import com.example.sis_seg_retail_1.Retrofit.RetrofitAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText et_usuario;
    EditText et_contrasegna;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_usuario = findViewById(R.id.et_ingresarUsuario);
        et_contrasegna = findViewById(R.id.et_ingresarContrasegna);
        btn_ingresar = findViewById(R.id.btn_Ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSesion(et_usuario.getText().toString(), et_contrasegna.getText().toString());
            }
        });

    }

    public void IniciarSesion (String Usuario, String Contrasegna) {
        DtoLogin objLog = new DtoLogin();
        objLog.setNumIdentificacion(Usuario);
        objLog.setContrasegna(Contrasegna);

        Call<DtoRespuestaLogin> login = RetrofitAdapter.getService().login(objLog);
        login.enqueue(new Callback<DtoRespuestaLogin>() {
            @Override
            public void onResponse(Call<DtoRespuestaLogin> call, Response<DtoRespuestaLogin> response) {
                if(response.isSuccessful() && response.body() != null) {
                    DtoRespuestaLogin infoLog = response.body();

                    if(Contrasegna.equals(infoLog.getContrasegna())) {
                        Toast.makeText(MainActivity.this, "Bienvenido: " + infoLog.getNombres() + " " + infoLog.getApellidos(), Toast.LENGTH_SHORT).show();

                        Intent cambiarAct = new Intent (MainActivity.this, UserActivity.class);
                        cambiarAct.putExtra("Usuario", infoLog.getNumIdentificacion());
                        startActivity(cambiarAct);

                    } else {
                        Toast.makeText(MainActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.i("Respuesta", "Error, ingrese sus datos de nuevo" + response.raw() + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<DtoRespuestaLogin> call, Throwable t) {
                Log.e("Respuesta", "Error en el servidor" + t.getMessage() + t.getCause());
            }
        });
    }
}