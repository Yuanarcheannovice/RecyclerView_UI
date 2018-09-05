package com.xz.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * @author Administrator
 * @date 2018/8/30
 * 空白的fragment
 */

public class CommonlyFragment extends Fragment {
    static final String FRAGMENT_TAG = "fragment_tag";

    public static CommonlyFragment newInstance(String tag) {

        Bundle args = new Bundle();

        args.putString(FRAGMENT_TAG, tag);
        CommonlyFragment fragment = new CommonlyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_commonly, container, false);
        final TextView tv = contentView.findViewById(R.id.fc_tv);
        tv.post(new Runnable() {
            @Override
            public void run() {
                String fragmentTag = getArguments().getString(FRAGMENT_TAG);
                if (!TextUtils.isEmpty(fragmentTag)) {
                    tv.setText(fragmentTag);
                }
            }
        });
        return contentView;
    }


}
