package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.g */
class C0565g extends Filter {
    C0563a f1095a;

    /* renamed from: android.support.v4.widget.g.a */
    interface C0563a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    C0565g(C0563a c0563a) {
        this.f1095a = c0563a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1095a.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f1095a.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.f1095a.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f1095a.changeCursor((Cursor) filterResults.values);
        }
    }
}
