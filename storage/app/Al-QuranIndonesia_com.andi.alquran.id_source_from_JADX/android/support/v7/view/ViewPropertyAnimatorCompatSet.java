package android.support.v7.view;

import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ay> mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    bc mListener;
    private final bd mProxyListener;

    /* renamed from: android.support.v7.view.ViewPropertyAnimatorCompatSet.1 */
    class C06371 extends bd {
        private int mProxyEndCount;
        private boolean mProxyStarted;

        C06371() {
            this.mProxyStarted = false;
            this.mProxyEndCount = 0;
        }

        public void onAnimationEnd(View view) {
            int i = this.mProxyEndCount + 1;
            this.mProxyEndCount = i;
            if (i == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                if (ViewPropertyAnimatorCompatSet.this.mListener != null) {
                    ViewPropertyAnimatorCompatSet.this.mListener.onAnimationEnd(null);
                }
                onEnd();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.mProxyStarted) {
                this.mProxyStarted = true;
                if (ViewPropertyAnimatorCompatSet.this.mListener != null) {
                    ViewPropertyAnimatorCompatSet.this.mListener.onAnimationStart(null);
                }
            }
        }

        void onEnd() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }
    }

    public ViewPropertyAnimatorCompatSet() {
        this.mDuration = -1;
        this.mProxyListener = new C06371();
        this.mAnimators = new ArrayList();
    }

    public void cancel() {
        if (this.mIsStarted) {
            Iterator it = this.mAnimators.iterator();
            while (it.hasNext()) {
                ((ay) it.next()).m2068b();
            }
            this.mIsStarted = false;
        }
    }

    void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ay ayVar) {
        if (!this.mIsStarted) {
            this.mAnimators.add(ayVar);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ay ayVar, ay ayVar2) {
        this.mAnimators.add(ayVar);
        ayVar2.m2067b(ayVar.m2060a());
        this.mAnimators.add(ayVar2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.mIsStarted) {
            this.mDuration = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(bc bcVar) {
        if (!this.mIsStarted) {
            this.mListener = bcVar;
        }
        return this;
    }

    public void start() {
        if (!this.mIsStarted) {
            Iterator it = this.mAnimators.iterator();
            while (it.hasNext()) {
                ay ayVar = (ay) it.next();
                if (this.mDuration >= 0) {
                    ayVar.m2062a(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    ayVar.m2065a(this.mInterpolator);
                }
                if (this.mListener != null) {
                    ayVar.m2063a(this.mProxyListener);
                }
                ayVar.m2070c();
            }
            this.mIsStarted = true;
        }
    }
}
