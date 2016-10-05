package github.zhuoxin.com.viewpager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
    List<View> data;
    TextView textView;
    Viewpageradapter viewpageradapter;
    View view1,view2,view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=new ArrayList<>();
        textView= (TextView) findViewById(R.id.tv);
        view1= LayoutInflater.from(this).inflate(R.layout.rad1,null);
        view2= LayoutInflater.from(this).inflate(R.layout.rad1,null);
        view3= LayoutInflater.from(this).inflate(R.layout.rad1,null);
        data.add(view1);
        data.add(view2);
        data.add(view3);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewpageradapter=new Viewpageradapter(data);
        viewPager.setAdapter(viewpageradapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//滑动的监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {//滑动中
            }
            @Override
            public void onPageSelected(int position) {//滑动完成
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
