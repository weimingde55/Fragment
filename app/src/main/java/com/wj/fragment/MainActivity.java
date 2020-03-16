package com.wj.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


/**
 *
 */
public class MainActivity extends FragmentActivity {


    private final int CALLLOGS = 0;
    private final int CONTACTS = 1;
    private final int DIAL = 2;
    private int mLastIndex = CONTACTS;
    private CallLogsFragment mCallLogsFragment;
    private ContactsFragment mContactsFragment;
    private DailFragment mDailFragment;

    private List<Fragment> mFragments = new ArrayList<>(3);
    private List<TextView> mViews = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initFragments();
        showFragment(CALLLOGS);
    }

    /**
     * 初始化View
     */
    private void initViews() {
        mViews.add((TextView) findViewById(R.id.calllogs));
        mViews.add((TextView) findViewById(R.id.contacts));
        mViews.add((TextView) findViewById(R.id.dial));
    }

    /**
     * 初始化Fragments
     */
    private void initFragments() {
        mCallLogsFragment = new CallLogsFragment();
        mContactsFragment = new ContactsFragment();
        mDailFragment = new DailFragment();
        mFragments.add(mCallLogsFragment);
        mFragments.add(mContactsFragment);
        mFragments.add(mDailFragment);
    }

    /**
     * 显示当前Fragment
     *
     * @param index 当前的位置
     */
    private void showFragment(int index) {
        TextView lastTextView = mViews.get(mLastIndex);
        if (lastTextView != null && lastTextView.isSelected()) {
            lastTextView.setSelected(false);
        }
        TextView currentTextView = mViews.get(index);
        if (currentTextView != null && !currentTextView.isSelected()) {
            currentTextView.setSelected(true);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(index);
        if (currentFragment != null) {
            if (!currentFragment.isAdded()) {
                transaction.add(R.id.container, currentFragment);
            } else {
                currentFragment.onResume();
            }
        } else {
            return;
        }
        transaction.show(currentFragment);
        Fragment lastFragment = mFragments.get(mLastIndex);
        if (lastFragment != null) {
            if (lastFragment.isAdded() && lastFragment.isVisible()) {
                lastFragment.onPause();
                transaction.hide(lastFragment);
            }
        }
        transaction.commitAllowingStateLoss();
        mLastIndex = index;
    }

    /**
     * 处理底部点击事件
     *
     * @param v
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calllogs: {
                showFragment(CALLLOGS);
                break;
            }
            case R.id.contacts: {
                showFragment(CONTACTS);
                break;
            }
            case R.id.dial: {
                showFragment(DIAL);
                break;
            }
            default:
                break;
        }
    }

}
