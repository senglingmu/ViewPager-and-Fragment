package github.zhuoxin.com.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt1,bt2,bt3;
    FragmentManager fragmentManager;
    Fragment [] fragment=new Fragment[3];
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        choiceFragment(0);
    }
    // 隐藏掉所有的Fragment
    private void hideAllFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragment.length; i++) {
            if (fragment[i] != null)
                fragmentTransaction.hide(fragment[i]);
        }
        fragmentTransaction.commit();
    }
    private void choiceFragment(int index) {
        // 隐藏掉所有的Fragment
        hideAllFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        if (fragment[index]==null){
            switch (index){
                case 0:
                    fragment[index]=new Fragments();
                    fragmentTransaction.add(R.id.gragment,fragment[index]);

                    break;
                case 1:
                    fragment[index]=new Fragmentss();
                    fragmentTransaction.add(R.id.gragment,fragment[index]);

                    break;
                case 2:
                    fragment[index]=new Fragments();
                    fragmentTransaction.add(R.id.gragment,fragment[index]);
                    break;
            }
        }else
        {
            fragmentTransaction.show(fragment[index]);

        }
        fragmentTransaction.commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                choiceFragment(0);
                break;
            case R.id.bt2:
                choiceFragment(1);
                break;
            case R.id.bt3:
                choiceFragment(2);
                break;
        }
    }
}
