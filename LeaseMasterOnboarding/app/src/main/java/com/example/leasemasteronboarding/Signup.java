package com.example.leasemasteronboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setUp();
    }

    private void setUp(){

        TextView terms_condition_label = findViewById(R.id.terms_condition_label);
        String blackText1 = getColoredSpanned("By signing up, you agree to the", "#484848");
        String orangeText = getColoredSpanned(" Terms and conditions", "#2e5eaa");
        String blackText2 = getColoredSpanned(" of Lease Master", "#484848");
        terms_condition_label.setText(Html.fromHtml(blackText1 + orangeText + blackText2));

    }

    private String getColoredSpanned(String text, String color){
        return "<font color=" + color + ">" + text + "</font>";
    }

    public class CustomTypefaceSpan extends TypefaceSpan {

        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {
            super(family);
            newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, newType);
        }

        private void applyCustomTypeFace(Paint paint, Typeface tf) {
            int oldStyle;
            Typeface old = paint.getTypeface();
            if (old == null) {
                oldStyle = 0;
            } else {
                oldStyle = old.getStyle();
            }

            int fake = oldStyle & ~tf.getStyle();
            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }

            paint.setTypeface(tf);
        }
    }
}














