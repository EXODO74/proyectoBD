package com.example.proyectobd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private List<Usuario> listaUsuarios;
    public UsuarioAdapter(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuarioAdapter.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        return new UsuarioViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioViewHolder holder, int position) {
        Usuario usuario=listaUsuarios.get(position);
        holder.bind(usuario);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }
    public class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre,telefono , correo, password;
        public UsuarioViewHolder(@NonNull View item) {
            super(item);
            nombre=item.findViewById(R.id.tvNombre);
            telefono=item.findViewById(R.id.tvTelefono);
            correo=item.findViewById(R.id.tvCorreo);
            password=item.findViewById(R.id.tvPassword);

        }
        public void bind(Usuario usuario) {
            nombre.setText("Nombre: "+usuario.getNombre());
            telefono.setText("Telefono: "+usuario.getTelefono());
            correo.setText("Correo: "+usuario.getCorreo());
            password.setText("Contraseña: "+usuario.getPassword());
        }
    }
}
