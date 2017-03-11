package android.support.v4.app;

import android.annotation.TargetApi;
import android.text.Html;

@TargetApi(16)
class ShareCompatJB {
    ShareCompatJB() {
    }

    public static String escapeHtml(CharSequence charSequence) {
        return Html.escapeHtml(charSequence);
    }
}