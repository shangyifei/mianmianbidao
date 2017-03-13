package com.ghost.mianmianwwallpaper.commen;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS;

/**
 * Created by Ghost on 2017/3/9.
 */

public class KeyboardManager {
    private static InputMethodManager get(Context context) {
        return (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
    }
    public static void showKeyboard(Activity activity){
        try {
            InputMethodManager manager = get(activity);
            manager.toggleSoftInput(0, HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            // Nothing
        }
    }
    public static void hideKeyboard(Activity activity){
        try {
            if (activity.getCurrentFocus() != null) {
                InputMethodManager manager = get(activity);
                if (manager.isActive()) {
                    manager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                }
            }
        } catch (Exception e) {
            // Nothing
        }
    }


    public static boolean isActive(Context context, View view) {
        InputMethodManager manager = get(context);
        return manager.isActive(view);
    }

    public static boolean isActive(Context context) {
        InputMethodManager manager = get(context);
        return manager.isActive();
    }
}
