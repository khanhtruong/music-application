package com.example.truongkhanh.ofmusicapp.Fragment.Component_Fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.truongkhanh.ofmusicapp.AsyncTask.AsyncTaskDownload;


public class MyDialogFragment extends DialogFragment {

    String url, name;
//    public static ProgressDialog mProgressDialog;

    public void setAttribute(String url, String name){
        this.url = url;
        this.name = name;
//        mProgressDialog = new ProgressDialog(getContext());
//        mProgressDialog.setMessage("Dowloading");
//        mProgressDialog.setIndeterminate(true);
//        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        mProgressDialog.setCancelable(true);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AsyncTaskDownload asyncTaskDownload = new AsyncTaskDownload(getContext(), name);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Tải bài hát")
                .setMessage("Bạn có muốn tải bài hát này về ?")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        asyncTaskDownload.cancel(true);
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        asyncTaskDownload.execute(url);
                    }
                });
        return builder.create();
    }
}
