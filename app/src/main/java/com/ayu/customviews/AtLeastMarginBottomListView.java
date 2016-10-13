package com.ayu.customviews;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListView;

public class AtLeastMarginBottomListView extends ListView {
    private float atLeastMarginBottom;
    private float atLeastMarginTop;
    private int parentHeight;

    public AtLeastMarginBottomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, com.ayu.customviews.R.styleable.AtLeastMarginBottomListView);
        atLeastMarginBottom = typedArray.getDimension(com.ayu.customviews.R.styleable.AtLeastMarginBottomListView_atLeastMarginBottom, 0);
        atLeastMarginTop = typedArray.getDimension(com.ayu.customviews.R.styleable.AtLeastMarginBottomListView_atLeastMarginTop, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentHeight = ((ViewGroup) this.getParent()).getMeasuredHeight();
        int listViewHeight = (int) (parentHeight - atLeastMarginBottom - atLeastMarginTop);
        if (listViewHeight > -1) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(listViewHeight,
                    MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}