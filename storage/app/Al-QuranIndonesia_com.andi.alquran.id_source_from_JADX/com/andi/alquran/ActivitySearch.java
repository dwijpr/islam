package com.andi.alquran;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.p011d.p012a.C0261b;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnCloseListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.andi.alquran.p024a.C0862a;
import com.andi.alquran.p024a.C0872e;
import com.andi.alquran.p026c.C0889e;
import com.andi.alquran.p030h.C0917a;
import com.andi.alquran.p030h.C0918b;
import java.util.ArrayList;

public class ActivitySearch extends ActivityBase implements OnCloseListener, OnQueryTextListener {
    private SearchView f1398a;
    private C0872e f1399b;
    private ExpandableListView f1400c;
    private TextView f1401d;
    private ArrayList<C0917a> f1402e;
    private App f1403f;
    private RelativeLayout f1404g;
    private ListView f1405h;
    private C0889e f1406i;
    private ProgressDialog f1407j;
    private ProgressDialog f1408k;
    private ImageView f1409l;
    private boolean f1410m;

    /* renamed from: com.andi.alquran.ActivitySearch.1 */
    class C08081 implements OnItemClickListener {
        final /* synthetic */ ActivitySearch f1386a;

        C08081(ActivitySearch activitySearch) {
            this.f1386a = activitySearch;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f1386a.f1398a.setQuery(((TextView) view.findViewById(C0861R.id.history_name)).getText().toString(), true);
            this.f1386a.f1398a.setIconified(false);
        }
    }

    /* renamed from: com.andi.alquran.ActivitySearch.2 */
    class C08092 implements OnClickListener {
        final /* synthetic */ ActivitySearch f1387a;

        C08092(ActivitySearch activitySearch) {
            this.f1387a = activitySearch;
        }

        public void onClick(View view) {
            this.f1387a.m2801h();
        }
    }

    /* renamed from: com.andi.alquran.ActivitySearch.3 */
    class C08103 implements OnChildClickListener {
        final /* synthetic */ ActivitySearch f1388a;

