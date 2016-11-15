package com.phicomm.keeprunningdemo1.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.fragment.DayFragment;
import com.phicomm.keeprunningdemo1.fragment.DeviceFragment;
import com.phicomm.keeprunningdemo1.fragment.MeFragment;
import com.phicomm.keeprunningdemo1.fragment.MyTrainFragment;
import com.phicomm.keeprunningdemo1.fragment.PracticeFragment;
import com.phicomm.keeprunningdemo1.fragment.SportInformationFragment;
import com.phicomm.keeprunningdemo1.view.TitleBar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup  bottomBar;
    private RadioButton rbBottomHome;
    private RadioButton rbBottomSearch;
    private RadioButton rbBottomBrand;
    private RadioButton rbBottomCart;
    private RadioButton rbBottomMore;

    /**
     * 当前选中的Fragment
     */
    private PracticeFragment mPractice;
    private DeviceFragment   mDevice;
    private MeFragment       mMe;


    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_bottom_practice:
                    changeFragment(mPractice);
                    break;
                case R.id.rb_bottom_device:
                    changeFragment(mDevice);
                    break;
                case R.id.rb_bottom_me:
                    changeFragment(mMe);
                    break;
            }
        }
    };
    public  DayFragment mDay;
    private TitleBar    mTitleBar;


    private void changeFragment(Fragment frag) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, frag);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        initData();

        changeFragment(mPractice);
    }

    private void initData() {
        mPractice.setOnSkipFragment(new PracticeFragment.onSkipFragmrnt() {
            @Override
            public void setOnSkipFragment() {
                changeFragment(new SportInformationFragment());
            }
        });

        mPractice.setOnSkipTrain(new PracticeFragment.onSkipTrain() {
            @Override
            public void setOnSkipTrain() {
                changeFragment(new MyTrainFragment());
            }
        });


        mTitleBar.setTitle("Keep Running");
    }

    private void initView() {
        bottomBar = (RadioGroup) findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(listener);
        mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        mTitleBar.setImmersive(true);

    }

    private void initFragment() {
        mPractice = new PracticeFragment();
        mDevice = new DeviceFragment();
        mMe = new MeFragment();
        mDay = new DayFragment();
    }

    /**
     * 显示信息
     *
     * @param msg
     */
    public void toastMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
