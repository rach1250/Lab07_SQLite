package com.idnp.lab06_idnp_sp.ui.home;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.idnp.lab06_idnp_sp.MainActivity;
import com.idnp.lab06_idnp_sp.SharedPefManager;
import com.idnp.lab06_idnp_sp.databinding.FragmentHomeBinding;
import com.idnp.lab06_idnp_sp.db.DbHelper;
import com.idnp.lab06_idnp_sp.db.dbUsuarios;
import com.idnp.lab06_idnp_sp.entidades.Usuario;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView textView2 = binding.textCorreo;
        final TextView textView3 = binding.textDni;

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //cambio textview con sharedPref

                dbUsuarios db = new dbUsuarios(getContext());
                Usuario user = db.retornarDatoUsuario();

                textView.setText(user.getNombre());
                textView2.setText(user.getDni());
                textView3.setText(user.getCorreo());
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void CerrarSesion(View view){
        SharedPefManager.borrarPreferencias();
        Intent i = new Intent(this.getActivity(), MainActivity.class);
        startActivity(i);
    }
}