package com.mylayout.paul.lily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paul on 2017/2/27.
 */

public class WorkFG extends Fragment {
    public static WorkFG createInstance() {
        return new WorkFG();
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.work_fg, null);
        return v;
    }
}
