package com.prasad.mvc.widgets;

/**
 * Created by prasad on 9/22/18.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.prasad.mvc.R;

public class TransparentProgressDialog extends Dialog

{
    private ImageView iv;
    View view;

    public TransparentProgressDialog(Context paramContext, int paramInt)
    {
        super(paramContext, paramInt);
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.gravity = 1;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setAttributes(localLayoutParams);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setTitle(null);
        setCancelable(true);
        setOnCancelListener(null);
        setCanceledOnTouchOutside(false);
        view = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.widget_loading, null);
//        this.iv = ((ImageView)view.findViewById(R.id.image_loading));
        addContentView(view, new LinearLayout.LayoutParams(-1, -2));

    }

    public void show()
    {
        super.show();
//        RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
//        localRotateAnimation.setInterpolator(new LinearInterpolator());
//        localRotateAnimation.setRepeatCount(-1);
//        localRotateAnimation.setDuration(1000L);
//        this.iv.setAnimation(localRotateAnimation);
//        this.iv.startAnimation(localRotateAnimation);
    }
}
