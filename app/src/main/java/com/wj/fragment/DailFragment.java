package com.wj.fragment;/**
 * Created by wangjiang on 2016/3/12.
 */


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * User: WangJiang(wangjiang7747@gmail.com)
 * Date: 2016-03-12
 * Time: 11:28
 */
public class DailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dial, null);
        return view;
    }
}
