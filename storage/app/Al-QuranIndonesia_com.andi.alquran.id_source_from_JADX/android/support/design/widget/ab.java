package android.support.design.widget;

import android.widget.ImageButton;

class ab extends ImageButton {
    private int f263a;

    final void m354a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f263a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f263a;
    }

    public void setVisibility(int i) {
        m354a(i, true);
    }
}
