package android.support.v4.p007e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.e.a */
public final class C0263a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m907a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0264b.m908a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
