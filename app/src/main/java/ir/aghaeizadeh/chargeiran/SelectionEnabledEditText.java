package ir.aghaeizadeh.chargeiran;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class SelectionEnabledEditText extends EditText {
    public SelectionEnabledEditText(Context context) {
        super(context);
    }

    public SelectionEnabledEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionEnabledEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);

        if(onSelectionChangeListener != null)
            onSelectionChangeListener.onSelectionChanged(selStart, selEnd);
    }

    public static interface OnSelectionChangeListener{
        public void onSelectionChanged(int selStart, int selEnd);
    }

    private  OnSelectionChangeListener onSelectionChangeListener;

    public void setOnSelectionChangeListener(OnSelectionChangeListener onSelectionChangeListener) {
        this.onSelectionChangeListener = onSelectionChangeListener;
    }
}