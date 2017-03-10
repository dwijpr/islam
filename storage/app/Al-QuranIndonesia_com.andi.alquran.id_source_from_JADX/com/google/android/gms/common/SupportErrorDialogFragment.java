package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.C1314c;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog f2964a;
    private OnCancelListener f2965b;

    public SupportErrorDialogFragment() {
        this.f2964a = null;
        this.f2965b = null;
    }

    public static SupportErrorDialogFragment m4457a(Dialog dialog, OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) C1314c.m4624a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f2964a = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f2965b = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f2965b != null) {
            this.f2965b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2964a == null) {
            setShowsDialog(false);
        }
        return this.f2964a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
