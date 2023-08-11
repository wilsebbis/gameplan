package com.example.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.timer.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private NumberPicker picker1;
    private NumberPicker picker2;
    private NumberPicker picker3;
    public boolean timer_running;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        picker1 = view.findViewById(R.id.picker1);
        picker2 = view.findViewById(R.id.picker2);
        picker3 = view.findViewById(R.id.picker3);
        picker1.setMaxValue(59);
        picker1.setMinValue(0);
        picker2.setMaxValue(59);
        picker2.setMinValue(0);
        picker3.setMaxValue(12);
        picker3.setMinValue(0);




        //view.findViewById(R.id.yourId).setOnClickListener(this);
        //or
        //getActivity().findViewById(R.id.yourId).setOnClickListener(this);
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}