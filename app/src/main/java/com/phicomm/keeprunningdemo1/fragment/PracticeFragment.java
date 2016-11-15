package com.phicomm.keeprunningdemo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phicomm.keeprunningdemo1.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/3 11:01
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class PracticeFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.tv_information)
    RelativeLayout mTvInformation;
    @Bind(R.id.tv_distance)
    TextView       mTvDistance;
    @Bind(R.id.speed)
    TextView       mSpeed;
    @Bind(R.id.tv_speed)
    TextView       mTvSpeed;
    @Bind(R.id.duration)
    TextView       mDuration;
    @Bind(R.id.tv_duration)
    TextView       mTvDuration;
    @Bind(R.id.calorie)
    TextView       mCalorie;
    @Bind(R.id.tv_calorie)
    TextView       mTvCalorie;
    @Bind(R.id.iv_head)
    ImageView      mIvHead;
    @Bind(R.id.textView)
    TextView       mTextView;
    @Bind(R.id.iv_badge)
    ImageView      mIvBadge;
    @Bind(R.id.tv_date)
    TextView       mTvDate;
    @Bind(R.id.ll_information_head)
    LinearLayout   mLlInformationHead;
    @Bind(R.id.tv_me_train)
    RelativeLayout mTvMeTrain;


    private onSkipFragmrnt mOnSkipFragmrnt;
    private onSkipTrain    mOnSkipTrain;
    private View           mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_practice, null);

        initView();
        initEvent();


        ButterKnife.bind(this, mView);
        return mView;
    }

    private void initView() {
        mTvInformation = (RelativeLayout) mView.findViewById(R.id.tv_information);
        mTvMeTrain = (RelativeLayout) mView.findViewById(R.id.tv_me_train);
    }

    private void initEvent() {
        mTvInformation.setOnClickListener(this);
        mTvMeTrain.setOnClickListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_information:
                //以接口回调的方式fragment跳转fragment
                mOnSkipFragmrnt.setOnSkipFragment();
                break;
            case R.id.tv_me_train:
                mOnSkipTrain.setOnSkipTrain();
                break;
        }
    }





    public interface onSkipFragmrnt {
        public void setOnSkipFragment();
    }

    public void setOnSkipFragment(onSkipFragmrnt skipFragment) {
        this.mOnSkipFragmrnt = skipFragment;
    }

    public interface onSkipTrain {
        public void setOnSkipTrain();
    }

    public void setOnSkipTrain(onSkipTrain skipTrain) {
        this.mOnSkipTrain = skipTrain;
    }
}
