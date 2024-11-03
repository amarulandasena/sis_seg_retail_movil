package com.example.sis_seg_retail_1.Code;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sis_seg_retail_1.Adapters.UsuarioAdapter;
import com.example.sis_seg_retail_1.Models.DtoRespuestaLogin;
import com.example.sis_seg_retail_1.R;
import com.example.sis_seg_retail_1.Retrofit.RetrofitAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsuariosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_usuarios, container, false);

        return root;
    }
}