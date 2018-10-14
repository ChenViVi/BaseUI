package com.iwritebug.baseui;

import android.app.Activity;
import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vivi on 2016/11/3.
 */

public class BaseApplication extends Application{

    private List<Activity> activities = new LinkedList<Activity>();
    private boolean UMEnable;

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    protected void setUM(String key, String channel){
        UMEnable = true;
        UMConfigure.init(this, key, channel, UMConfigure.DEVICE_TYPE_PHONE, null);
    }

    public boolean isUMEnable() {
        return UMEnable;
    }

    public void exitAllActivities(){
        for (Activity activity:activities) {
            if (activity != null)
                activity.finish();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}
