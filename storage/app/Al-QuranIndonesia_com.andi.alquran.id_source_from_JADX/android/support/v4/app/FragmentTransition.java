package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.p014g.C0298a;
import android.support.v4.view.aj;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.gms.C1114a.C1096c;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import java.util.List;

class FragmentTransition {
    private static final int[] INVERSE_OPS;

    /* renamed from: android.support.v4.app.FragmentTransition.1 */
    static class C01871 implements OnPreDrawListener {
        final /* synthetic */ ViewGroup val$container;
        final /* synthetic */ ArrayList val$exitingViews;

        C01871(ViewGroup viewGroup, ArrayList arrayList) {
            this.val$container = viewGroup;
            this.val$exitingViews = arrayList;
        }

        public boolean onPreDraw() {
            this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
            FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
            return true;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransition.2 */
    static class C01882 implements OnPreDrawListener {
        final /* synthetic */ Object val$enterTransition;
        final /* synthetic */ ArrayList val$enteringViews;
        final /* synthetic */ Object val$exitTransition;
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ Fragment val$inFragment;
        final /* synthetic */ View val$nonExistentView;
        final /* synthetic */ ViewGroup val$sceneRoot;
        final /* synthetic */ ArrayList val$sharedElementsIn;

        C01882(ViewGroup viewGroup, Object obj, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.val$sceneRoot = viewGroup;
            this.val$enterTransition = obj;
            this.val$nonExistentView = view;
            this.val$inFragment = fragment;
            this.val$sharedElementsIn = arrayList;
            this.val$enteringViews = arrayList2;
            this.val$exitingViews = arrayList3;
            this.val$exitTransition = obj2;
        }

        public boolean onPreDraw() {
            this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.val$enterTransition != null) {
                FragmentTransitionCompat21.removeTarget(this.val$enterTransition, this.val$nonExistentView);
                this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
            }
            if (this.val$exitingViews != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.val$nonExistentView);
                FragmentTransitionCompat21.replaceTargets(this.val$exitTransition, this.val$exitingViews, arrayList);
                this.val$exitingViews.clear();
                this.val$exitingViews.add(this.val$nonExistentView);
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransition.3 */
    static class C01893 implements OnPreDrawListener {
        final /* synthetic */ Rect val$epicenter;
        final /* synthetic */ View val$epicenterView;
        final /* synthetic */ Fragment val$inFragment;
        final /* synthetic */ boolean val$inIsPop;
        final /* synthetic */ C0298a val$inSharedElements;
        final /* synthetic */ Fragment val$outFragment;
        final /* synthetic */ ViewGroup val$sceneRoot;

        C01893(ViewGroup viewGroup, Fragment fragment, Fragment fragment2, boolean z, C0298a c0298a, View view, Rect rect) {
            this.val$sceneRoot = viewGroup;
            this.val$inFragment = fragment;
            this.val$outFragment = fragment2;
            this.val$inIsPop = z;
            this.val$inSharedElements = c0298a;
            this.val$epicenterView = view;
            this.val$epicenter = rect;
        }

        public boolean onPreDraw() {
            this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
            if (this.val$epicenterView != null) {
                FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView, this.val$epicenter);
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTransition.4 */
    static class C01904 implements OnPreDrawListener {
        final /* synthetic */ Object val$enterTransition;
        final /* synthetic */ Object val$finalSharedElementTransition;
        final /* synthetic */ FragmentContainerTransition val$fragments;
        final /* synthetic */ Rect val$inEpicenter;
        final /* synthetic */ Fragment val$inFragment;
        final /* synthetic */ boolean val$inIsPop;
        final /* synthetic */ C0298a val$nameOverrides;
        final /* synthetic */ View val$nonExistentView;
        final /* synthetic */ Fragment val$outFragment;
        final /* synthetic */ ViewGroup val$sceneRoot;
        final /* synthetic */ ArrayList val$sharedElementsIn;
        final /* synthetic */ ArrayList val$sharedElementsOut;

        C01904(ViewGroup viewGroup, C0298a c0298a, Object obj, FragmentContainerTransition fragmentContainerTransition, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.val$sceneRoot = viewGroup;
            this.val$nameOverrides = c0298a;
            this.val$finalSharedElementTransition = obj;
            this.val$fragments = fragmentContainerTransition;
            this.val$sharedElementsIn = arrayList;
            this.val$nonExistentView = view;
            this.val$inFragment = fragment;
            this.val$outFragment = fragment2;
            this.val$inIsPop = z;
            this.val$sharedElementsOut = arrayList2;
            this.val$enterTransition = obj2;
            this.val$inEpicenter = rect;
        }

        public boolean onPreDraw() {
            this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            C0298a access$300 = FragmentTransition.captureInSharedElements(this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
            if (access$300 != null) {
                this.val$sharedElementsIn.addAll(access$300.values());
                this.val$sharedElementsIn.add(this.val$nonExistentView);
            }
            FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, access$300, false);
            if (this.val$finalSharedElementTransition != null) {
                FragmentTransitionCompat21.swapSharedElementTargets(this.val$finalSharedElementTransition, this.val$sharedElementsOut, this.val$sharedElementsIn);
                View access$400 = FragmentTransition.getInEpicenterView(access$300, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
                if (access$400 != null) {
                    FragmentTransitionCompat21.getBoundsOnScreen(access$400, this.val$inEpicenter);
                }
            }
            return true;
        }
    }

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    static {
        INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6};
    }

    FragmentTransition() {
    }

    private static void addToFirstInLastOut(BackStackRecord backStackRecord, Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        Fragment fragment = op.fragment;
        int i = fragment.mContainerId;
        if (i != 0) {
            int i2;
            int i3;
            FragmentContainerTransition ensureContainer;
            boolean z3;
            int i4;
            int i5;
            boolean z4;
            int i6;
            switch (z ? INVERSE_OPS[op.cmd] : op.cmd) {
                case GoogleMap.MAP_TYPE_NORMAL /*1*/:
                case C1096c.MapAttrs_uiCompass /*7*/:
                    z3 = z2 ? fragment.mIsNewlyAdded : (fragment.mAdded || fragment.mHidden) ? false : true;
                    i4 = 1;
                    i2 = 0;
                    i5 = 0;
                    z4 = z3;
                    break;
                case GoogleMap.MAP_TYPE_TERRAIN /*3*/:
                case C1096c.MapAttrs_liteMode /*6*/:
                    i6 = z2 ? (fragment.mAdded || fragment.mView == null || fragment.mView.getVisibility() != 0) ? 0 : 1 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                    i4 = 0;
                    i2 = i6;
                    i5 = 1;
                    i3 = 0;
                    break;
                case GoogleMap.MAP_TYPE_HYBRID /*4*/:
                    i6 = z2 ? (fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) ? 1 : 0 : (!fragment.mAdded || fragment.mHidden) ? 0 : 1;
                    i4 = 0;
                    i2 = i6;
                    i5 = 1;
                    i3 = 0;
                    break;
                case C1096c.MapAttrs_cameraZoom /*5*/:
                    z3 = z2 ? fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded : fragment.mHidden;
                    i4 = 1;
                    i2 = 0;
                    i5 = 0;
                    z4 = z3;
                    break;
                default:
                    i4 = 0;
                    i2 = 0;
                    i5 = 0;
                    i3 = 0;
                    break;
            }
            FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.get(i);
            if (i3 != 0) {
                ensureContainer = ensureContainer(fragmentContainerTransition, sparseArray, i);
                ensureContainer.lastIn = fragment;
                ensureContainer.lastInIsPop = z;
                ensureContainer.lastInTransaction = backStackRecord;
            } else {
                ensureContainer = fragmentContainerTransition;
            }
            if (!(z2 || r4 == 0)) {
                if (ensureContainer != null && ensureContainer.firstOut == fragment) {
                    ensureContainer.firstOut = null;
                }
                FragmentManagerImpl fragmentManagerImpl = backStackRecord.mManager;
                if (fragment.mState < 1 && fragmentManagerImpl.mCurState >= 1 && !backStackRecord.mAllowOptimization) {
                    fragmentManagerImpl.makeActive(fragment);
                    fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                }
            }
            if (i2 == 0 || !(ensureContainer == null || ensureContainer.firstOut == null)) {
                fragmentContainerTransition = ensureContainer;
            } else {
                fragmentContainerTransition = ensureContainer(ensureContainer, sparseArray, i);
                fragmentContainerTransition.firstOut = fragment;
                fragmentContainerTransition.firstOutIsPop = z;
                fragmentContainerTransition.firstOutTransaction = backStackRecord;
            }
            if (!z2 && r7 != 0 && fragmentContainerTransition != null && fragmentContainerTransition.lastIn == fragment) {
                fragmentContainerTransition.lastIn = null;
            }
        }
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, (Op) backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static C0298a<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        C0298a<String, String> c0298a = new C0298a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) c0298a.remove(str2);
                        if (str3 != null) {
                            c0298a.put(str, str3);
                        } else {
                            c0298a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0298a;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, (Op) backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    private static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, C0298a<String, View> c0298a, boolean z2) {
        int i = 0;
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = c0298a == null ? 0 : c0298a.size();
            while (i < size) {
                arrayList2.add(c0298a.m1002b(i));
                arrayList.add(c0298a.m1003c(i));
                i++;
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static C0298a<String, View> captureInSharedElements(C0298a<String, String> c0298a, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (c0298a.isEmpty() || obj == null || view == null) {
            c0298a.clear();
            return null;
        }
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        C0298a<String, View> c0298a2 = new C0298a();
        FragmentTransitionCompat21.findNamedViews(c0298a2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        SharedElementCallback exitTransitionCallback;
        if (fragmentContainerTransition.lastInIsPop) {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
            sharedElementCallback = exitTransitionCallback;
        } else {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
            sharedElementCallback = exitTransitionCallback;
        }
        c0298a2.m1006a(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, c0298a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                view = (View) c0298a2.get(str);
                if (view == null) {
                    str = findKeyForValue(c0298a, str);
                    if (str != null) {
                        c0298a.remove(str);
                    }
                } else if (!str.equals(aj.m1896s(view))) {
                    str = findKeyForValue(c0298a, str);
                    if (str != null) {
                        c0298a.put(str, aj.m1896s(view));
                    }
                }
            }
        } else {
            retainValues(c0298a, c0298a2);
        }
        return c0298a2;
    }

    private static C0298a<String, View> captureOutSharedElements(C0298a<String, String> c0298a, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        if (c0298a.isEmpty() || obj == null) {
            c0298a.clear();
            return null;
        }
        ArrayList arrayList;
        SharedElementCallback sharedElementCallback;
        Fragment fragment = fragmentContainerTransition.firstOut;
        C0298a<String, View> c0298a2 = new C0298a();
        FragmentTransitionCompat21.findNamedViews(c0298a2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        SharedElementCallback enterTransitionCallback;
        if (fragmentContainerTransition.firstOutIsPop) {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
            sharedElementCallback = enterTransitionCallback;
        } else {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
            sharedElementCallback = enterTransitionCallback;
        }
        c0298a2.m1006a(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, c0298a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) c0298a2.get(str);
                if (view == null) {
                    c0298a.remove(str);
                } else if (!str.equals(aj.m1896s(view))) {
                    c0298a.put(aj.m1896s(view), (String) c0298a.remove(str));
                }
            }
        } else {
            c0298a.m1006a(c0298a2.keySet());
        }
        return c0298a2;
    }

    private static ArrayList<View> configureEnteringExitingViews(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            FragmentTransitionCompat21.captureTransitioningViews(arrayList2, fragment.getView());
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                FragmentTransitionCompat21.addTargets(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    private static Object configureSharedElementsOptimized(ViewGroup viewGroup, View view, C0298a<String, String> c0298a, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        boolean z = fragmentContainerTransition.lastInIsPop;
        Object sharedElementTransition = c0298a.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        C0298a captureOutSharedElements = captureOutSharedElements(c0298a, sharedElementTransition, fragmentContainerTransition);
        C0298a captureInSharedElements = captureInSharedElements(c0298a, sharedElementTransition, fragmentContainerTransition);
        if (c0298a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(captureOutSharedElements.values());
            arrayList2.addAll(captureInSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        View inEpicenterView;
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList2.add(view);
            FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            rect = new Rect();
            inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
            if (inEpicenterView != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
            inEpicenterView = null;
        }
        viewGroup.getViewTreeObserver().addOnPreDrawListener(new C01893(viewGroup, fragment, fragment2, z, captureInSharedElements, inEpicenterView, rect));
        return obj3;
    }

    private static Object configureSharedElementsUnoptimized(ViewGroup viewGroup, View view, C0298a<String, String> c0298a, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        Object obj3;
        boolean z = fragmentContainerTransition.lastInIsPop;
        Object sharedElementTransition = c0298a.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        C0298a captureOutSharedElements = captureOutSharedElements(c0298a, sharedElementTransition, fragmentContainerTransition);
        if (c0298a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(captureOutSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            rect = new Rect();
            FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        viewGroup.getViewTreeObserver().addOnPreDrawListener(new C01904(viewGroup, c0298a, obj3, fragmentContainerTransition, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static void configureTransitionsOptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, C0298a<String, String> c0298a) {
        ViewGroup viewGroup = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i);
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            Object configureSharedElementsOptimized = configureSharedElementsOptimized(viewGroup, view, c0298a, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
            if (enterTransition != null || configureSharedElementsOptimized != null || exitTransition != null) {
                ArrayList configureEnteringExitingViews = configureEnteringExitingViews(exitTransition, fragment2, arrayList2, view);
                ArrayList configureEnteringExitingViews2 = configureEnteringExitingViews(enterTransition, fragment, arrayList, view);
                setViewVisibility(configureEnteringExitingViews2, 4);
                Object mergeTransitions = mergeTransitions(enterTransition, exitTransition, configureSharedElementsOptimized, fragment, z);
                if (mergeTransitions != null) {
                    replaceHide(exitTransition, fragment2, configureEnteringExitingViews);
                    ArrayList prepareSetNameOverridesOptimized = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(arrayList);
                    FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, exitTransition, configureEnteringExitingViews, configureSharedElementsOptimized, arrayList);
                    FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                    FragmentTransitionCompat21.setNameOverridesOptimized(viewGroup, arrayList2, arrayList, prepareSetNameOverridesOptimized, c0298a);
                    setViewVisibility(configureEnteringExitingViews2, 0);
                    FragmentTransitionCompat21.swapSharedElementTargets(configureSharedElementsOptimized, arrayList2, arrayList);
                }
            }
        }
    }

    private static void configureTransitionsUnoptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, C0298a<String, String> c0298a) {
        ViewGroup viewGroup = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i);
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object configureSharedElementsUnoptimized = configureSharedElementsUnoptimized(viewGroup, view, c0298a, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
            if (enterTransition != null || configureSharedElementsUnoptimized != null || exitTransition != null) {
                ArrayList configureEnteringExitingViews = configureEnteringExitingViews(exitTransition, fragment2, arrayList, view);
                Object obj = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : exitTransition;
                FragmentTransitionCompat21.addTarget(enterTransition, view);
                exitTransition = mergeTransitions(enterTransition, obj, configureSharedElementsUnoptimized, fragment, fragmentContainerTransition.lastInIsPop);
                if (exitTransition != null) {
                    ArrayList arrayList3 = new ArrayList();
                    FragmentTransitionCompat21.scheduleRemoveTargets(exitTransition, enterTransition, arrayList3, obj, configureEnteringExitingViews, configureSharedElementsUnoptimized, arrayList2);
                    scheduleTargetChange(viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj, configureEnteringExitingViews);
                    FragmentTransitionCompat21.setNameOverridesUnoptimized(viewGroup, arrayList2, c0298a);
                    FragmentTransitionCompat21.beginDelayedTransition(viewGroup, exitTransition);
                    FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList2, c0298a);
                }
            }
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        fragmentContainerTransition = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition);
        return fragmentContainerTransition;
    }

    private static String findKeyForValue(C0298a<String, String> c0298a, String str) {
        int size = c0298a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c0298a.m1003c(i))) {
                return (String) c0298a.m1002b(i);
            }
        }
        return null;
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static View getInEpicenterView(C0298a<String, View> c0298a, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) backStackRecord.mSharedElementSourceNames.get(0);
        } else {
            String str = (String) backStackRecord.mSharedElementTargetNames.get(0);
        }
        return (View) c0298a.get(obj2);
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object mergeTransitions(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return z2 ? FragmentTransitionCompat21.mergeTransitionsTogether(obj2, obj, obj3) : FragmentTransitionCompat21.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            ViewGroup viewGroup = fragment.mContainer;
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new C01871(viewGroup, arrayList));
        }
    }

    private static void retainValues(C0298a<String, String> c0298a, C0298a<String, View> c0298a2) {
        for (int size = c0298a.size() - 1; size >= 0; size--) {
            if (!c0298a2.containsKey((String) c0298a.m1003c(size))) {
                c0298a.m1004d(size);
            }
        }
    }

    private static void scheduleTargetChange(ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        viewGroup.getViewTreeObserver().addOnPreDrawListener(new C01882(viewGroup, obj, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void setOutEpicenter(Object obj, Object obj2, C0298a<String, View> c0298a, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                String str = (String) backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = (View) c0298a.get(obj3);
            FragmentTransitionCompat21.setEpicenter(obj, view);
            if (obj2 != null) {
                FragmentTransitionCompat21.setEpicenter(obj2, view);
            }
        }
    }

    private static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C0298a calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsOptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsUnoptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }
}
