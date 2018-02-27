package org.bubulescu.horizontalslider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;


public class HorizontalSlider extends ProgressBar {

    private List<OnProgressChangeListener> onProgressChangeListeners = new ArrayList<>();

    public HorizontalSlider(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.progressBarStyleHorizontal);
    }

    public void setOnProgressChangeListeners(OnProgressChangeListener listener) {
        this.onProgressChangeListeners.add(listener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

            float position = event.getX();
            int progress = Math.round(getMax() * position / getWidth());

            if (progress < 0) progress = 0;
            else if (progress > 100) progress = 100;

            setProgress(progress);

            notifyListeners(progress);
        }

        return true;
    }

    private void notifyListeners(int progress) {

        for (OnProgressChangeListener listener : onProgressChangeListeners) {
            listener.onProgressChange(this, progress);
        }
    }
}
