package com.spacemonster.book.mentors.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.spacemonster.book.mentors.Adapter.Frag3_VpAdapter;
import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.Fragment3Binding;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {
    private Fragment3Binding binding;
    private String[] frag3item={"지성인의 에티켓","카페 이용안내","컨퍼런스룸 이용안내","복층 이용안내",
                                "열람실 이용안내","프로코프석 이용안내","수면관리 서비스","프린터 이용안내", "바테이블 이용안내"};
    private int[] frag3img={R.drawable.info01, R.drawable.info02, R.drawable.info03, R.drawable.info04,
                            R.drawable.info05, R.drawable.info06, R.drawable.info07, R.drawable.info08, R.drawable.info09};
    ArrayList<Integer> frag3_Img = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment3, container, false);
        frag3_Img.add(R.drawable.info01);
        frag3_Img.add(R.drawable.info02);
        frag3_Img.add(R.drawable.info03);
        frag3_Img.add(R.drawable.info04);
        frag3_Img.add(R.drawable.info05);
        frag3_Img.add(R.drawable.info06);
        frag3_Img.add(R.drawable.info07);
        frag3_Img.add(R.drawable.info08);
        frag3_Img.add(R.drawable.info09);
        Frag3Vp();

        Spinnerchoice();

        return binding.getRoot();
    }
    private void Frag3Vp(){
        Frag3_VpAdapter frag3VpAdapter = new Frag3_VpAdapter(getContext(), frag3_Img);
        binding.frag3Vp.setAdapter(frag3VpAdapter);
    }

    private void Spinnerchoice(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, frag3item);
        binding.frag3Spinner.setAdapter(adapter);
        binding.frag3Vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.frag3Spinner.setSelection(binding.frag3Vp.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.frag3Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                binding.frag3Vp.setCurrentItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
