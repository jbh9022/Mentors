package com.spacemonster.book.mentors.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.Fragment3Binding;

public class ThirdFragment extends Fragment {
    private Fragment3Binding binding;
    private String[] frag3item={"지성인의 에티켓","카페 이용안내","컨퍼런스룸 이용안내","복층 이용안내",
                                "열람실 이용안내","프로코프석 이용안내","수면관리 서비스","프린터 이용안내", "바테이블 이용안내"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment3, container, false);

        Spinnerchoice();

        return binding.getRoot();
    }

    private void Spinnerchoice(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, frag3item);
        binding.frag3Spinner.setAdapter(adapter);
        binding.frag3Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        binding.frag3Img.setImageResource(R.drawable.test1);
                        break;
                    case 1:
                        binding.frag3Img.setImageResource(R.drawable.test2);
                        break;
                    case 2:
                        binding.frag3Img.setImageResource(R.drawable.test1);
                        break;
                    case 3:
                        binding.frag3Img.setImageResource(R.drawable.test2);
                        break;
                    case 4:
                        binding.frag3Img.setImageResource(R.drawable.test1);
                        break;
                    case 5:
                        binding.frag3Img.setImageResource(R.drawable.test2);
                        break;
                    case 6:
                        binding.frag3Img.setImageResource(R.drawable.test1);
                        break;
                    case 7:
                        binding.frag3Img.setImageResource(R.drawable.test2);
                        break;
                    case 8:
                        binding.frag3Img.setImageResource(R.drawable.test1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
