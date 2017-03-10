package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public static class zza {
        private int f2751a;

        public zza zzak(int i) {
            this.f2751a = i;
            return this;
        }

        public Bundle zzlL() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f2751a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
