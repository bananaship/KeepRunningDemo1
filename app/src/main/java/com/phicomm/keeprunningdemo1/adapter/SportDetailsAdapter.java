package com.phicomm.keeprunningdemo1.adapter;

import com.phicomm.keeprunningdemo1.bean.SportDetails;
import com.phicomm.keeprunningdemo1.holder.BasicHolder;
import com.phicomm.keeprunningdemo1.holder.SportDetailsHolder;

import java.util.List;

/**
 * @创建者 xu_hao
 * @创建时间 2016/11/8 16:43
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class SportDetailsAdapter extends BasicAdapter<SportDetails> {

    public SportDetailsAdapter(List<SportDetails> showItems) {
        super(showItems);
    }

    @Override
    public BasicHolder createViewHolder(int postion) {
        return new SportDetailsHolder();
    }
}
