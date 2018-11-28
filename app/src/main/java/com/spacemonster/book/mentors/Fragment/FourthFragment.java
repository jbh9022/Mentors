package com.spacemonster.book.mentors.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.Fragment4Binding;

public class FourthFragment extends Fragment {
    Fragment4Binding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment4, container, false);
        return binding.getRoot();
    }
}
