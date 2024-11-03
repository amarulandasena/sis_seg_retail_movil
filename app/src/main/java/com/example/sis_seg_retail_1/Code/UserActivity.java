package com.example.sis_seg_retail_1.Code;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import com.example.sis_seg_retail_1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserActivity extends AppCompatActivity {

    private String Usuario;
    TextView datoUsuario;
    FragmentContainerView fcv_usuarios;
    BottomNavigationView bnv_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        datoUsuario = findViewById(R.id.id_usuario);
        Usuario = getIntent().getStringExtra("Usuario");
        datoUsuario.setText(Usuario);

        fcv_usuarios = findViewById(R.id.fcv_usuarios);
        bnv_menu = findViewById(R.id.bnv_menuapp);
        reemplazarFragment(new UsuariosFragment());

        bnv_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mnit_usuarios){

                    reemplazarFragment(new UsuariosFragment());

                } else if (item.getItemId() == R.id.mnit_tiendas) {

                    reemplazarFragment(new TiendasFragment());

                } else if (item.getItemId() == R.id.mnit_reservas) {

                    reemplazarFragment(new ReservasFragment());

                }
                return true;
            }
        });

    }

    public void reemplazarFragment(Fragment fragment) {
        FragmentTransaction transact = getSupportFragmentManager().beginTransaction();
        transact.replace(R.id.fcv_usuarios, fragment);
        transact.commit();
    }
}