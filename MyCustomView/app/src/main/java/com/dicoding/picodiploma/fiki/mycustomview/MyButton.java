package com.dicoding.picodiploma.fiki.mycustomview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.view.Gravity.CENTER;

public class MyButton extends android.support.v7.widget.AppCompatButton {
    private Drawable enableBackGroud, disableBackGround;
    private int txtColor;

    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackground(isEnabled() ? enableBackGroud:disableBackGround);
        setTextColor(txtColor);
        setTextSize(12.f);
        setGravity(CENTER);
        setText(isEnabled() ? "submit" : "Isi Dulu !");
    }

    private void init() {
        txtColor = ContextCompat.getColor(getContext(), android.R.color.background_light);
        enableBackGroud = getResources().getDrawable(R.drawable.bg_button);
        disableBackGround = getResources().getDrawable(R.drawable.bg_button_disable);
    }
}
