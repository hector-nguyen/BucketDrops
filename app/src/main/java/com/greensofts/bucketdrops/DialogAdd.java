package com.greensofts.bucketdrops;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.greensofts.bucketdrops.beans.Drop;
import com.greensofts.bucketdrops.widgets.BucketPickerView;

import io.realm.Realm;

/**
 * Created by Steven Nguyen on 11/28/2016.
 */

public class DialogAdd extends DialogFragment {

    private ImageButton mBtnClose;
    private EditText mInputWhat;
    private BucketPickerView mInputWhen;
    private Button mBtnAdd;

    private View.OnClickListener mBtnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.btn_add_it:
                    addAction();
                    break;
            }
            dismiss();
        }
    };

    private void addAction() {
        // Get the value of 'to-do'
        String what = mInputWhat.getText().toString();
        long now = System.currentTimeMillis();

        Realm realm = Realm.getDefaultInstance();
        Drop drop = new Drop(what, now, mInputWhen.getTime(), false);
        realm.beginTransaction();
        realm.copyToRealm(drop);
        realm.commitTransaction();
        realm.close();
    }

    public DialogAdd() {
        // Empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_add, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnClose = (ImageButton) view.findViewById(R.id.btn_close);
        mInputWhat = (EditText) view.findViewById(R.id.et_drop);
        mInputWhen = (BucketPickerView) view.findViewById(R.id.bpv_date);
        mBtnAdd = (Button) view.findViewById(R.id.btn_add_it);

        mBtnClose.setOnClickListener(mBtnClickListener);
        mBtnAdd.setOnClickListener(mBtnClickListener);

        AppBucketDrops.setRalewayRegular(this.getActivity(), mInputWhat);
    }
}
