package com.prasad.mvc.helpers;

import android.content.Context;
import android.widget.Toast;

import com.prasad.mvc.R;
import com.prasad.mvc.widgets.TransparentProgressDialog;

/**
 * Created by prasad on 9/22/18.
 */

public class Utils {

    static TransparentProgressDialog dialog;

    public static void showProgress(Context context) {
        dialog = new TransparentProgressDialog(context, R.style.MyProgressTheme);
        dialog.show();

    }

    public static void hideProgress() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public static void showToastMsg(Context context,String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

    }

}
