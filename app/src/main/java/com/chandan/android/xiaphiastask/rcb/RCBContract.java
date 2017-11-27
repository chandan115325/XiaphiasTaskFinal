package com.chandan.android.xiaphiastask.rcb;

import com.chandan.android.xiaphiastask.model.Items;

import java.util.List;

/**
 * Created by CHANDAN on 11/27/2017.
 */

public interface RCBContract {

    interface View{
        void showRCBData(List<Items>itemsList);
    }

}
