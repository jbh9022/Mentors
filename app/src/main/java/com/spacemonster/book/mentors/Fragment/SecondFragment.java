package com.spacemonster.book.mentors.Fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import com.spacemonster.book.mentors.Map.Busan_Geoje;
import com.spacemonster.book.mentors.Map.Map_main;
import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.Fragment2Binding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    Fragment2Binding binding;
    String[] list={"지역선택","부산 거제점"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment2, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, list);
        binding.frag2Spinner.setAdapter(adapter);

//        Mapfrag();
        Spinnerselect();
        btn1();
        return binding.getRoot();
    }
    //스피너
    private void Spinnerselect(){
        binding.frag2Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //기본 흰페이지 연결
                        Map_main mapMain = new Map_main(getActivity());
                        binding.frag2Vp.setAdapter(mapMain);
                        break;
                    case 1:

                        Mapfrag();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void Mapfrag(){
        Busan_Geoje busan_geoje = new Busan_Geoje(getActivity());
        binding.frag2Vp.setAdapter(busan_geoje);
    }

    //프로코프석 클릭시
    private void btn1(){

    }
}
