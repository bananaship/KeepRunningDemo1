package com.phicomm.keeprunningdemo1.view;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.View;

import com.db.chart.Tools;
import com.db.chart.animation.Animation;
import com.db.chart.animation.easing.ElasticEase;
import com.db.chart.model.BarSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.tooltip.Tooltip;
import com.db.chart.view.BarChartView;
import com.phicomm.keeprunningdemo1.R;


public class BarCardThree extends CardController {


	private final Context mContext;


	private final BarChartView mChart;

	private final String[] mLabels =
			  {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

	private final float[][] mValues =
			  {{2.5f, 3.7f, 4f, 8f, 4.5f, 4f, 5f},
						 {3.5f, 4.7f, 5f, 9f, 5.5f, 5f, 6f}};


	public BarCardThree(CardView card, Context context) {

		super(card);

		mContext = context;
		mChart = (BarChartView) card.findViewById(R.id.chart6);
	}


	@Override
	public void show(Runnable action) {

		super.show(action);

		Tooltip tip = new Tooltip(mContext);
		tip.setBackgroundColor(Color.parseColor("#CC7B1F"));

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 1);
			tip.setEnterAnimation(alpha).setDuration(150);

			alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0);
			tip.setExitAnimation(alpha).setDuration(150);
		}

		mChart.setTooltips(tip);

		BarSet dataset = new BarSet(mLabels, mValues[0]);
		dataset.setColor(Color.parseColor("#eb993b"));
		mChart.addData(dataset);

		mChart.setBarSpacing(Tools.fromDpToPx(3));

		mChart.setXLabels(AxisRenderer.LabelPosition.NONE)
				  .setYLabels(AxisRenderer.LabelPosition.NONE)
				  .setXAxis(false)
				  .setYAxis(false);

		Animation anim = new Animation().setEasing(new ElasticEase()).setEndAction(action);

		mChart.show(anim);
	}


	@Override
	public void update() {

		super.update();

		mChart.dismissAllTooltips();
		if (firstStage) mChart.updateValues(0, mValues[1]);
		else mChart.updateValues(0, mValues[0]);
		mChart.notifyDataUpdate();
	}


	@Override
	public void dismiss(Runnable action) {

		super.dismiss(action);

		mChart.dismissAllTooltips();
		mChart.dismiss(new Animation().setEasing(new ElasticEase()).setEndAction(action));
	}

}
