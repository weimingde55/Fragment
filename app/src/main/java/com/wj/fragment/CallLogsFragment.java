package com.wj.fragment;/**
 * Created by wangjiang on 2016/3/12.
 */


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wj.fragment.calllogs.AllFragment;
import com.wj.fragment.calllogs.SingleFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * User: WangJiang(wangjiang7747@gmail.com)
 * Date: 2016-03-12
 * Time: 11:28
 */
public class CallLogsFragment extends Fragment {
    private static final String TAG = "CallLogsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calllogs, null);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.child_container);
        viewPager.setAdapter(new PagerAdater(((MainActivity) getActivity()).getSupportFragmentManager()));
        return view;
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    public class PagerAdater extends FragmentPagerAdapter {

        private List<Fragment> mFragments = new ArrayList<>(2);

        public PagerAdater(FragmentManager fm) {
            super(fm);
            mFragments.add(new AllFragment());
            mFragments.add(new SingleFragment());
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
