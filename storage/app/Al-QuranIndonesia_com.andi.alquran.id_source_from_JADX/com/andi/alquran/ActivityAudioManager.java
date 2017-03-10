package com.andi.alquran;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.andi.alquran.p022f.C0733b;
import com.andi.alquran.p022f.C0734e;
import com.andi.alquran.p024a.C0865b;
import com.andi.alquran.p025b.C0879b;
import com.andi.alquran.p028g.p029a.C0910d;
import com.andi.alquran.p028g.p029a.C0911a;
import com.andi.alquran.p028g.p029a.C0912b;
import com.andi.alquran.p028g.p029a.C0913c;
import com.andi.alquran.p028g.p029a.C0914e;
import com.andi.alquran.p031i.C0921b;
import com.andi.alquran.p032j.C0939a;
import com.andi.alquran.services.MultiDownloadService;
import com.andi.alquran.services.MultiDownloadService.C0954a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActivityAudioManager extends AppCompatActivity implements C0733b, C0734e {
    public BroadcastReceiver f1149a;
    private C0865b f1150b;
    private ListView f1151c;
    private ImageButton f1152d;
    private ImageButton f1153e;
    private CheckBox f1154f;
    private App f1155g;
    private Context f1156h;
    private ArrayList<Integer> f1157i;
    private MultiDownloadService f1158j;
    private boolean f1159k;
    private long f1160l;
    private ServiceConnection f1161m;

    /* renamed from: com.andi.alquran.ActivityAudioManager.1 */
    class C07251 implements OnClickListener {
        final /* synthetic */ ActivityAudioManager f1135a;

        C07251(ActivityAudioManager activityAudioManager) {
            this.f1135a = activityAudioManager;
        }

        public void onClick(View view) {
            this.f1135a.finish();
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.2 */
    class C07262 implements OnItemClickListener {
        final /* synthetic */ ActivityAudioManager f1136a;

        C07262(ActivityAudioManager activityAudioManager) {
            this.f1136a = activityAudioManager;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f1136a.f1150b.m3015a(i);
            this.f1136a.m2571a();
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.3 */
    class C07273 implements OnClickListener {
        final /* synthetic */ ActivityAudioManager f1137a;

        C07273(ActivityAudioManager activityAudioManager) {
            this.f1137a = activityAudioManager;
        }

        public void onClick(View view) {
            int i = 1;
            int count = this.f1137a.f1150b.getCount();
            if (this.f1137a.m2575c() < count) {
                for (int i2 = 1; i2 <= count; i2++) {
                    this.f1137a.f1150b.m3018b(i2 - 1);
                }
                this.f1137a.f1154f.setChecked(true);
                return;
            }
            if (this.f1137a.f1159k && this.f1137a.f1158j != null && this.f1137a.f1158j.m3341c()) {
                App.m2865a(this.f1137a.getString(C0861R.string.msg_download_multi_cancell_all));
            }
            while (i <= count) {
                this.f1137a.f1150b.m3020c(i - 1);
                i++;
            }
            this.f1137a.f1154f.setChecked(false);
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.4 */
    class C07284 implements OnClickListener {
        final /* synthetic */ ActivityAudioManager f1138a;

        C07284(ActivityAudioManager activityAudioManager) {
            this.f1138a = activityAudioManager;
        }

        public void onClick(View view) {
            if (this.f1138a.f1158j.m3341c()) {
                if (this.f1138a.f1159k && this.f1138a.f1158j != null && this.f1138a.f1158j.m3341c()) {
                    App.m2865a(this.f1138a.getString(C0861R.string.msg_download_multi_cancell_all));
                }
                int count = this.f1138a.f1150b.getCount();
                for (int i = 1; i <= count; i++) {
                    this.f1138a.f1150b.m3020c(i - 1);
                }
                this.f1138a.f1154f.setChecked(false);
                return;
            }
            this.f1138a.m2578d();
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.5 */
    class C07295 implements OnClickListener {
        final /* synthetic */ ActivityAudioManager f1139a;

        C07295(ActivityAudioManager activityAudioManager) {
            this.f1139a = activityAudioManager;
        }

        public void onClick(View view) {
            if (this.f1139a.f1158j.m3341c()) {
                this.f1139a.m2585h();
            } else {
                this.f1139a.m2573b();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.6 */
    class C07306 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityAudioManager f1140a;

        C07306(ActivityAudioManager activityAudioManager) {
            this.f1140a = activityAudioManager;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            List<C0912b> a = this.f1140a.f1150b.m3014a();
            ArrayList arrayList = new ArrayList();
            for (C0912b c0912b : a) {
                if (c0912b.m3170a()) {
                    arrayList.add(Integer.valueOf(c0912b.m3174c()));
                }
            }
            if (VERSION.SDK_INT >= 11) {
                new DeleteMultiFiles(this.f1140a, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                return;
            }
            new DeleteMultiFiles(this.f1140a, null).execute(new ArrayList[]{arrayList});
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.7 */
    class C07317 extends BroadcastReceiver {
        final /* synthetic */ ActivityAudioManager f1141a;

        C07317(ActivityAudioManager activityAudioManager) {
            this.f1141a = activityAudioManager;
        }

        public void onReceive(Context context, Intent intent) {
            if (!((ActivityAudioManager) context).isFinishing()) {
                this.f1141a.m2579e();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityAudioManager.8 */
    class C07328 implements ServiceConnection {
        final /* synthetic */ ActivityAudioManager f1142a;

        C07328(ActivityAudioManager activityAudioManager) {
            this.f1142a = activityAudioManager;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f1142a.f1158j = ((C0954a) iBinder).m3326a();
            this.f1142a.f1159k = true;
            this.f1142a.m2582f();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f1142a.f1159k = false;
            this.f1142a.m2583g();
        }
    }

    private class DeleteMultiFiles extends AsyncTask<ArrayList<Integer>, Void, Boolean> {
        final /* synthetic */ ActivityAudioManager f1143a;
        private ProgressDialog f1144b;
        private Context f1145c;

        private DeleteMultiFiles(ActivityAudioManager activityAudioManager, Context context) {
            this.f1143a = activityAudioManager;
            this.f1145c = context;
        }

        @SafeVarargs
        protected final Boolean m2560a(ArrayList<Integer>... arrayListArr) {
            for (int i = 0; i < arrayListArr[0].size(); i++) {
                int intValue = ((Integer) arrayListArr[0].get(i)).intValue();
                String e = App.m2879e(intValue);
                File file = new File(C0939a.m3274b(e));
                if (file.exists()) {
                    file.delete();
                }
                int i2 = this.f1143a.f1155g.f1453e.m3073a(intValue).f1706c;
                for (int i3 = 1; i3 <= i2; i3++) {
                    File file2 = new File(App.m2887l() + App.m2870b(intValue, i3));
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                File file3 = new File(C0939a.m3272a(e));
                if (file3.exists()) {
                    file3.delete();
                }
            }
            return Boolean.valueOf(true);
        }

        protected void m2561a(Boolean bool) {
            if (!(((ActivityAudioManager) this.f1145c).isFinishing() || this.f1144b == null || !this.f1144b.isShowing())) {
                this.f1144b.dismiss();
            }
            this.f1143a.f1154f.setChecked(false);
            for (int i = 1; i <= this.f1143a.f1150b.getCount(); i++) {
                this.f1143a.f1150b.m3020c(i - 1);
            }
            this.f1143a.f1150b.notifyDataSetChanged();
        }

        @SafeVarargs
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2560a((ArrayList[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2561a((Boolean) obj);
        }

        protected void onPreExecute() {
            this.f1144b = new ProgressDialog(this.f1145c);
            this.f1144b.setMessage(this.f1145c.getString(C0861R.string.dialog_desc_delete));
            this.f1144b.setProgressStyle(0);
            this.f1144b.setCancelable(false);
            this.f1144b.show();
        }
    }

    private class LoadingInitList extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ ActivityAudioManager f1146a;
        private ProgressDialog f1147b;
        private Context f1148c;

        private LoadingInitList(ActivityAudioManager activityAudioManager, Context context) {
            this.f1146a = activityAudioManager;
            this.f1148c = context;
        }

        protected Boolean m2562a(Void... voidArr) {
            ArrayList arrayList = new ArrayList();
            int i = 1;
            for (String c0912b : this.f1146a.getResources().getStringArray(C0861R.array.sura_name_with_number)) {
                arrayList.add(new C0912b(c0912b, i, App.m2889n(), false));
                i++;
            }
            this.f1146a.f1150b = new C0865b(this.f1148c, arrayList);
            return Boolean.valueOf(true);
        }

        protected void m2563a(Boolean bool) {
            this.f1146a.f1151c.setAdapter(this.f1146a.f1150b);
            if (!((ActivityAudioManager) this.f1148c).isFinishing() && this.f1147b != null && this.f1147b.isShowing()) {
                this.f1147b.dismiss();
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2562a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2563a((Boolean) obj);
        }

        protected void onPreExecute() {
            this.f1147b = new ProgressDialog(this.f1148c);
            this.f1147b.setMessage(this.f1148c.getString(C0861R.string.dialog_desc_download_empty));
            this.f1147b.setProgressStyle(0);
            this.f1147b.setCancelable(false);
            this.f1147b.show();
        }
    }

    public ActivityAudioManager() {
        this.f1159k = false;
        this.f1160l = 0;
        this.f1149a = new C07317(this);
        this.f1161m = new C07328(this);
    }

    private void m2571a() {
        if (m2575c() == this.f1150b.getCount()) {
            this.f1154f.setChecked(true);
        } else {
            this.f1154f.setChecked(false);
        }
    }

    @SuppressLint({"InlinedApi"})
    private void m2573b() {
        if (m2575c() >= 1) {
            new Builder(this).setMessage((int) C0861R.string.dialog_confirm_delete_desc).setCancelable(false).setPositiveButton((int) C0861R.string.yes, new C07306(this)).setNegativeButton((int) C0861R.string.cancel, null).show();
            return;
        }
        App.m2871b(getString(C0861R.string.no_item_selected));
    }

    private int m2575c() {
        int i = 0;
        for (C0912b a : this.f1150b.m3014a()) {
            i = a.m3170a() ? i + 1 : i;
        }
        return i;
    }

    @SuppressLint({"InlinedApi"})
    private void m2578d() {
        if (m2575c() < 1) {
            App.m2871b(getString(C0861R.string.no_item_selected));
        } else if (!App.m2881f()) {
            App.m2871b(getString(C0861R.string.msg_not_online));
        } else if (App.m2891p()) {
            List<C0912b> a = this.f1150b.m3014a();
            ArrayList arrayList = new ArrayList();
            for (C0912b c0912b : a) {
                if (c0912b.m3170a()) {
                    arrayList.add(Integer.valueOf(c0912b.m3174c()));
                }
            }
            this.f1157i = arrayList;
            C0921b c0921b = new C0921b(this.f1156h, App.m2876d(((Integer) arrayList.get(0)).intValue()), this);
            if (VERSION.SDK_INT >= 11) {
                c0921b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else {
                c0921b.execute(new String[0]);
            }
        } else {
            App.m2871b(getString(C0861R.string.msg_sdcard_not_mounted_download));
        }
    }

    private void m2579e() {
        if (!this.f1159k) {
            this.f1152d.setImageResource(C0861R.drawable.ic_action_download);
            this.f1153e.setVisibility(0);
        } else if (this.f1158j == null || !this.f1158j.m3341c()) {
            this.f1152d.setImageResource(C0861R.drawable.ic_action_download);
            this.f1153e.setVisibility(0);
        } else {
            this.f1152d.setImageResource(C0861R.drawable.ic_action_stop);
            this.f1153e.setVisibility(8);
        }
    }

    private void m2582f() {
        super.onResume();
        this.f1158j.m3334a((C0734e) this);
        if (this.f1158j.m3341c()) {
            this.f1150b = new C0865b(this, this.f1158j.m3337b());
            this.f1151c.setAdapter(this.f1150b);
            for (int i = 0; i < this.f1150b.getCount(); i++) {
                if (((C0912b) this.f1150b.getItem(i)).m3170a()) {
                    this.f1151c.setSelection(i);
                    break;
                }
            }
        } else if (VERSION.SDK_INT >= 11) {
            new LoadingInitList(this, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new LoadingInitList(this, null).execute(new Void[0]);
        }
        m2579e();
    }

    private void m2583g() {
        super.onPause();
        this.f1158j.m3336a(this.f1150b.m3014a());
        this.f1158j.m3338b((C0734e) this);
    }

    private void m2585h() {
        new Builder(this).setMessage(getString(C0861R.string.msg_download_multi_alert_is_running)).setCancelable(false).setNegativeButton((int) C0861R.string.close, null).show();
    }

    @SuppressLint({"InlinedApi"})
    public void m2593a(int i) {
        if (!((ActivityAudioManager) this.f1156h).isFinishing()) {
            if (i == 0 || i == 4) {
                App.m2871b(getString(C0861R.string.msg_download_exception_server_not_response));
                return;
            }
            String m = i == 1 ? App.m2888m() : i == 2 ? App.m2889n() : i == 3 ? App.m2890o() : App.m2888m();
            for (int i2 = 0; i2 < this.f1157i.size(); i2++) {
                C0912b c0912b = (C0912b) this.f1150b.getItem(((Integer) this.f1157i.get(i2)).intValue() - 1);
                if (c0912b != null) {
                    String b = c0912b.m3171b();
                    String d = c0912b.m3176d();
                    c0912b.m3168a(m + d + ".zip");
                    c0912b.m3175c(true);
                    String g = c0912b.m3179g();
                    if (App.m2874c(c0912b.m3174c())) {
                        c0912b.m3169a(false);
                        c0912b.m3175c(false);
                    } else {
                        MultiDownloadService.m3328a(getApplicationContext(), C0914e.m3185a(d, b, g));
                    }
                }
            }
            this.f1150b.notifyDataSetChanged();
            m2571a();
        }
    }

    public void m2594a(C0910d c0910d) {
        if (c0910d instanceof C0911a) {
            this.f1150b.m3016a((C0911a) c0910d);
        }
        if (System.currentTimeMillis() - this.f1160l > 2000) {
            this.f1160l = System.currentTimeMillis();
            m2579e();
        }
    }

    public void m2595b(C0910d c0910d) {
        this.f1150b.m3017a(c0910d);
    }

    public void m2596c(C0910d c0910d) {
        if ((c0910d instanceof C0913c) && !((C0913c) c0910d).m3184b()) {
            App.m2871b(((C0913c) c0910d).m3183a());
        }
        this.f1150b.m3019b(c0910d);
    }

    @SuppressLint({"InlinedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0861R.layout.activity_audio_manager);
        Toolbar toolbar = (Toolbar) findViewById(C0861R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new C07251(this));
        }
        this.f1156h = this;
        App.f1448m.f1450b.m3067a(this);
        this.f1155g = (App) getApplication();
        this.f1154f = (CheckBox) findViewById(C0861R.id.checkAll);
        this.f1152d = (ImageButton) findViewById(C0861R.id.buttonDownload);
        this.f1153e = (ImageButton) findViewById(C0861R.id.buttonDelete);
        ((TextView) findViewById(C0861R.id.textInfoDesc)).setText(App.m2878e());
        this.f1151c = (ListView) findViewById(C0861R.id.list);
        if (VERSION.SDK_INT >= 11) {
            this.f1151c.setFastScrollEnabled(true);
            this.f1151c.setVerticalScrollbarPosition(1);
        } else {
            this.f1151c.setFastScrollEnabled(false);
        }
        this.f1151c.setOnItemClickListener(new C07262(this));
        this.f1154f.setOnClickListener(new C07273(this));
        this.f1152d.setOnClickListener(new C07284(this));
        this.f1153e.setOnClickListener(new C07295(this));
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.f1149a);
    }

    protected void onResume() {
        super.onResume();
        if (this.f1149a != null) {
            registerReceiver(this.f1149a, new IntentFilter(C0879b.f1650g));
        }
    }

    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MultiDownloadService.class), this.f1161m, 1);
    }

    protected void onStop() {
        super.onStop();
        if (this.f1159k) {
            unbindService(this.f1161m);
            this.f1159k = false;
            m2583g();
        }
    }
}
