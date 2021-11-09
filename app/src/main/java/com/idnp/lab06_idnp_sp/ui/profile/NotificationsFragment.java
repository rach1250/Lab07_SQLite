package com.idnp.lab06_idnp_sp.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.idnp.lab06_idnp_sp.R;
import com.idnp.lab06_idnp_sp.databinding.FragmentProfileBinding;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentProfileBinding binding;
    Context context;
    TextView edit_name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textNotifications;
        /*SharedPreferences*/
        edit_name = (TextView) getActivity().findViewById(R.id.text_notifications);
        SharedPreferences s1 = this.getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        edit_name.setText(s1.getString("name",""));
        /*---------------------------------------------------------------------------------------*/
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}