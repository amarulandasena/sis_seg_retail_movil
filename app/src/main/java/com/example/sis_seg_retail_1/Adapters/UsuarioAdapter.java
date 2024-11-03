package com.example.sis_seg_retail_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sis_seg_retail_1.Models.DtoRespuestaLogin;
import com.example.sis_seg_retail_1.R;

public class UsuarioAdapter extends RecyclerView.Adapter <UsuarioAdapter.ViewHolder> {

    DtoRespuestaLogin _datosUsuario;
    Context _contexto;

    public UsuarioAdapter (DtoRespuestaLogin datosUsuario, Context contexto) {
        this._datosUsuario = datosUsuario;
        this._contexto = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuariocard, parent, false);

        return new ViewHolder(root);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_tipoIdentificacion.setText(_datosUsuario.getTipoIdentificacion());
        holder.tv_numeroIdentificacion.setText(_datosUsuario.getNumIdentificacion());
        holder.tv_nombres.setText(_datosUsuario.getNombres());
        holder.tv_apellidos.setText(_datosUsuario.getApellidos());
        holder.tv_rol.setText(_datosUsuario.getRol());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tipoIdentificacion, tv_numeroIdentificacion, tv_nombres, tv_apellidos, tv_rol;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tipoIdentificacion = itemView.findViewById(R.id.tv_tipoIdentificacion);
            tv_numeroIdentificacion = itemView.findViewById(R.id.tv_numeroIdentificacion);
            tv_nombres = itemView.findViewById(R.id.tv_nombres);
            tv_apellidos = itemView.findViewById(R.id.tv_apellidos);
            tv_rol = itemView.findViewById(R.id.tv_rol);

        }
    }
}