        C08103(ActivitySearch activitySearch) {
            this.f1388a = activitySearch;
        }

        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            ArrayList c = ((C0917a) this.f1388a.f1402e.get(i)).m3201c();
            this.f1388a.m2789a(Integer.parseInt(((C0918b) c.get(i2)).m3202a()), Integer.parseInt(((C0918b) c.get(i2)).m3204b()));
            return false;
        }
    }

    /* renamed from: com.andi.alquran.ActivitySearch.4 */
    class C08114 implements DialogInterface.OnClickListener {
        final /* synthetic */ Intent f1389a;
        final /* synthetic */ int f1390b;
        final /* synthetic */ int f1391c;
        final /* synthetic */ ActivitySearch f1392d;

        C08114(ActivitySearch activitySearch, Intent intent, int i, int i2) {
            this.f1392d = activitySearch;
            this.f1389a = intent;
            this.f1390b = i;
            this.f1391c = i2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                this.f1389a.putExtra("PAGING", 1);
                this.f1389a.putExtra("SURA", this.f1390b);
                this.f1389a.putExtra("AYA", this.f1391c);
                this.f1389a.putExtra("OPENFROMJUZ", false);
                this.f1392d.startActivity(this.f1389a);
            } else if (i == 1) {
                this.f1389a.putExtra("PAGING", 2);
                this.f1389a.putExtra("SURA", this.f1390b);
                this.f1389a.putExtra("AYA", this.f1391c);
                this.f1389a.putExtra("OPENFROMJUZ", false);
                this.f1392d.startActivity(this.f1389a);
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivitySearch.5 */
    class C08125 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivitySearch f1393a;

        C08125(ActivitySearch activitySearch) {
            this.f1393a = activitySearch;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            new syncClearingHistory(null).execute(new String[0]);
        }
    }

    /* renamed from: com.andi.alquran.ActivitySearch.6 */
    class C08136 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivitySearch f1394a;

        C08136(ActivitySearch activitySearch) {
            this.f1394a = activitySearch;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    private class syncClearingHistory extends AsyncTask<String, String, String> {
        final /* synthetic */ ActivitySearch f1395a;

        private syncClearingHistory(ActivitySearch activitySearch) {
            this.f1395a = activitySearch;
        }

        protected String m2782a(String... strArr) {
            try {
                this.f1395a.f1406i.m3083a();
            } catch (Exception e) {
                e.getMessage();
            }
            return BuildConfig.VERSION_NAME;
        }

        protected void m2783a(String str) {
            if (!(this.f1395a.isFinishing() || this.f1395a.f1408k == null || !this.f1395a.f1408k.isShowing())) {
                this.f1395a.f1408k.dismiss();
            }
            App.m2871b(this.f1395a.getString(C0861R.string.history_successfully));
            this.f1395a.m2803i();
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2782a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2783a((String) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f1395a.f1408k = new ProgressDialog(this.f1395a);
            this.f1395a.f1408k.setMessage(this.f1395a.getString(C0861R.string.history_loading));
            this.f1395a.f1408k.setIndeterminate(false);
            this.f1395a.f1408k.setCanceledOnTouchOutside(false);
            this.f1395a.f1408k.setCancelable(false);
            this.f1395a.f1408k.show();
        }
    }

    private class syncProccessQuery extends AsyncTask<String, String, String> {
        final /* synthetic */ ActivitySearch f1396a;
        private boolean f1397b;

        private syncProccessQuery(ActivitySearch activitySearch) {
            this.f1396a = activitySearch;
            this.f1397b = false;
        }

        protected String m2784a(String... strArr) {
            String str = strArr[0];
            int i = 1;
            while (i < this.f1396a.f1403f.f1453e.m3070a()) {
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList a = this.f1396a.f1403f.f1450b.f1674m == 2 ? this.f1396a.f1403f.f1457i.m3078a(str, i) : this.f1396a.f1403f.f1456h.m3078a(str, i);
                    if (a.size() > 0) {
                        for (int i2 = 0; i2 < a.size(); i2++) {
                            arrayList.add(new C0918b(((C0918b) a.get(i2)).m3202a(), ((C0918b) a.get(i2)).m3204b(), ((C0918b) a.get(i2)).m3206c().trim()));
                            this.f1397b = true;
                        }
                        this.f1396a.f1402e.add(new C0917a(App.m2863a(i), this.f1396a.getString(C0861R.string.search_count_aya, new Object[]{Integer.valueOf(a.size())}), arrayList));
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return str;
        }

        protected void m2785a(String str) {
            if (!(this.f1396a.isFinishing() || this.f1396a.f1407j == null || !this.f1396a.f1407j.isShowing())) {
                this.f1396a.f1407j.dismiss();
            }
            if (this.f1397b) {
                this.f1396a.f1409l.setVisibility(8);
                this.f1396a.f1401d.setVisibility(8);
                this.f1396a.f1404g.setVisibility(8);
                this.f1396a.f1405h.setVisibility(8);
                this.f1396a.f1400c.setVisibility(0);
                this.f1396a.f1399b = new C0872e(this.f1396a, this.f1396a.f1402e, str, this.f1396a.f1410m);
                this.f1396a.f1400c.setAdapter(this.f1396a.f1399b);
                this.f1396a.f1399b.notifyDataSetChanged();
                this.f1396a.m2799g();
                try {
                    this.f1396a.f1406i.m3084a(str);
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
            }
            this.f1396a.f1401d.setText(this.f1396a.getString(C0861R.string.search_empty_data, new Object[]{str}));
            this.f1396a.f1404g.setVisibility(0);
            this.f1396a.f1405h.setVisibility(0);
            this.f1396a.f1400c.setVisibility(8);
            this.f1396a.f1409l.setVisibility(0);
            this.f1396a.f1401d.setVisibility(0);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2784a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2785a((String) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f1396a.f1407j = new ProgressDialog(this.f1396a);
            this.f1396a.f1407j.setMessage(this.f1396a.getString(C0861R.string.search_progress));
            this.f1396a.f1407j.setIndeterminate(false);
            this.f1396a.f1407j.setCanceledOnTouchOutside(false);
            this.f1396a.f1407j.setCancelable(true);
            this.f1396a.f1407j.show();
            this.f1396a.f1402e.clear();
        }
    }

    public ActivitySearch() {
        this.f1402e = new ArrayList();
    }

    private void m2789a(int i, int i2) {
        String[] strArr = new String[]{getString(C0861R.string.open_as_sura), getString(C0861R.string.open_as_juz)};
        int i3 = this.f1410m ? C0861R.drawable.ic_black_action_view : C0861R.drawable.ic_white_action_view;
        new Builder(this).setTitle(this.f1403f.m2902a(i, i2, App.f1448m.f1453e.m3071a(2, i, i2))).setAdapter(new C0862a(this, strArr, new Integer[]{Integer.valueOf(i3), Integer.valueOf(i3)}), new C08114(this, new Intent(this, ActivityQuran.class), i, i2)).show();
    }

    private void m2797f() {
        if (this.f1400c.isShown()) {
            m2803i();
        } else {
            finish();
        }
    }

    private void m2799g() {
        if (this.f1399b.getGroupCount() > 0) {
            this.f1400c.expandGroup(0);
        }
    }

    private void m2801h() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(C0861R.string.history_dialog));
        builder.setPositiveButton(getString(C0861R.string.yes), new C08125(this));
        builder.setNegativeButton(getString(C0861R.string.cancel), new C08136(this));
        builder.show();
    }

    private void m2803i() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(65536);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    public void onBackPressed() {
        m2797f();
    }

    public boolean onClose() {
        this.f1402e.clear();
        this.f1399b.notifyDataSetChanged();
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        App.f1448m.f1450b.m3067a(this);
        this.f1403f = (App) getApplication();
        if (this.f1403f.f1450b.f1676o == 1) {
            setContentView((int) C0861R.layout.activity_search);
            this.f1410m = true;
        } else {
            setTheme(C0861R.style.AndiThemeNoHeaderDark);
            setContentView((int) C0861R.layout.dark_activity_search);
            this.f1410m = false;
        }
        setSupportActionBar((Toolbar) findViewById(C0861R.id.toolbar));
        this.f1409l = (ImageView) findViewById(C0861R.id.imgNotFound);
        this.f1401d = (TextView) findViewById(C0861R.id.emptyElement);
        this.f1404g = (RelativeLayout) findViewById(C0861R.id.historyContent);
        this.f1405h = (ListView) findViewById(C0861R.id.listHistory);
        this.f1405h.setOnItemClickListener(new C08081(this));
        this.f1406i = new C0889e(this);
        ArrayList b = this.f1406i.m3085b();
        this.f1405h.setAdapter(new SimpleAdapter(this, b, this.f1410m ? C0861R.layout.search_row_history : C0861R.layout.dark_search_row_history, new String[]{"name"}, new int[]{C0861R.id.history_name}));
        if (b.size() == 0) {
            this.f1404g.setVisibility(8);
            this.f1401d.setVisibility(0);
        } else {
            this.f1404g.setVisibility(0);
            if (b.size() > 25) {
                this.f1405h.setFastScrollEnabled(false);
            } else {
                this.f1405h.setFastScrollEnabled(true);
            }
            this.f1401d.setVisibility(8);
        }
        ((ImageButton) findViewById(C0861R.id.buttonClearHistory)).setOnClickListener(new C08092(this));
        this.f1400c = (ExpandableListView) findViewById(C0861R.id.expandableSearch);
        this.f1400c.setFastScrollEnabled(true);
        this.f1399b = new C0872e(this, this.f1402e, BuildConfig.VERSION_NAME, this.f1410m);
        this.f1400c.setAdapter(this.f1399b);
        this.f1400c.setOnChildClickListener(new C08103(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0861R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        this.f1398a = (SearchView) ((C0261b) menu.findItem(C0861R.id.action_search)).getActionView();
        this.f1398a.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        this.f1398a.setOnQueryTextListener(this);
        this.f1398a.setOnCloseListener(this);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m2797f();
            return true;
        } else if (menuItem.getItemId() != C0861R.id.action_search) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            this.f1398a.setIconified(false);
            return true;
        }
    }

    public boolean onQueryTextChange(String str) {
        return false;
    }

    public boolean onQueryTextSubmit(String str) {
        new syncProccessQuery().execute(new String[]{str});
        return false;
    }
}
