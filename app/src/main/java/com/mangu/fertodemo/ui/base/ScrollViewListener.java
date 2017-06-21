package com.mangu.fertodemo.ui.base;


import com.mangu.fertodemo.ui.common.ScrollViewExt;

public interface ScrollViewListener {
    void onScrollChanged(ScrollViewExt scrollView,
                         int x, int y, int oldx, int oldy);
}