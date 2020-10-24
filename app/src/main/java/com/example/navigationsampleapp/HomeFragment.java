package com.example.navigationsampleapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.text.DecimalFormat;

public class HomeFragment extends Fragment {

    DecimalFormat df = new DecimalFormat("###.###");


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.next_fragment_button);
        final EditText lengthInCmEt = view.findViewById(R.id.length_in_cm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.launchSecondFragment().setLengthInFeet(convertToFeet(lengthInCmEt.getText().toString())));
            }
        });

    }

    public String convertToFeet(String lengthInCm){
        double lengthCm;
        String result;

        try {
            lengthCm = Double.parseDouble(lengthInCm);
            double lengthInFt = lengthCm/30.48;
            result = df.format(lengthInFt) +" ft";

        } catch (NumberFormatException e) {
            result = null;
        }

        return result;
    }

}