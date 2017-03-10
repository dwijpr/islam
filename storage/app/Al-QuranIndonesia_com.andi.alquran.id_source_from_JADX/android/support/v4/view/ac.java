package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

@TargetApi(14)
class ac {

    /* renamed from: android.support.v4.view.ac.a */
    private static class C0434a extends SingleLineTransformationMethod {
        private Locale f871a;

        public C0434a(Context context) {
            this.f871a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.f871a) : null;
        }
    }

    public static void m1633a(TextView textView) {
        textView.setTransformationMethod(new C0434a(textView.getContext()));
    }
}
