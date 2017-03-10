package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1314c;

@TargetApi(11)
public class ErrorDialogFragment extends DialogFragment {
    private Dialog f2962a;
    private OnCancelListener f2963b;

    public ErrorDialogFragment() {
        this.f2962a = null;
        this.f2963b = null;
    }

    public static ErrorDialogFragment m4456a(Dialog dialog, OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) C1314c.m4624a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f2962a = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.f2963b = onCancelListener;
        }
        return errorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f2963b != null) {
            this.f2963b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2962a == null) {
            setShowsDialog(false);
        }
        return this.f2962a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
