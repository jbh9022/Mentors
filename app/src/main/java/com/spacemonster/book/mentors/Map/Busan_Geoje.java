package com.spacemonster.book.mentors.Map;



import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spacemonster.book.mentors.Dialog.CustomDialog_GeojeSeatIMG;
import com.spacemonster.book.mentors.R;
import com.spacemonster.book.mentors.databinding.BusanGeojeMapBinding;

import org.w3c.dom.Text;


public class Busan_Geoje extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater;
    private BusanGeojeMapBinding binding;
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
    protected static int currentX = 0;
    protected static int currentY = 0;
    public Busan_Geoje(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //바인딩
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.busan_geoje_map, container, false);
        View view = binding.getRoot();
        binding.busanGeogeSeatName.setVisibility(View.VISIBLE);
        for(int i =0; i<79; i++){
            layouts[i] = (LinearLayout) view.findViewById(layoutList[i]);
            textViews[i] = (TextView) view.findViewById(textList[i]);
        }
        //대각선 스크롤
        SoftScroll();
        //프로코프석
        layout1Click();
        //시그너스 1 석
        layout2Click();
        //시그너스 2 석
        layout3Click();
        //멘토르 1 석
        layout4Click();
        //멘토르 2 석
        layout5Click();

        ViewPager vp = (ViewPager) container;
        vp.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
    //프로코프석 클릭시
    public void layout1Click(){
        binding.busanGeogeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog_GeojeSeatIMG dialogGeojeSeatIMG = new CustomDialog_GeojeSeatIMG(context, R.color.red);
                dialogGeojeSeatIMG.CallDialog();

                for(int i =0; i<47; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i=47;i<79; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout1);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.red));
                }
            }
        });
    }
    public void layout2Click(){
        binding.busanGeogeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog_GeojeSeatIMG dialogGeojeSeatIMG = new CustomDialog_GeojeSeatIMG(context, R.color.blue);
                dialogGeojeSeatIMG.CallDialog();
                for(int i =0; i<29; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i=29;i<47; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout2);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.blue));
                }
                for(int i=47;i<79; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.black));
                }
            }
        });
    }
    //시그너스석 클릭시
    private void layout3Click(){
        binding.busanGeogeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog_GeojeSeatIMG dialogGeojeSeatIMG = new CustomDialog_GeojeSeatIMG(context, R.color.green);
                dialogGeojeSeatIMG.CallDialog();
                for(int i =0; i<5; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout3);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.green));
                }
                for(int i =5; i<10; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i=10;i<19; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout3);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.green));
                }
                for(int i=19;i<26; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i=26;i<29; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout3);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.green));
                }
                for(int i=29;i<79; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
            }
        });
    }
    //멘토르 1석 클릭시
    private void layout4Click(){
        binding.busanGeogeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog_GeojeSeatIMG dialogGeojeSeatIMG = new CustomDialog_GeojeSeatIMG(context, R.color.yellow);
                dialogGeojeSeatIMG.CallDialog();
                for(int i =0; i<5; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i =5; i<9; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout4);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.yellow));
                }
                for(int i =9; i<21; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i =21; i<26; i++){
                    layouts[i].setBackgroundResource(R.drawable.bgeoje_layout4);
                    textViews[i].setTextColor(view.getResources().getColor(R.color.yellow));
                }
                for(int i =26; i<79; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
            }
        });
    }
    //멘토르2석 클릭시
    private void layout5Click(){
        binding.busanGeogeLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog_GeojeSeatIMG dialogGeojeSeatIMG = new CustomDialog_GeojeSeatIMG(context, R.color.purple);
                dialogGeojeSeatIMG.CallDialog();
                for(int i =0; i<9; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i =10; i<19; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                for(int i =21; i<79; i++){
                    layouts[i].setBackgroundResource(R.color.gray);
                    textViews[i].setTextColor(Color.BLACK);
                }
                layouts[9].setBackgroundResource(R.drawable.bgeoje_layout5);
                textViews[9].setTextColor(view.getResources().getColor(R.color.purple));
                layouts[19].setBackgroundResource(R.drawable.bgeoje_layout5);
                textViews[19].setTextColor(view.getResources().getColor(R.color.purple));
                layouts[20].setBackgroundResource(R.drawable.bgeoje_layout5);
                textViews[20].setTextColor(view.getResources().getColor(R.color.purple));
            }
        });

    }
    private void SoftScroll(){
        binding.geojeVscroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toutch(view, motionEvent);
                return false;
            }
        });
        binding.geojeHscroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toutch(view, motionEvent);
                return false;
            }
        });
    }
    private void Toutch(View v, MotionEvent event){
        switch (event.getAction()){
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

    private void scrollBy(int x, int y){
        binding.geojeHscroll.scrollBy(x, 0);
        binding.geojeVscroll.scrollBy(0, y);
    }
}
