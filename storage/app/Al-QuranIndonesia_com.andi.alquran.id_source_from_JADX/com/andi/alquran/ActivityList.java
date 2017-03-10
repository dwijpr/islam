package com.andi.alquran;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0080b;
import android.support.design.widget.TabLayout.C0087e;
import android.support.design.widget.TabLayout.C0089f;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.p009b.C0173a;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.recyclerview.BuildConfig;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.andi.alquran.p032j.C0947g;
import com.google.android.gms.maps.GoogleMap;
import p000a.p001a.p002a.C0000a;
import p000a.p001a.p002a.C0006c;
import p000a.p001a.p002a.C0006c.C0004a;

public class ActivityList extends ActivityBase {
    private ViewPager f1224a;
    private App f1225b;

    /* renamed from: com.andi.alquran.ActivityList.1 */
    class C07571 implements C0080b {
        final /* synthetic */ ActivityList f1209a;

        C07571(ActivityList activityList) {
            this.f1209a = activityList;
        }

        public void m2631a(C0087e c0087e) {
            this.f1209a.f1224a.setCurrentItem(c0087e.m426c());
        }

        public void m2632b(C0087e c0087e) {
        }

        public void m2633c(C0087e c0087e) {
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.2 */
    class C07582 implements C0004a {
        final /* synthetic */ ActivityList f1210a;

        C07582(ActivityList activityList) {
            this.f1210a = activityList;
        }

        public void m2634a(C0006c c0006c, int i, int i2) {
            if (i2 == 1) {
                this.f1210a.m2606d();
            } else if (i2 == 2) {
                this.f1210a.m2603a(true);
            } else if (i2 == 3) {
                this.f1210a.m2605c();
            } else if (i2 == 4) {
                this.f1210a.m2607e();
            } else if (i2 == 5) {
                this.f1210a.m2604b();
            }
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.3 */
    class C07593 implements OnClickListener {
        final /* synthetic */ C0006c f1211a;
        final /* synthetic */ ActivityList f1212b;

        C07593(ActivityList activityList, C0006c c0006c) {
            this.f1212b = activityList;
            this.f1211a = c0006c;
        }

        public void onClick(View view) {
            this.f1211a.m18b(view);
            this.f1211a.m19c(4);
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.4 */
    class C07604 implements OnClickListener {
        final /* synthetic */ ActivityList f1213a;

        C07604(ActivityList activityList) {
            this.f1213a = activityList;
        }

        public void onClick(View view) {
            this.f1213a.finish();
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.5 */
    class C07615 implements OnClickListener {
        final /* synthetic */ ActivityList f1214a;

        C07615(ActivityList activityList) {
            this.f1214a = activityList;
        }

        public void onClick(View view) {
            this.f1214a.m2638f();
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.6 */
    class C07626 implements OnItemSelectedListener {
        final /* synthetic */ TextView f1215a;
        final /* synthetic */ EditText f1216b;
        final /* synthetic */ ActivityList f1217c;

        C07626(ActivityList activityList, TextView textView, EditText editText) {
            this.f1217c = activityList;
            this.f1215a = textView;
            this.f1216b = editText;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = this.f1217c.f1225b.f1453e.m3073a(i + 1).f1706c;
            this.f1215a.setText(this.f1217c.getResources().getString(C0861R.string.ayat_goto, new Object[]{"1-" + i2}));
            this.f1216b.setHint("1-" + i2);
            this.f1216b.setFilters(new InputFilter[]{new C0947g(1, i2)});
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.7 */
    class C07637 implements DialogInterface.OnClickListener {
        final /* synthetic */ Spinner f1218a;
        final /* synthetic */ EditText f1219b;
        final /* synthetic */ ActivityList f1220c;

        C07637(ActivityList activityList, Spinner spinner, EditText editText) {
            this.f1220c = activityList;
            this.f1218a = spinner;
            this.f1219b = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int selectedItemPosition = this.f1218a.getSelectedItemPosition() + 1;
            int parseInt = !this.f1219b.getText().toString().matches(BuildConfig.VERSION_NAME) ? Integer.parseInt(this.f1219b.getText().toString()) : 1;
            Intent intent = new Intent(this.f1220c, ActivityQuran.class);
            intent.putExtra("PAGING", 1);
            intent.putExtra("SURA", selectedItemPosition);
            intent.putExtra("AYA", parseInt);
            intent.putExtra("OPENFROMJUZ", false);
            this.f1220c.startActivity(intent);
        }
    }

    /* renamed from: com.andi.alquran.ActivityList.8 */
    class C07648 implements DialogInterface.OnClickListener {
        final /* synthetic */ ActivityList f1221a;

        C07648(ActivityList activityList) {
            this.f1221a = activityList;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int f1222a;
        final /* synthetic */ ActivityList f1223b;

        private PagerAdapter(ActivityList activityList, FragmentManager fragmentManager, int i) {
            this.f1223b = activityList;
            super(fragmentManager);
            this.f1222a = i;
        }

        public int getCount() {
            return this.f1222a;
        }

        public Fragment getItem(int i) {
            switch (i) {
                case GoogleMap.MAP_TYPE_NONE /*0*/:
                    return new FragmentSurah();
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                    return new FragmentJuz();
                case GoogleMap.MAP_TYPE_SATELLITE /*2*/:
                    return new FragmentBookmark();
                default:
                    return null;
            }
        }
    }

    @SuppressLint({"InflateParams"})
    private void m2638f() {
        View inflate = LayoutInflater.from(this).inflate(C0861R.layout.dialog_gotosura, null);
        Builder builder = new Builder(this);
        builder.setView(inflate);
        builder.setTitle(getString(C0861R.string.dialog_title_gotosura));
        builder.setIcon(this.f1225b.f1450b.f1676o == 1 ? C0861R.drawable.ic_black_action_gotosura : C0861R.drawable.ic_action_gotosura);
        Spinner spinner = (Spinner) inflate.findViewById(C0861R.id.spinner_sura);
        SpinnerAdapter createFromResource = ArrayAdapter.createFromResource(this, C0861R.array.sura_name_with_number, 17367048);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter(createFromResource);
        TextView textView = (TextView) inflate.findViewById(C0861R.id.info_aya_goto);
        EditText editText = (EditText) inflate.findViewById(C0861R.id.edit_aya);
        textView.setText(getResources().getString(C0861R.string.ayat_goto, new Object[]{"1-7"}));
        editText.setHint("1-7");
        editText.setFilters(new InputFilter[]{new C0947g(1, 7)});
        spinner.setOnItemSelectedListener(new C07626(this, textView, editText));
        builder.setPositiveButton(getString(C0861R.string.ok), new C07637(this, spinner, editText));
        builder.setNegativeButton(getString(C0861R.string.cancel), new C07648(this));
        AlertDialog create = builder.create();
        create.show();
        create.setCanceledOnTouchOutside(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        App.f1448m.f1450b.m3067a(this);
        this.f1225b = (App) getApplication();
        if (this.f1225b.f1450b.f1676o == 1) {
            setContentView((int) C0861R.layout.activity_listsurajuz);
        } else {
            setTheme(C0861R.style.AndiThemeNoHeaderDark);
            setContentView((int) C0861R.layout.dark_activity_listsurajuz);
        }
        TabLayout tabLayout = (TabLayout) findViewById(C0861R.id.tab_layout);
        tabLayout.m470a(tabLayout.m465a().m421a(getString(C0861R.string.tab_sura)));
        tabLayout.m470a(tabLayout.m465a().m421a(getString(C0861R.string.tab_juz)));
        tabLayout.m470a(tabLayout.m465a().m421a(getString(C0861R.string.tab_bookmark)));
        tabLayout.setTabGravity(0);
        this.f1224a = (ViewPager) findViewById(C0861R.id.pager);
        this.f1224a.setAdapter(new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), null));
        this.f1224a.m1320a(new C0089f(tabLayout));
        tabLayout.m469a(new C07571(this));
        C0006c c0006c = new C0006c(this, 1);
        C0000a c0000a = new C0000a(1, getResources().getString(C0861R.string.go_to_search), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_search));
        C0000a c0000a2 = new C0000a(2, getResources().getString(C0861R.string.go_to_last_read), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_last_read));
        C0000a c0000a3 = new C0000a(3, getResources().getString(C0861R.string.go_to_setting), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_setting));
        C0000a c0000a4 = new C0000a(4, getResources().getString(C0861R.string.go_to_rate), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_rate));
        C0000a c0000a5 = new C0000a(5, getResources().getString(C0861R.string.go_to_about), App.m2861a((Context) this, (int) C0861R.drawable.ic_action_about));
        c0006c.m15a(c0000a);
        c0006c.m15a(c0000a2);
        c0006c.m15a(c0000a3);
        c0006c.m15a(c0000a4);
        c0006c.m15a(c0000a5);
        c0006c.m16a(new C07582(this));
        ((ImageButton) findViewById(C0861R.id.buttonMenu)).setOnClickListener(new C07593(this, c0006c));
        ((ImageButton) findViewById(C0861R.id.logo)).setOnClickListener(new C07604(this));
        ImageButton imageButton = (ImageButton) findViewById(C0861R.id.buttonGoToSura);
        imageButton.setVisibility(0);
        imageButton.setOnClickListener(new C07615(this));
        if ((C0173a.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == 0 ? 1 : 0) == 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, C0861R.styleable.AppCompatTheme_switchStyle);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case C0861R.styleable.AppCompatTheme_switchStyle /*113*/:
                if (iArr.length > 0 && iArr[0] != 0) {
                    App.m2865a(getString(C0861R.string.msg_request_permission_phone_state));
                }
            default:
        }
    }
}
