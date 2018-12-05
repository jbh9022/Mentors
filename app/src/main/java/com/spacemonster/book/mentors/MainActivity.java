package com.spacemonster.book.mentors;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.spacemonster.book.mentors.Fragment.FirstFragment;
import com.spacemonster.book.mentors.Fragment.FourthFragment;
import com.spacemonster.book.mentors.Fragment.SecondFragment;
import com.spacemonster.book.mentors.Fragment.ThirdFragment;
import com.spacemonster.book.mentors.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //Fragment 생성
    FirstFragment fragment1 = new FirstFragment();
    SecondFragment fragment2 = new SecondFragment();
    ThirdFragment fragment3 = new ThirdFragment();
    FourthFragment fragment4 = new FourthFragment();
    MenuItem prevMenuItem;
    public static MainActivity main;
    String id;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //네비게이션바 애니메이션 제거
        BottomNavigationViewHelper.disableShiftMode(binding.mainNavi);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //status bar 색상 녹색 변경
            getWindow().setStatusBarColor(getResources().getColor(R.color.mainColor));
            //status bar 색이 흰색일 경우 검은색으로 변경
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        username = intent.getStringExtra("username");

        main = MainActivity.this;

        loginBtn();
        FragmentAdapter();

    }

    private void loginBtn(){
        if(id ==null || id.equals("")) {
            binding.mainUserImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_login = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent_login);
                    finish();
//                Toast.makeText(MainActivity.this, "로그인버튼", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            binding.mainUserImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent userIntent = new Intent(MainActivity.this, UserInfoActivity.class);
                    userIntent.putExtra("ID", id);
                    userIntent.putExtra("username", username);
                    startActivity(userIntent);
                    finish();
//                    Toast.makeText(MainActivity.this, "로그인됨!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void FragmentAdapter(){
        binding.mainVp.setCurrentItem(0);
        binding.mainVp.setOffscreenPageLimit(4);
        binding.mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return fragment1;
                    case 1:
                        return fragment2;
                    case 2:
                        return fragment3;
                    case 3:
                        return fragment4;
                }
                return null;
            }

            @Override
            public int getCount() {
                //페이지 옆으로 넘김
                return 3;
            }
        });
        binding.mainNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page1:
                        //1번 페이지
                        binding.mainVp.setCurrentItem(0);
                        break;
                    case R.id.page2:
                        //2번 페이지
                        binding.mainVp.setCurrentItem(1);
                        break;
                    case R.id.page3:
                        //3번 페이지
                        binding.mainVp.setCurrentItem(2);
                        break;
                    case R.id.page4:
                        //4번 페이지
                        Toast.makeText(MainActivity.this,"추후예정입니다.", Toast.LENGTH_SHORT).show();
//                        binding.mainVp.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
        binding.mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    binding.mainNavi.getMenu().getItem(0).setChecked(false);
                }
                binding.mainNavi.getMenu().getItem(position).setChecked(true);
                prevMenuItem = binding.mainNavi.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //뒤로가기 버튼
    @Override
    public void onBackPressed() {
//        CustomDialog_Finish finish = new CustomDialog_Finish(MainActivity.this);
//        finish.CallDialog();

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setMessage("종료하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
    }
}
