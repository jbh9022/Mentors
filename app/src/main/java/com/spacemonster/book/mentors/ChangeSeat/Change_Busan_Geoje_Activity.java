package com.spacemonster.book.mentors.ChangeSeat;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.ChangeBusanGeojeBinding;

public class Change_Busan_Geoje_Activity extends AppCompatActivity {

    private ChangeBusanGeojeBinding binding;
    private int[] layoutList = {R.id.b_gSeat1, R.id.b_gSeat2, R.id.b_gSeat3, R.id.b_gSeat4, R.id.b_gSeat5, R.id.b_gSeat6, R.id.b_gSeat7, R.id.b_gSeat8, R.id.b_gSeat9, R.id.b_gSeat10,
            R.id.b_gSeat11, R.id.b_gSeat12, R.id.b_gSeat13, R.id.b_gSeat14, R.id.b_gSeat15, R.id.b_gSeat16, R.id.b_gSeat17, R.id.b_gSeat18, R.id.b_gSeat19, R.id.b_gSeat20,
            R.id.b_gSeat21, R.id.b_gSeat22, R.id.b_gSeat23, R.id.b_gSeat24, R.id.b_gSeat25, R.id.b_gSeat26, R.id.b_gSeat27, R.id.b_gSeat28, R.id.b_gSeat29, R.id.b_gSeat30,
            R.id.b_gSeat31, R.id.b_gSeat32, R.id.b_gSeat33, R.id.b_gSeat34, R.id.b_gSeat35, R.id.b_gSeat36, R.id.b_gSeat37, R.id.b_gSeat38, R.id.b_gSeat39, R.id.b_gSeat40,
            R.id.b_gSeat41, R.id.b_gSeat42, R.id.b_gSeat43, R.id.b_gSeat44, R.id.b_gSeat45, R.id.b_gSeat46, R.id.b_gSeat47, R.id.b_gSeat48, R.id.b_gSeat49, R.id.b_gSeat50,
            R.id.b_gSeat51, R.id.b_gSeat52, R.id.b_gSeat53, R.id.b_gSeat54, R.id.b_gSeat55, R.id.b_gSeat56, R.id.b_gSeat57, R.id.b_gSeat58, R.id.b_gSeat59, R.id.b_gSeat60,
            R.id.b_gSeat61, R.id.b_gSeat62, R.id.b_gSeat63, R.id.b_gSeat64, R.id.b_gSeat65, R.id.b_gSeat66, R.id.b_gSeat67, R.id.b_gSeat68, R.id.b_gSeat69, R.id.b_gSeat70,
            R.id.b_gSeat71, R.id.b_gSeat72, R.id.b_gSeat73, R.id.b_gSeat74, R.id.b_gSeat75, R.id.b_gSeat76, R.id.b_gSeat77, R.id.b_gSeat78, R.id.b_gSeat79};
    private int[] textList = {R.id.b_gSeatT1, R.id.b_gSeatT2, R.id.b_gSeatT3, R.id.b_gSeatT4, R.id.b_gSeatT5, R.id.b_gSeatT6, R.id.b_gSeatT7, R.id.b_gSeatT8, R.id.b_gSeatT9, R.id.b_gSeatT10,
            R.id.b_gSeatT11, R.id.b_gSeatT12, R.id.b_gSeatT13, R.id.b_gSeatT14, R.id.b_gSeatT15, R.id.b_gSeatT16, R.id.b_gSeatT17, R.id.b_gSeatT18, R.id.b_gSeatT19, R.id.b_gSeatT20,
            R.id.b_gSeatT21, R.id.b_gSeatT22, R.id.b_gSeatT23, R.id.b_gSeatT24, R.id.b_gSeatT25, R.id.b_gSeatT26, R.id.b_gSeatT27, R.id.b_gSeatT28, R.id.b_gSeatT29, R.id.b_gSeatT30,
            R.id.b_gSeatT31, R.id.b_gSeatT32, R.id.b_gSeatT33, R.id.b_gSeatT34, R.id.b_gSeatT35, R.id.b_gSeatT36, R.id.b_gSeatT37, R.id.b_gSeatT38, R.id.b_gSeatT39, R.id.b_gSeatT40,
            R.id.b_gSeatT41, R.id.b_gSeatT42, R.id.b_gSeatT43, R.id.b_gSeatT44, R.id.b_gSeatT45, R.id.b_gSeatT46, R.id.b_gSeatT47, R.id.b_gSeatT48, R.id.b_gSeatT49, R.id.b_gSeatT50,
            R.id.b_gSeatT51, R.id.b_gSeatT52, R.id.b_gSeatT53, R.id.b_gSeatT54, R.id.b_gSeatT55, R.id.b_gSeatT56, R.id.b_gSeatT57, R.id.b_gSeatT58, R.id.b_gSeatT59, R.id.b_gSeatT60,
            R.id.b_gSeatT61, R.id.b_gSeatT62, R.id.b_gSeatT63, R.id.b_gSeatT64, R.id.b_gSeatT65, R.id.b_gSeatT66, R.id.b_gSeatT67, R.id.b_gSeatT68, R.id.b_gSeatT69, R.id.b_gSeatT70,
            R.id.b_gSeatT71, R.id.b_gSeatT72, R.id.b_gSeatT73, R.id.b_gSeatT74, R.id.b_gSeatT75, R.id.b_gSeatT76, R.id.b_gSeatT77, R.id.b_gSeatT78, R.id.b_gSeatT79};
    LinearLayout[] layouts = new LinearLayout[79];
    TextView[] textViews = new TextView[79];
    private static ScrollView vScroll;
    private static HorizontalScrollView hScroll;
    private static int currentX = 0;
    private static int currentY = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_busan_geoje);
        binding = DataBindingUtil.setContentView(this, R.layout.change_busan_geoje);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //status bar 색상 녹색 변경
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            //status bar 색이 흰색일 경우 검은색으로 변경
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            //대각선 스크롤
            SoftScroll();
            //좌석 연결
            init();
            //변경가능 좌석 색 표시
            SeatColor();
            //좌석 선택
            SeatChoice();
            //뒤로가기
            Backbtn();
            //새로고침
            RefreshBtn();
            //좌석 변경
            Seatchange();
    }
    //좌석변경
    private void Seatchange() {
        binding.changeGeojeSeatChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seat1 = binding.changeGeojeNewName.getText().toString();
                String seat2 = binding.changeGeojeNewNum.getText().toString();
                if(seat1.equals("") || seat2.equals("")){
                    Toast.makeText(Change_Busan_Geoje_Activity.this, "변경 가능한 자유석을 선택해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Change_Busan_Geoje_Activity.this, seat1 + " " + seat2 + "로 변경 되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //새로고침
    private void RefreshBtn() {
        binding.changeGeojeRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Change_Busan_Geoje_Activity.this, "새로고침", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //뒤로가기
    private void Backbtn() {
        binding.changeGeojeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //대각선 스크롤
    private void SoftScroll() {
        vScroll = (ScrollView) findViewById(R.id.geoje_Vscroll);
        hScroll = (HorizontalScrollView)findViewById(R.id.geoje_Hscroll);
        vScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Touch(view, motionEvent);
                return false;
            }
        });
        hScroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Touch(view, motionEvent);
                return false;
            }
        });
    }
    public static void scrollBy(int x, int y)
    {
        hScroll.scrollBy(x, 0);
        vScroll.scrollBy(0, y);
    }

    public void Touch(View v, MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                currentX = (int)event.getRawX();
                currentY = (int)event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int x2 = (int)event.getRawX();
                int y2 = (int)event.getRawY();
                scrollBy(currentX-x2, currentY-y2);
                currentX = x2;
                currentY = y2;
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                currentX = (int)event.getRawX();
                currentY = (int)event.getRawY();
                break;
        }
        currentX = (int)event.getRawX();
        currentY = (int)event.getRawY();
    }

    private void init(){
        for(int i =0; i<79; i++){
            layouts[i] = (LinearLayout) findViewById(layoutList[i]);
            textViews[i] = (TextView) findViewById(textList[i]);
        }
    }
    //좌석 색 변경
    private void SeatColor(){
        for(int i =0; i<29; i++){
            layouts[i].setBackgroundResource(R.color.gray2);
            textViews[i].setText("");
        }
        for (int i = 29; i<47; i++){
            layouts[i].setBackgroundResource(R.drawable.bgeoje_layout2);
            textViews[i].setTextColor(getResources().getColor(R.color.blue));
        }
        for (int i = 47; i<79; i++){
            layouts[i].setBackgroundResource(R.drawable.bgeoje_layout1);
            textViews[i].setTextColor(getResources().getColor(R.color.red));
        }
    }
