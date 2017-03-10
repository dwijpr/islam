package com.google.android.gms.internal;

import android.text.TextUtils;

@op
public class ij {
    public ih m6723a(ig igVar) {
        if (igVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!igVar.m6706a()) {
            rm.m8450a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (igVar.m6708c() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(igVar.m6709d())) {
            return new ih(igVar.m6708c(), igVar.m6709d(), igVar.m6707b(), igVar.m6710e());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
