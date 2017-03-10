package android.support.v4.app;

import android.app.Activity;
import android.support.v4.p014g.C0297j;

public class SupportActivity extends Activity {
    private C0297j<Class<? extends ExtraData>, ExtraData> mExtraDataMap;

    public static class ExtraData {
    }

    public SupportActivity() {
        this.mExtraDataMap = new C0297j();
    }

    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (ExtraData) this.mExtraDataMap.get(cls);
    }

    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put(extraData.getClass(), extraData);
    }
}
