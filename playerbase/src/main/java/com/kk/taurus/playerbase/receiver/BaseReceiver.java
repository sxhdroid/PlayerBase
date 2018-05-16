/*
 * Copyright 2017 jiajunhui<junhui_jia@163.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by Taurus on 2018/3/17.
 */

public abstract class BaseReceiver implements IReceiver {

    private Context mAppContext;
    private OnReceiverEventListener mOnReceiverEventListener;

    private GroupValue mGroupValue;

    public BaseReceiver(Context context){
        this.mAppContext = context;
    }

    public void onReceiverBind(){

    }

    @Override
    public void onReceiverUnBind() {

    }

    @Override
    public final void bindGroupValue(GroupValue groupValue) {
        this.mGroupValue = groupValue;
    }

    protected final GroupValue getGroupValue(){
        return mGroupValue;
    }

    @Override
    public final void bindReceiverEventListener(OnReceiverEventListener onReceiverEventListener) {
        this.mOnReceiverEventListener = onReceiverEventListener;
    }

    protected final void notifyReceiverEvent(int eventCode, Bundle bundle){
        if(mOnReceiverEventListener!=null)
            mOnReceiverEventListener.onReceiverEvent(eventCode, bundle);
    }

    protected Context getContext(){
        return mAppContext;
    }

    //default tag is class simple name
    public Object getTag(){
        return this.getClass().getSimpleName();
    }

}
