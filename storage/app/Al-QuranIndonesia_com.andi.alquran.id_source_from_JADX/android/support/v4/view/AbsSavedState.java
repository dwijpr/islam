package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p007e.C0043e;
import android.support.v4.p007e.C0267d;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR;
    public static final AbsSavedState EMPTY_STATE;
    private final Parcelable mSuperState;

    /* renamed from: android.support.v4.view.AbsSavedState.1 */
    static class C03601 extends AbsSavedState {
        C03601() {
            super();
        }
    }

    /* renamed from: android.support.v4.view.AbsSavedState.2 */
    static class C03612 implements C0043e<AbsSavedState> {
        C03612() {
        }

        public AbsSavedState m1275a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] m1276a(int i) {
            return new AbsSavedState[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return m1275a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1276a(i);
        }
    }

    static {
        EMPTY_STATE = new C03601();
        CREATOR = C0267d.m910a(new C03612());
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = EMPTY_STATE;
        }
        this.mSuperState = readParcelable;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == EMPTY_STATE) {
            parcelable = null;
        }
        this.mSuperState = parcelable;
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
