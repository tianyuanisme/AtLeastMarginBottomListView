package com.ayu.customviews;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ListView;

public class AtLeastMarginBottomListView extends ListView {
    private float atLeastMarginBottom;

    public AtLeastMarginBottomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, com.ayu.customviews.R.styleable.AtLeastMarginBottomListView);
        atLeastMarginBottom = typedArray.getDimension(com.ayu.customviews.R.styleable.AtLeastMarginBottomListView_atLeastMarginBottom, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int listViewHeight = (int) (rect.height() - atLeastMarginBottom);
        if (listViewHeight > -1) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(listViewHeight,
                    MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}