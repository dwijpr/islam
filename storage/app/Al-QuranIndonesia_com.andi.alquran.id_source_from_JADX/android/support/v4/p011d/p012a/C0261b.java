package android.support.v4.p011d.p012a;

import android.support.v4.view.C0491d;
import android.support.v4.view.C0527q.C0526e;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.d.a.b */
public interface C0261b extends MenuItem {
    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    C0491d getSupportActionProvider();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);

    C0261b setSupportActionProvider(C0491d c0491d);

    C0261b setSupportOnActionExpandListener(C0526e c0526e);
}
