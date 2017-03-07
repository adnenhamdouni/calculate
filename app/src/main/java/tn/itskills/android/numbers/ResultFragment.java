package tn.itskills.android.numbers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by adnenhamdouni on 07/03/2017.
 */

public class ResultFragment extends DialogFragment {

    private static String mTermOfUse;
    private static OnResultListener mListener;

    public static ResultFragment newInstance(OnResultListener listener, String termOfUse) {
        mListener = listener;
        mTermOfUse = termOfUse;
        ResultFragment f = new ResultFragment();
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dialogView = layoutInflater.inflate(R.layout.dialog_result_layout, null);
        TextView tv = (TextView) dialogView.findViewById(R.id.result_text);

        tv.setText(mTermOfUse);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mListener.onAccept();
            }
        });
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        mListener.onCancel();
//                    }
//                });

        builder.setView(dialogView);

        return builder.create();
    }

    public interface OnResultListener {

        public void onAccept();

        //public void onCancel();

    }
}

