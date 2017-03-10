package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C1385k;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@op
public final class zzms extends zza {
    public static final Creator<zzms> CREATOR;
    final int f6617a;
    ParcelFileDescriptor f6618b;
    private Parcelable f6619c;
    private boolean f6620d;

    /* renamed from: com.google.android.gms.internal.zzms.1 */
    class C20831 implements Runnable {
        final /* synthetic */ OutputStream f6615a;
        final /* synthetic */ byte[] f6616b;

        C20831(zzms com_google_android_gms_internal_zzms, OutputStream outputStream, byte[] bArr) {
            this.f6615a = outputStream;
            this.f6616b = bArr;
        }

        public void run() {
            Closeable dataOutputStream;
            Throwable e;
            try {
                dataOutputStream = new DataOutputStream(this.f6615a);
                try {
                    dataOutputStream.writeInt(this.f6616b.length);
                    dataOutputStream.write(this.f6616b);
                    C1385k.m4955a(dataOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        sg.m8445b("Error transporting the ad response", e);
                        zzv.zzcN().m8399a(e, "LargeParcelTeleporter.pipeData.1");
                        if (dataOutputStream != null) {
                            C1385k.m4955a(this.f6615a);
                        } else {
                            C1385k.m4955a(dataOutputStream);
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (dataOutputStream != null) {
                            C1385k.m4955a(this.f6615a);
                        } else {
                            C1385k.m4955a(dataOutputStream);
                        }
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                dataOutputStream = null;
                sg.m8445b("Error transporting the ad response", e);
                zzv.zzcN().m8399a(e, "LargeParcelTeleporter.pipeData.1");
                if (dataOutputStream != null) {
                    C1385k.m4955a(dataOutputStream);
                } else {
                    C1385k.m4955a(this.f6615a);
                }
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                    C1385k.m4955a(dataOutputStream);
                } else {
                    C1385k.m4955a(this.f6615a);
                }
                throw e;
            }
        }
    }

    static {
        CREATOR = new pc();
    }

    zzms(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f6617a = i;
        this.f6618b = parcelFileDescriptor;
        this.f6619c = null;
        this.f6620d = true;
    }

    public zzms(SafeParcelable safeParcelable) {
        this.f6617a = 1;
        this.f6618b = null;
        this.f6619c = safeParcelable;
        this.f6620d = false;
    }

    protected <T> ParcelFileDescriptor m9776a(byte[] bArr) {
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new C20831(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            sg.m8445b("Error transporting the ad response", e);
            zzv.zzcN().m8399a(e, "LargeParcelTeleporter.pipeData.2");
            C1385k.m4955a(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public <T extends SafeParcelable> T m9777a(Creator<T> creator) {
        if (this.f6620d) {
            if (this.f6618b == null) {
                sg.m8446c("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.f6618b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                C1385k.m4955a(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f6619c = (SafeParcelable) creator.createFromParcel(obtain);
                    this.f6620d = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                C1385k.m4955a(dataInputStream);
            }
        }
        return (SafeParcelable) this.f6619c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f6618b == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f6619c.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f6618b = m9776a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        pc.m8070a(this, parcel, i);
    }
}
