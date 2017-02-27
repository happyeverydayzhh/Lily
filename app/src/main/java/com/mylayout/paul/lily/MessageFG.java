package com.mylayout.paul.lily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by paul on 2017/2/27.
 */

public class MessageFG extends Fragment {
    public static MessageFG createInstance() {
        return new MessageFG();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.message_fg, null);
        return v;
    }
}
