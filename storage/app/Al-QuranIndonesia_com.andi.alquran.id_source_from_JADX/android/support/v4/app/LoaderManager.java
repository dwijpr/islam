package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p009b.C0227k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        C0227k<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C0227k<D> c0227k, D d);

        void onLoaderReset(C0227k<D> c0227k);
    }

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> C0227k<D> getLoader(int i);

    public boolean hasRunningLoaders() {
        return false;
    }

    public abstract <D> C0227k<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public abstract <D> C0227k<D> restartLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);
}
