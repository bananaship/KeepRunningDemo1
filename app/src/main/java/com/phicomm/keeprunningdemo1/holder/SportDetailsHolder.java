package com.phicomm.keeprunningdemo1.holder;

import android.view.View;
import android.widget.TextView;

import com.phicomm.keeprunningdemo1.R;
import com.phicomm.keeprunningdemo1.bean.SportDetails;
import com.phicomm.keeprunningdemo1.global.App;

import butterknife.Bind;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/8 16:58
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class SportDetailsHolder extends BasicHolder<SportDetails> {
    @Bind(R.id.tv_item_distance)
    TextView mTvItemDistance;
    @Bind(R.id.tv_item_tiem)
    TextView mTvItemTiem;
    @Bind(R.id.tv_item_speed)
    TextView mTvItemSpeed;
    @Bind(R.id.tv_item_step)
    TextView mTvItemStep;

    @Override
    protected View createView() {
        return View.inflate(App.context, R.layout.item_sport_details, null);
    }

    @Override
    public void bindView(SportDetails appInfo) {

        mTvItemDistance.setText("跑步" + appInfo.getDistance() + "公里");
        mTvItemTiem.setText(appInfo.getTime());
        mTvItemSpeed.setText(appInfo.getSpeed());
        mTvItemStep.setText(appInfo.getStep());
    }
}
