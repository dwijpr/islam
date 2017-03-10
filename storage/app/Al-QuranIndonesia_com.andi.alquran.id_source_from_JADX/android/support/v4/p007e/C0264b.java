package android.support.v4.p007e;

import android.annotation.TargetApi;
import android.os.AsyncTask;

@TargetApi(11)
/* renamed from: android.support.v4.e.b */
class C0264b {
    static <Params, Progress, Result> void m908a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