//좌석 선택시 선택 좌석 밑에 표시
    private void SeatChoice(){
        for(int i =0; i<29; i++){
            final int a = i+1;
            layouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.changeGeojeNewName.setText("");
                    binding.changeGeojeNewName.setTextColor(getResources().getColor(R.color.black));
                    binding.changeGeojeNewNum.setText("");
//                        Toast.makeText(Change_Busan_Geoje_Activity.this, String.valueOf(a), Toast.LENGTH_SHORT).show();
                }
            });
        }
        for (int i = 29; i<47; i++){
            final int a = i+1;
            layouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.changeGeojeNewName.setText("시그너스Ⅰ석");
                    binding.changeGeojeNewName.setTextColor(getResources().getColor(R.color.blue));
                    binding.changeGeojeNewNum.setText(String.valueOf(a));
                    binding.changeGeojeNewNum.setTextColor(getResources().getColor(R.color.blue));
                }
            });
        }
        for (int i = 47; i<79; i++){
            final int a = i+1;
            layouts[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.changeGeojeNewName.setText("프로코프석");
                    binding.changeGeojeNewName.setTextColor(getResources().getColor(R.color.red));
                    binding.changeGeojeNewNum.setText(String.valueOf(a));
                    binding.changeGeojeNewNum.setTextColor(getResources().getColor(R.color.red));
                }
            });
        }
    }


}
