package com.andi.alquran.p026c;

import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.andi.alquran.C0861R;

/* renamed from: com.andi.alquran.c.a */
public class C0885a {
    private final C0884b[] f1714a;
    private final int[][] f1715b;

    /* renamed from: com.andi.alquran.c.a.a */
    public static class C0883a {
        public int f1702a;
        public int f1703b;

        public C0883a(int i, int i2) {
            this.f1702a = i;
            this.f1703b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0883a)) {
                return false;
            }
            C0883a c0883a = (C0883a) obj;
            return c0883a.f1702a == this.f1702a && c0883a.f1703b == this.f1703b;
        }
    }

    /* renamed from: com.andi.alquran.c.a.b */
    public static class C0884b {
        public int f1704a;
        public int f1705b;
        public int f1706c;
        public int f1707d;
        public int f1708e;
        public String f1709f;
        public String f1710g;
        public String f1711h;
        public int f1712i;
        public int f1713j;

        public C0884b(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, int i6, int i7) {
            this.f1704a = i;
            this.f1705b = i2;
            this.f1706c = i3;
            this.f1707d = i4;
            this.f1708e = i5;
            this.f1709f = str;
            this.f1710g = str2;
            this.f1711h = str3;
            this.f1712i = i6;
            this.f1713j = i7;
        }
    }

    public C0885a() {
        C0884b[] c0884bArr = new C0884b[C0861R.styleable.AppCompatTheme_listMenuViewStyle];
        c0884bArr[0] = new C0884b(1, 0, 7, 5, 1, "\u0627\u0644\u0641\u0627\u062a\u062d\u0629", "Al-Faatiha", "The Opening", 0, C0861R.drawable.sname_1);
        c0884bArr[1] = new C0884b(2, 7, 286, 87, 40, "\u0627\u0644\u0628\u0642\u0631\u0629", "Al-Baqara", "The Cow", 1, C0861R.drawable.sname_2);
        c0884bArr[2] = new C0884b(3, 293, Callback.DEFAULT_DRAG_ANIMATION_DURATION, 89, 20, "\u0622\u0644 \u0639\u0645\u0631\u0627\u0646", "Aal-i-Imraan", "The Family of Imraan", 1, C0861R.drawable.sname_3);
        c0884bArr[3] = new C0884b(4, 493, 176, 92, 24, "\u0627\u0644\u0646\u0633\u0627\u0621", "An-Nisaa", "The Women", 1, C0861R.drawable.sname_4);
        c0884bArr[4] = new C0884b(5, 669, 120, C0861R.styleable.AppCompatTheme_spinnerStyle, 16, "\u0627\u0644\u0645\u0627\u0626\u062f\u0629", "Al-Maaida", "The Table", 1, C0861R.drawable.sname_5);
        c0884bArr[5] = new C0884b(6, 789, 165, 55, 20, "\u0627\u0644\u0623\u0646\u0639\u0627\u0645", "Al-An'aam", "The Cattle", 0, C0861R.drawable.sname_6);
        c0884bArr[6] = new C0884b(7, 954, 206, 39, 24, "\u0627\u0644\u0623\u0639\u0631\u0627\u0641", "Al-A'raaf", "The Heights", 0, C0861R.drawable.sname_7);
        c0884bArr[7] = new C0884b(8, 1160, 75, 88, 10, "\u0627\u0644\u0623\u0646\u0641\u0627\u0644", "Al-Anfaal", "The Spoils of War", 1, C0861R.drawable.sname_8);
        c0884bArr[8] = new C0884b(9, 1235, 129, C0861R.styleable.AppCompatTheme_switchStyle, 16, "\u0627\u0644\u062a\u0648\u0628\u0629", "At-Tawba", "The Repentance", 1, C0861R.drawable.sname_9);
        c0884bArr[9] = new C0884b(10, 1364, C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator, 51, 11, "\u064a\u0648\u0646\u0633", "Yunus", "Jonas", 0, C0861R.drawable.sname_10);
        c0884bArr[10] = new C0884b(11, 1473, 123, 52, 10, "\u0647\u0648\u062f", "Hud", "Hud", 0, C0861R.drawable.sname_11);
        c0884bArr[11] = new C0884b(12, 1596, C0861R.styleable.AppCompatTheme_seekBarStyle, 53, 12, "\u064a\u0648\u0633\u0641", "Yusuf", "Joseph", 0, C0861R.drawable.sname_12);
        c0884bArr[12] = new C0884b(13, 1707, 43, 96, 6, "\u0627\u0644\u0631\u0639\u062f", "Ar-Ra'd", "The Thunder", 1, C0861R.drawable.sname_13);
        c0884bArr[13] = new C0884b(14, 1750, 52, 72, 7, "\u0627\u0628\u0631\u0627\u0647\u064a\u0645", "Ibrahim", "Abraham", 0, C0861R.drawable.sname_14);
        c0884bArr[14] = new C0884b(15, 1802, 99, 54, 6, "\u0627\u0644\u062d\u062c\u0631", "Al-Hijr", "The Rock", 0, C0861R.drawable.sname_15);
        c0884bArr[15] = new C0884b(16, 1901, NotificationCompat.FLAG_HIGH_PRIORITY, 70, 16, "\u0627\u0644\u0646\u062d\u0644", "An-Nahl", "The Bee", 0, C0861R.drawable.sname_16);
        c0884bArr[16] = new C0884b(17, 2029, C0861R.styleable.AppCompatTheme_seekBarStyle, 50, 12, "\u0627\u0644\u0625\u0633\u0631\u0627\u0621", "Al-Israa", "The Night Journey", 0, C0861R.drawable.sname_17);
        c0884bArr[17] = new C0884b(18, 2140, C0861R.styleable.AppCompatTheme_ratingBarStyleSmall, 69, 12, "\u0627\u0644\u0643\u0647\u0641", "Al-Kahf", "The Cave", 0, C0861R.drawable.sname_18);
        c0884bArr[18] = new C0884b(19, 2250, 98, 44, 6, "\u0645\u0631\u064a\u0645", "Maryam", "Mary", 0, C0861R.drawable.sname_19);
        c0884bArr[19] = new C0884b(20, 2348, 135, 45, 8, "\u0637\u0647", "Taa-Haa", "Taa-Haa", 0, C0861R.drawable.sname_20);
        c0884bArr[20] = new C0884b(21, 2483, C0861R.styleable.AppCompatTheme_spinnerStyle, 73, 7, "\u0627\u0644\u0623\u0646\u0628\u064a\u0627\u0621", "Al-Anbiyaa", "The Prophets", 0, C0861R.drawable.sname_21);
        c0884bArr[21] = new C0884b(22, 2595, 78, C0861R.styleable.AppCompatTheme_buttonStyleSmall, 10, "\u0627\u0644\u062d\u062c", "Al-Hajj", "The Pilgrimage", 1, C0861R.drawable.sname_22);
        c0884bArr[22] = new C0884b(23, 2673, 118, 74, 6, "\u0627\u0644\u0645\u0624\u0645\u0646\u0648\u0646", "Al-Muminoon", "The Believers", 0, C0861R.drawable.sname_23);
        c0884bArr[23] = new C0884b(24, 2791, 64, C0861R.styleable.AppCompatTheme_buttonStyle, 9, "\u0627\u0644\u0646\u0648\u0631", "An-Noor", "The Light", 1, C0861R.drawable.sname_24);
        c0884bArr[24] = new C0884b(25, 2855, 77, 42, 6, "\u0627\u0644\u0641\u0631\u0642\u0627\u0646", "Al-Furqaan", "The Criterion", 0, C0861R.drawable.sname_25);
        c0884bArr[25] = new C0884b(26, 2932, 227, 47, 11, "\u0627\u0644\u0634\u0639\u0631\u0627\u0621", "Ash-Shu'araa", "The Poets", 0, C0861R.drawable.sname_26);
        c0884bArr[26] = new C0884b(27, 3159, 93, 48, 7, "\u0627\u0644\u0646\u0645\u0644", "An-Naml", "The Ant", 0, C0861R.drawable.sname_27);
        c0884bArr[27] = new C0884b(28, 3252, 88, 49, 8, "\u0627\u0644\u0642\u0635\u0635", "Al-Qasas", "The Stories", 0, C0861R.drawable.sname_28);
        c0884bArr[28] = new C0884b(29, 3340, 69, 85, 7, "\u0627\u0644\u0639\u0646\u0643\u0628\u0648\u062a", "Al-Ankaboot", "The Spider", 0, C0861R.drawable.sname_29);
        c0884bArr[29] = new C0884b(30, 3409, 60, 84, 6, "\u0627\u0644\u0631\u0648\u0645", "Ar-Room", "The Romans", 0, C0861R.drawable.sname_30);
        c0884bArr[30] = new C0884b(31, 3469, 34, 57, 3, "\u0644\u0642\u0645\u0627\u0646", "Luqman", "Luqman", 0, C0861R.drawable.sname_31);
        c0884bArr[31] = new C0884b(32, 3503, 30, 75, 3, "\u0627\u0644\u0633\u062c\u062f\u0629", "As-Sajda", "The Prostration", 0, C0861R.drawable.sname_32);
        c0884bArr[32] = new C0884b(33, 3533, 73, 90, 9, "\u0627\u0644\u0623\u062d\u0632\u0627\u0628", "Al-Ahzaab", "The Clans", 1, C0861R.drawable.sname_33);
        c0884bArr[33] = new C0884b(34, 3606, 54, 58, 6, "\u0633\u0628\u0625", "Saba", "Sheba", 0, C0861R.drawable.sname_34);
        c0884bArr[34] = new C0884b(35, 3660, 45, 43, 5, "\u0641\u0627\u0637\u0631", "Faatir", "The Originator", 0, C0861R.drawable.sname_35);
        c0884bArr[35] = new C0884b(36, 3705, 83, 41, 5, "\u064a\u0633", "Yaseen", "Yaseen", 0, C0861R.drawable.sname_36);
        c0884bArr[36] = new C0884b(37, 3788, 182, 56, 5, "\u0627\u0644\u0635\u0627\u0641\u0627\u062a", "As-Saaffaat", "Those drawn up in Ranks", 0, C0861R.drawable.sname_37);
        c0884bArr[37] = new C0884b(38, 3970, 88, 38, 5, "\u0635", "Saad", "The letter Saad", 0, C0861R.drawable.sname_38);
        c0884bArr[38] = new C0884b(39, 4058, 75, 59, 8, "\u0627\u0644\u0632\u0645\u0631", "Az-Zumar", "The Groups", 0, C0861R.drawable.sname_39);
        c0884bArr[39] = new C0884b(40, 4133, 85, 60, 9, "\u063a\u0627\u0641\u0631", "Al-Ghaafir", "The Forgiver", 0, C0861R.drawable.sname_40);
        c0884bArr[40] = new C0884b(41, 4218, 54, 61, 6, "\u0641\u0635\u0644\u062a", "Fussilat", "Explained in detail", 0, C0861R.drawable.sname_41);
        c0884bArr[41] = new C0884b(42, 4272, 53, 62, 5, "\u0627\u0644\u0634\u0648\u0631\u0649", "Ash-Shura", "Consultation", 0, C0861R.drawable.sname_42);
        c0884bArr[42] = new C0884b(43, 4325, 89, 63, 7, "\u0627\u0644\u0632\u062e\u0631\u0641", "Az-Zukhruf", "Ornaments of gold", 0, C0861R.drawable.sname_43);
        c0884bArr[43] = new C0884b(44, 4414, 59, 64, 3, "\u0627\u0644\u062f\u062e\u0627\u0646", "Ad-Dukhaan", "The Smoke", 0, C0861R.drawable.sname_44);
        c0884bArr[44] = new C0884b(45, 4473, 37, 65, 4, "\u0627\u0644\u062c\u0627\u062b\u064a\u0629", "Al-Jaathiya", "Crouching", 0, C0861R.drawable.sname_45);
        c0884bArr[45] = new C0884b(46, 4510, 35, 66, 4, "\u0627\u0644\u0623\u062d\u0642\u0627\u0641", "Al-Ahqaf", "The Dunes", 0, C0861R.drawable.sname_46);
        c0884bArr[46] = new C0884b(47, 4545, 38, 95, 4, "\u0645\u062d\u0645\u062f", "Muhammad", "Muhammad", 1, C0861R.drawable.sname_47);
        c0884bArr[47] = new C0884b(48, 4583, 29, C0861R.styleable.AppCompatTheme_seekBarStyle, 4, "\u0627\u0644\u0641\u062a\u062d", "Al-Fath", "The Victory", 1, C0861R.drawable.sname_48);
        c0884bArr[48] = new C0884b(49, 4612, 18, C0861R.styleable.AppCompatTheme_editTextStyle, 2, "\u0627\u0644\u062d\u062c\u0631\u0627\u062a", "Al-Hujuraat", "The Inner Apartments", 1, C0861R.drawable.sname_49);
        c0884bArr[49] = new C0884b(50, 4630, 45, 34, 3, "\u0642", "Qaaf", "The letter Qaaf", 0, C0861R.drawable.sname_50);
        c0884bArr[50] = new C0884b(51, 4675, 60, 67, 3, "\u0627\u0644\u0630\u0627\u0631\u064a\u0627\u062a", "Adh-Dhaariyat", "The Winnowing Winds", 0, C0861R.drawable.sname_51);
        c0884bArr[51] = new C0884b(52, 4735, 49, 76, 2, "\u0627\u0644\u0637\u0648\u0631", "At-Tur", "The Mount", 0, C0861R.drawable.sname_52);
        c0884bArr[52] = new C0884b(53, 4784, 62, 23, 3, "\u0627\u0644\u0646\u062c\u0645", "An-Najm", "The Star", 0, C0861R.drawable.sname_53);
        c0884bArr[53] = new C0884b(54, 4846, 55, 37, 3, "\u0627\u0644\u0642\u0645\u0631", "Al-Qamar", "The Moon", 0, C0861R.drawable.sname_54);
        c0884bArr[54] = new C0884b(55, 4901, 78, 97, 3, "\u0627\u0644\u0631\u062d\u0645\u0646", "Ar-Rahmaan", "The Beneficent", 1, C0861R.drawable.sname_55);
        c0884bArr[55] = new C0884b(56, 4979, 96, 46, 3, "\u0627\u0644\u0648\u0627\u0642\u0639\u0629", "Al-Waaqia", "The Inevitable", 0, C0861R.drawable.sname_56);
        c0884bArr[56] = new C0884b(57, 5075, 29, 94, 4, "\u0627\u0644\u062d\u062f\u064a\u062f", "Al-Hadid", "The Iron", 1, C0861R.drawable.sname_57);
        c0884bArr[57] = new C0884b(58, 5104, 22, C0861R.styleable.AppCompatTheme_checkedTextViewStyle, 3, "\u0627\u0644\u0645\u062c\u0627\u062f\u0644\u0629", "Al-Mujaadila", "The Pleading Woman", 1, C0861R.drawable.sname_58);
        c0884bArr[58] = new C0884b(59, 5126, 24, C0861R.styleable.AppCompatTheme_autoCompleteTextViewStyle, 3, "\u0627\u0644\u062d\u0634\u0631", "Al-Hashr", "The Exile", 1, C0861R.drawable.sname_59);
        c0884bArr[59] = new C0884b(60, 5150, 13, 91, 2, "\u0627\u0644\u0645\u0645\u062a\u062d\u0646\u0629", "Al-Mumtahana", "She that is to be examined", 1, C0861R.drawable.sname_60);
        c0884bArr[60] = new C0884b(61, 5163, 14, C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator, 2, "\u0627\u0644\u0635\u0641", "As-Saff", "The Ranks", 1, C0861R.drawable.sname_61);
        c0884bArr[61] = new C0884b(62, 5177, 11, C0861R.styleable.AppCompatTheme_ratingBarStyleSmall, 2, "\u0627\u0644\u062c\u0645\u0639\u0629", "Al-Jumu'a", "Friday", 1, C0861R.drawable.sname_62);
        c0884bArr[62] = new C0884b(63, 5188, 11, C0861R.styleable.AppCompatTheme_checkboxStyle, 2, "\u0627\u0644\u0645\u0646\u0627\u0641\u0642\u0648\u0646", "Al-Munaafiqoon", "The Hypocrites", 1, C0861R.drawable.sname_63);
        c0884bArr[63] = new C0884b(64, 5199, 18, C0861R.styleable.AppCompatTheme_ratingBarStyle, 2, "\u0627\u0644\u062a\u063a\u0627\u0628\u0646", "At-Taghaabun", "Mutual Disillusion", 1, C0861R.drawable.sname_64);
        c0884bArr[64] = new C0884b(65, 5217, 12, 99, 2, "\u0627\u0644\u0637\u0644\u0627\u0642", "At-Talaaq", "Divorce", 1, C0861R.drawable.sname_65);
        c0884bArr[65] = new C0884b(66, 5229, 12, C0861R.styleable.AppCompatTheme_radioButtonStyle, 2, "\u0627\u0644\u062a\u062d\u0631\u064a\u0645", "At-Tahrim", "The Prohibition", 1, C0861R.drawable.sname_66);
        c0884bArr[66] = new C0884b(67, 5241, 30, 77, 2, "\u0627\u0644\u0645\u0644\u0643", "Al-Mulk", "The Sovereignty", 0, C0861R.drawable.sname_67);
        c0884bArr[67] = new C0884b(68, 5271, 52, 2, 2, "\u0627\u0644\u0642\u0644\u0645", "Al-Qalam", "The Pen", 0, C0861R.drawable.sname_68);
        c0884bArr[68] = new C0884b(69, 5323, 52, 78, 2, "\u0627\u0644\u062d\u0627\u0642\u0629", "Al-Haaqqa", "The Reality", 0, C0861R.drawable.sname_69);
        c0884bArr[69] = new C0884b(70, 5375, 44, 79, 2, "\u0627\u0644\u0645\u0639\u0627\u0631\u062c", "Al-Ma'aarij", "The Ascending Stairways", 0, C0861R.drawable.sname_70);
        c0884bArr[70] = new C0884b(71, 5419, 28, 71, 2, "\u0646\u0648\u062d", "Nooh", "Noah", 0, C0861R.drawable.sname_71);
        c0884bArr[71] = new C0884b(72, 5447, 28, 40, 2, "\u0627\u0644\u062c\u0646", "Al-Jinn", "The Jinn", 0, C0861R.drawable.sname_72);
        c0884bArr[72] = new C0884b(73, 5475, 20, 3, 2, "\u0627\u0644\u0645\u0632\u0645\u0644", "Al-Muzzammil", "The Enshrouded One", 0, C0861R.drawable.sname_73);
        c0884bArr[73] = new C0884b(74, 5495, 56, 4, 2, "\u0627\u0644\u0645\u062f\u062b\u0631", "Al-Muddaththir", "The Cloaked One", 0, C0861R.drawable.sname_74);
        c0884bArr[74] = new C0884b(75, 5551, 40, 31, 2, "\u0627\u0644\u0642\u064a\u0627\u0645\u0629", "Al-Qiyaama", "The Resurrection", 0, C0861R.drawable.sname_75);
        c0884bArr[75] = new C0884b(76, 5591, 31, 98, 2, "\u0627\u0644\u0627\u0646\u0633\u0627\u0646", "Al-Insaan", "Man", 1, C0861R.drawable.sname_76);
        c0884bArr[76] = new C0884b(77, 5622, 50, 33, 2, "\u0627\u0644\u0645\u0631\u0633\u0644\u0627\u062a", "Al-Mursalaat", "The Emissaries", 0, C0861R.drawable.sname_77);
        c0884bArr[77] = new C0884b(78, 5672, 40, 80, 2, "\u0627\u0644\u0646\u0628\u0625", "An-Naba", "The Announcement", 0, C0861R.drawable.sname_78);
        c0884bArr[78] = new C0884b(79, 5712, 46, 81, 2, "\u0627\u0644\u0646\u0627\u0632\u0639\u0627\u062a", "An-Naazi'aat", "Those who drag forth", 0, C0861R.drawable.sname_79);
        c0884bArr[79] = new C0884b(80, 5758, 42, 24, 1, "\u0639\u0628\u0633", "Abasa", "He frowned", 0, C0861R.drawable.sname_80);
        c0884bArr[80] = new C0884b(81, 5800, 29, 7, 1, "\u0627\u0644\u062a\u0643\u0648\u064a\u0631", "At-Takwir", "The Overthrowing", 0, C0861R.drawable.sname_81);
        c0884bArr[81] = new C0884b(82, 5829, 19, 82, 1, "\u0627\u0644\u0625\u0646\u0641\u0637\u0627\u0631", "Al-Infitaar", "The Cleaving", 0, C0861R.drawable.sname_82);
        c0884bArr[82] = new C0884b(83, 5848, 36, 86, 1, "\u0627\u0644\u0645\u0637\u0641\u0641\u064a\u0646", "Al-Mutaffifin", "Defrauding", 0, C0861R.drawable.sname_83);
        c0884bArr[83] = new C0884b(84, 5884, 25, 83, 1, "\u0627\u0644\u0625\u0646\u0634\u0642\u0627\u0642", "Al-Inshiqaaq", "The Splitting Open", 0, C0861R.drawable.sname_84);
        c0884bArr[84] = new C0884b(85, 5909, 22, 27, 1, "\u0627\u0644\u0628\u0631\u0648\u062c", "Al-Burooj", "The Constellations", 0, C0861R.drawable.sname_85);
        c0884bArr[85] = new C0884b(86, 5931, 17, 36, 1, "\u0627\u0644\u0637\u0627\u0631\u0642", "At-Taariq", "The Morning Star", 0, C0861R.drawable.sname_86);
        c0884bArr[86] = new C0884b(87, 5948, 19, 8, 1, "\u0627\u0644\u0623\u0639\u0644\u0649", "Al-A'laa", "The Most High", 0, C0861R.drawable.sname_87);
        c0884bArr[87] = new C0884b(88, 5967, 26, 68, 1, "\u0627\u0644\u063a\u0627\u0634\u064a\u0629", "Al-Ghaashiya", "The Overwhelming", 0, C0861R.drawable.sname_88);
        c0884bArr[88] = new C0884b(89, 5993, 30, 10, 1, "\u0627\u0644\u0641\u062c\u0631", "Al-Fajr", "The Dawn", 0, C0861R.drawable.sname_89);
        c0884bArr[89] = new C0884b(90, 6023, 20, 35, 1, "\u0627\u0644\u0628\u0644\u062f", "Al-Balad", "The City", 0, C0861R.drawable.sname_90);
        c0884bArr[90] = new C0884b(91, 6043, 15, 26, 1, "\u0627\u0644\u0634\u0645\u0633", "Ash-Shams", "The Sun", 0, C0861R.drawable.sname_91);
        c0884bArr[91] = new C0884b(92, 6058, 21, 9, 1, "\u0627\u0644\u0644\u064a\u0644", "Al-Lail", "The Night", 0, C0861R.drawable.sname_92);
        c0884bArr[92] = new C0884b(93, 6079, 11, 11, 1, "\u0627\u0644\u0636\u062d\u0649", "Ad-Dhuhaa", "The Morning Hours", 0, C0861R.drawable.sname_93);
        c0884bArr[93] = new C0884b(94, 6090, 8, 12, 1, "\u0627\u0644\u0634\u0631\u062d", "Ash-Sharh", "The Consolation", 0, C0861R.drawable.sname_94);
        c0884bArr[94] = new C0884b(95, 6098, 8, 28, 1, "\u0627\u0644\u062a\u064a\u0646", "At-Tin", "The Fig", 0, C0861R.drawable.sname_95);
        c0884bArr[95] = new C0884b(96, 6106, 19, 1, 1, "\u0627\u0644\u0639\u0644\u0642", "Al-Alaq", "The Clot", 0, C0861R.drawable.sname_96);
        c0884bArr[96] = new C0884b(97, 6125, 5, 25, 1, "\u0627\u0644\u0642\u062f\u0631", "Al-Qadr", "The Power, Fate", 0, C0861R.drawable.sname_97);
        c0884bArr[97] = new C0884b(98, 6130, 8, 100, 1, "\u0627\u0644\u0628\u064a\u0646\u0629", "Al-Bayyina", "The Evidence", 1, C0861R.drawable.sname_98);
        c0884bArr[98] = new C0884b(99, 6138, 8, 93, 1, "\u0627\u0644\u0632\u0644\u0632\u0644\u0629", "Az-Zalzala", "The Earthquake", 1, C0861R.drawable.sname_99);
        c0884bArr[99] = new C0884b(100, 6146, 11, 14, 1, "\u0627\u0644\u0639\u0627\u062f\u064a\u0627\u062a", "Al-Aadiyaat", "The Chargers", 0, C0861R.drawable.sname_100);
        c0884bArr[100] = new C0884b(C0861R.styleable.AppCompatTheme_autoCompleteTextViewStyle, 6157, 11, 30, 1, "\u0627\u0644\u0642\u0627\u0631\u0639\u0629", "Al-Qaari'a", "The Calamity", 0, C0861R.drawable.sname_101);
        c0884bArr[C0861R.styleable.AppCompatTheme_autoCompleteTextViewStyle] = new C0884b(C0861R.styleable.AppCompatTheme_buttonStyle, 6168, 8, 16, 1, "\u0627\u0644\u062a\u0643\u0627\u062b\u0631", "At-Takaathur", "Competition", 0, C0861R.drawable.sname_102);
        c0884bArr[C0861R.styleable.AppCompatTheme_buttonStyle] = new C0884b(C0861R.styleable.AppCompatTheme_buttonStyleSmall, 6176, 3, 13, 1, "\u0627\u0644\u0639\u0635\u0631", "Al-Asr", "The Declining Day, Epoch", 0, C0861R.drawable.sname_103);
        c0884bArr[C0861R.styleable.AppCompatTheme_buttonStyleSmall] = new C0884b(C0861R.styleable.AppCompatTheme_checkboxStyle, 6179, 9, 32, 1, "\u0627\u0644\u0647\u0645\u0632\u0629", "Al-Humaza", "The Traducer", 0, C0861R.drawable.sname_104);
        c0884bArr[C0861R.styleable.AppCompatTheme_checkboxStyle] = new C0884b(C0861R.styleable.AppCompatTheme_checkedTextViewStyle, 6188, 5, 19, 1, "\u0627\u0644\u0641\u064a\u0644", "Al-Fil", "The Elephant", 0, C0861R.drawable.sname_105);
        c0884bArr[C0861R.styleable.AppCompatTheme_checkedTextViewStyle] = new C0884b(C0861R.styleable.AppCompatTheme_editTextStyle, 6193, 4, 29, 1, "\u0642\u0631\u064a\u0634", "Quraish", "Quraysh", 0, C0861R.drawable.sname_106);
        c0884bArr[C0861R.styleable.AppCompatTheme_editTextStyle] = new C0884b(C0861R.styleable.AppCompatTheme_radioButtonStyle, 6197, 7, 17, 1, "\u0627\u0644\u0645\u0627\u0639\u0648\u0646", "Al-Maa'un", "Almsgiving", 0, C0861R.drawable.sname_107);
        c0884bArr[C0861R.styleable.AppCompatTheme_radioButtonStyle] = new C0884b(C0861R.styleable.AppCompatTheme_ratingBarStyle, 6204, 3, 15, 1, "\u0627\u0644\u0643\u0648\u062b\u0631", "Al-Kawthar", "Abundance", 0, C0861R.drawable.sname_108);
        c0884bArr[C0861R.styleable.AppCompatTheme_ratingBarStyle] = new C0884b(C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator, 6207, 6, 18, 1, "\u0627\u0644\u0643\u0627\u0641\u0631\u0648\u0646", "Al-Kaafiroon", "The Disbelievers", 0, C0861R.drawable.sname_109);
        c0884bArr[C0861R.styleable.AppCompatTheme_ratingBarStyleIndicator] = new C0884b(C0861R.styleable.AppCompatTheme_ratingBarStyleSmall, 6213, 3, C0861R.styleable.AppCompatTheme_listMenuViewStyle, 1, "\u0627\u0644\u0646\u0635\u0631", "An-Nasr", "Divine Support", 1, C0861R.drawable.sname_110);
        c0884bArr[C0861R.styleable.AppCompatTheme_ratingBarStyleSmall] = new C0884b(C0861R.styleable.AppCompatTheme_seekBarStyle, 6216, 5, 6, 1, "\u0627\u0644\u0645\u0633\u062f", "Al-Masad", "The Palm Fibre", 0, C0861R.drawable.sname_111);
        c0884bArr[C0861R.styleable.AppCompatTheme_seekBarStyle] = new C0884b(C0861R.styleable.AppCompatTheme_spinnerStyle, 6221, 4, 22, 1, "\u0627\u0644\u0625\u062e\u0644\u0627\u0635", "Al-Ikhlaas", "Sincerity", 0, C0861R.drawable.sname_112);
        c0884bArr[C0861R.styleable.AppCompatTheme_spinnerStyle] = new C0884b(C0861R.styleable.AppCompatTheme_switchStyle, 6225, 5, 20, 1, "\u0627\u0644\u0641\u0644\u0642", "Al-Falaq", "The Dawn", 0, C0861R.drawable.sname_113);
        c0884bArr[C0861R.styleable.AppCompatTheme_switchStyle] = new C0884b(C0861R.styleable.AppCompatTheme_listMenuViewStyle, 6230, 6, 21, 1, "\u0627\u0644\u0646\u0627\u0633", "An-Naas", "Mankind", 0, C0861R.drawable.sname_114);
        this.f1714a = c0884bArr;
        this.f1715b = new int[][]{new int[]{1, 1}, new int[]{2, 142}, new int[]{2, 253}, new int[]{3, 92}, new int[]{4, 24}, new int[]{4, 148}, new int[]{5, 83}, new int[]{6, C0861R.styleable.AppCompatTheme_seekBarStyle}, new int[]{7, 88}, new int[]{8, 41}, new int[]{9, 94}, new int[]{11, 6}, new int[]{12, 53}, new int[]{15, 2}, new int[]{17, 1}, new int[]{18, 75}, new int[]{21, 1}, new int[]{23, 1}, new int[]{25, 21}, new int[]{27, 60}, new int[]{29, 45}, new int[]{33, 31}, new int[]{36, 22}, new int[]{39, 32}, new int[]{41, 47}, new int[]{46, 1}, new int[]{51, 31}, new int[]{58, 1}, new int[]{67, 1}, new int[]{78, 1}};
    }

    public int m3070a() {
        return this.f1714a.length;
    }

    public int m3071a(int i, int i2, int i3) {
        if (i == 1) {
            return i2;
        }
        int[][] iArr = (int[][]) null;
        if (i == 2) {
            iArr = this.f1715b;
        }
        int i4 = 1;
        while (i4 < iArr.length) {
            if (i2 < iArr[i4][0] || (i2 == iArr[i4][0] && i3 < iArr[i4][1])) {
                return i4;
            }
            i4++;
        }
        return iArr.length;
    }

    public C0883a m3072a(int i, int i2) {
        if (i == 1) {
            return new C0883a(i2, 1);
        }
        int[] iArr = null;
        if (i == 2) {
            iArr = this.f1715b[i2 - 1];
        }
        return new C0883a(iArr[0], iArr[1]);
    }

    public C0884b m3073a(int i) {
        return this.f1714a[i - 1];
    }

    public int m3074b(int i) {
        return i == 1 ? this.f1714a.length : i == 2 ? this.f1715b.length : this.f1714a.length;
    }

    public C0883a m3075b(int i, int i2) {
        if (i == 1) {
            return new C0883a(i2, this.f1714a[i2 - 1].f1706c);
        }
        int[] iArr = new int[]{115, 1};
        if (i == 2 && i2 < this.f1715b.length) {
            iArr = this.f1715b[i2];
        }
        return iArr[1] == 1 ? new C0883a(iArr[0] - 1, this.f1714a[iArr[0] - 2].f1706c) : new C0883a(iArr[0], iArr[1] - 1);
    }
}
