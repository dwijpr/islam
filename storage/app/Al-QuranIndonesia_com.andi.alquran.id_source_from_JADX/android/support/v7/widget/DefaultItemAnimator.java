package android.support.v7.widget;

import android.support.v4.p008a.C0158a;
import android.support.v4.view.aj;
import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    ArrayList<ViewHolder> mAddAnimations;
    ArrayList<ArrayList<ViewHolder>> mAdditionsList;
    ArrayList<ViewHolder> mChangeAnimations;
    ArrayList<ArrayList<ChangeInfo>> mChangesList;
    ArrayList<ViewHolder> mMoveAnimations;
    ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<ViewHolder> mPendingRemovals;
    ArrayList<ViewHolder> mRemoveAnimations;

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.1 */
    class C06601 implements Runnable {
        final /* synthetic */ ArrayList val$moves;

        C06601(ArrayList arrayList) {
            this.val$moves = arrayList;
        }

        public void run() {
            Iterator it = this.val$moves.iterator();
            while (it.hasNext()) {
                MoveInfo moveInfo = (MoveInfo) it.next();
                DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
            }
            this.val$moves.clear();
            DefaultItemAnimator.this.mMovesList.remove(this.val$moves);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.2 */
    class C06612 implements Runnable {
        final /* synthetic */ ArrayList val$changes;

        C06612(ArrayList arrayList) {
            this.val$changes = arrayList;
        }

        public void run() {
            Iterator it = this.val$changes.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
            }
            this.val$changes.clear();
            DefaultItemAnimator.this.mChangesList.remove(this.val$changes);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.3 */
    class C06623 implements Runnable {
        final /* synthetic */ ArrayList val$additions;

        C06623(ArrayList arrayList) {
            this.val$additions = arrayList;
        }

        public void run() {
            Iterator it = this.val$additions.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateAddImpl((ViewHolder) it.next());
            }
            this.val$additions.clear();
            DefaultItemAnimator.this.mAdditionsList.remove(this.val$additions);
        }
    }

    private static class VpaListenerAdapter implements bc {
        VpaListenerAdapter() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.4 */
    class C06634 extends VpaListenerAdapter {
        final /* synthetic */ ay val$animation;
        final /* synthetic */ ViewHolder val$holder;

        C06634(ViewHolder viewHolder, ay ayVar) {
            this.val$holder = viewHolder;
            this.val$animation = ayVar;
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2063a(null);
            aj.m1875c(view, 1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.val$holder);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.5 */
    class C06645 extends VpaListenerAdapter {
        final /* synthetic */ ay val$animation;
        final /* synthetic */ ViewHolder val$holder;

        C06645(ViewHolder viewHolder, ay ayVar) {
            this.val$holder = viewHolder;
            this.val$animation = ayVar;
        }

        public void onAnimationCancel(View view) {
            aj.m1875c(view, 1.0f);
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2063a(null);
            DefaultItemAnimator.this.dispatchAddFinished(this.val$holder);
            DefaultItemAnimator.this.mAddAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchAddStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.6 */
    class C06656 extends VpaListenerAdapter {
        final /* synthetic */ ay val$animation;
        final /* synthetic */ int val$deltaX;
        final /* synthetic */ int val$deltaY;
        final /* synthetic */ ViewHolder val$holder;

        C06656(ViewHolder viewHolder, int i, int i2, ay ayVar) {
            this.val$holder = viewHolder;
            this.val$deltaX = i;
            this.val$deltaY = i2;
            this.val$animation = ayVar;
        }

        public void onAnimationCancel(View view) {
            if (this.val$deltaX != 0) {
                aj.m1854a(view, 0.0f);
            }
            if (this.val$deltaY != 0) {
                aj.m1870b(view, 0.0f);
            }
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2063a(null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.val$holder);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.7 */
    class C06667 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ ay val$oldViewAnim;

        C06667(ChangeInfo changeInfo, ay ayVar) {
            this.val$changeInfo = changeInfo;
            this.val$oldViewAnim = ayVar;
        }

        public void onAnimationEnd(View view) {
            this.val$oldViewAnim.m2063a(null);
            aj.m1875c(view, 1.0f);
            aj.m1854a(view, 0.0f);
            aj.m1870b(view, 0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.8 */
    class C06678 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ View val$newView;
        final /* synthetic */ ay val$newViewAnimation;

        C06678(ChangeInfo changeInfo, ay ayVar, View view) {
            this.val$changeInfo = changeInfo;
            this.val$newViewAnimation = ayVar;
            this.val$newView = view;
        }

        public void onAnimationEnd(View view) {
            this.val$newViewAnimation.m2063a(null);
            aj.m1875c(this.val$newView, 1.0f);
            aj.m1854a(this.val$newView, 0.0f);
            aj.m1870b(this.val$newView, 0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.newHolder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public ViewHolder newHolder;
        public ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.holder = viewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    public DefaultItemAnimator() {
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    private void animateRemoveImpl(ViewHolder viewHolder) {
        ay q = aj.m1894q(viewHolder.itemView);
        this.mRemoveAnimations.add(viewHolder);
        q.m2062a(getRemoveDuration()).m2061a(0.0f).m2063a(new C06634(viewHolder, q)).m2070c();
    }

    private void endChangeAnimation(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        aj.m1875c(viewHolder.itemView, 1.0f);
        aj.m1854a(viewHolder.itemView, 0.0f);
        aj.m1870b(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    private void resetAnimation(ViewHolder viewHolder) {
        C0158a.m690a(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    public boolean animateAdd(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        aj.m1875c(viewHolder.itemView, 0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    void animateAddImpl(ViewHolder viewHolder) {
        ay q = aj.m1894q(viewHolder.itemView);
        this.mAddAnimations.add(viewHolder);
        q.m2061a(1.0f).m2062a(getAddDuration()).m2063a(new C06645(viewHolder, q)).m2070c();
    }

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float l = aj.m1889l(viewHolder.itemView);
        float m = aj.m1890m(viewHolder.itemView);
        float e = aj.m1881e(viewHolder.itemView);
        resetAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - l);
        int i6 = (int) (((float) (i4 - i2)) - m);
        aj.m1854a(viewHolder.itemView, l);
        aj.m1870b(viewHolder.itemView, m);
        aj.m1875c(viewHolder.itemView, e);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            aj.m1854a(viewHolder2.itemView, (float) (-i5));
            aj.m1870b(viewHolder2.itemView, (float) (-i6));
            aj.m1875c(viewHolder2.itemView, 0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    void animateChangeImpl(ChangeInfo changeInfo) {
        View view = null;
        ViewHolder viewHolder = changeInfo.oldHolder;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            ay a = aj.m1894q(view2).m2062a(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            a.m2066b((float) (changeInfo.toX - changeInfo.fromX));
            a.m2069c((float) (changeInfo.toY - changeInfo.fromY));
            a.m2061a(0.0f).m2063a(new C06667(changeInfo, a)).m2070c();
        }
        if (view != null) {
            a = aj.m1894q(view);
            this.mChangeAnimations.add(changeInfo.newHolder);
            a.m2066b(0.0f).m2069c(0.0f).m2062a(getChangeDuration()).m2061a(1.0f).m2063a(new C06678(changeInfo, a, view)).m2070c();
        }
    }

    public boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int l = (int) (((float) i) + aj.m1889l(viewHolder.itemView));
        int m = (int) (((float) i2) + aj.m1890m(viewHolder.itemView));
        resetAnimation(viewHolder);
        int i5 = i3 - l;
        int i6 = i4 - m;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            aj.m1854a(view, (float) (-i5));
        }
        if (i6 != 0) {
            aj.m1870b(view, (float) (-i6));
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, l, m, i3, i4));
        return true;
    }

    void animateMoveImpl(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            aj.m1894q(view).m2066b(0.0f);
        }
        if (i6 != 0) {
            aj.m1894q(view).m2069c(0.0f);
        }
        ay q = aj.m1894q(view);
        this.mMoveAnimations.add(viewHolder);
        q.m2062a(getMoveDuration()).m2063a(new C06656(viewHolder, i5, i6, q)).m2070c();
    }

    public boolean animateRemove(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    void cancelAll(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            aj.m1894q(((ViewHolder) list.get(size)).itemView).m2068b();
        }
    }

    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimation(ViewHolder viewHolder) {
        int size;
        View view = viewHolder.itemView;
        aj.m1894q(view).m2068b();
        for (size = this.mPendingMoves.size() - 1; size >= 0; size--) {
            if (((MoveInfo) this.mPendingMoves.get(size)).holder == viewHolder) {
                aj.m1870b(view, 0.0f);
                aj.m1854a(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            aj.m1875c(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            aj.m1875c(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (size = this.mChangesList.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.mChangesList.get(size);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size);
            }
        }
        for (int size2 = this.mMovesList.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.mMovesList.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((MoveInfo) arrayList.get(size3)).holder == viewHolder) {
                    aj.m1870b(view, 0.0f);
                    aj.m1854a(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.mAdditionsList.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.mAdditionsList.get(size);
            if (arrayList.remove(viewHolder)) {
                aj.m1875c(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList.isEmpty()) {
                    this.mAdditionsList.remove(size);
                }
            }
        }
        if (this.mRemoveAnimations.remove(viewHolder)) {
        }
        if (this.mAddAnimations.remove(viewHolder)) {
        }
        if (this.mChangeAnimations.remove(viewHolder)) {
        }
        if (this.mMoveAnimations.remove(viewHolder)) {
            dispatchFinishedWhenDone();
        } else {
            dispatchFinishedWhenDone();
        }
    }

    public void endAnimations() {
        int size;
        for (size = this.mPendingMoves.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = (MoveInfo) this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            aj.m1870b(view, 0.0f);
            aj.m1854a(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (size = this.mPendingRemovals.size() - 1; size >= 0; size--) {
            dispatchRemoveFinished((ViewHolder) this.mPendingRemovals.get(size));
            this.mPendingRemovals.remove(size);
        }
        for (size = this.mPendingAdditions.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.mPendingAdditions.get(size);
            aj.m1875c(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size);
        }
        for (size = this.mPendingChanges.size() - 1; size >= 0; size--) {
            endChangeAnimationIfNecessary((ChangeInfo) this.mPendingChanges.get(size));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.mMovesList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mMovesList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size3);
                    View view2 = moveInfo2.holder.itemView;
                    aj.m1870b(view2, 0.0f);
                    aj.m1854a(view2, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (size2 = this.mAdditionsList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mAdditionsList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size3);
                    aj.m1875c(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mAdditionsList.remove(arrayList);
                    }
                }
            }
            for (size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mChangesList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    endChangeAnimationIfNecessary((ChangeInfo) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.mChangesList.remove(arrayList);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        int i = !this.mPendingRemovals.isEmpty() ? 1 : 0;
        int i2 = !this.mPendingMoves.isEmpty() ? 1 : 0;
        int i3 = !this.mPendingChanges.isEmpty() ? 1 : 0;
        int i4 = !this.mPendingAdditions.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c06601;
            Iterator it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl((ViewHolder) it.next());
            }
            this.mPendingRemovals.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                c06601 = new C06601(arrayList);
                if (i != 0) {
                    aj.m1865a(((MoveInfo) arrayList.get(0)).holder.itemView, c06601, getRemoveDuration());
                } else {
                    c06601.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList);
                this.mPendingChanges.clear();
                c06601 = new C06612(arrayList);
                if (i != 0) {
                    aj.m1865a(((ChangeInfo) arrayList.get(0)).oldHolder.itemView, c06601, getRemoveDuration());
                } else {
                    c06601.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList2);
                this.mPendingAdditions.clear();
                Runnable c06623 = new C06623(arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c06623.run();
                } else {
                    aj.m1865a(((ViewHolder) arrayList2.get(0)).itemView, c06623, (i != 0 ? getRemoveDuration() : 0) + Math.max(i2 != 0 ? getMoveDuration() : 0, i3 != 0 ? getChangeDuration() : 0));
                }
            }
        }
    }
}
