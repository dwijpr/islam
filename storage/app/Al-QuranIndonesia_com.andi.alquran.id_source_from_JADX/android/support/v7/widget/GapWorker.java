package android.support.v7.widget;

import android.support.v4.p007e.C0270h;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker;
    static Comparator<Task> sTaskComparator;
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews;
    private ArrayList<Task> mTasks;

    /* renamed from: android.support.v7.widget.GapWorker.1 */
    static class C06701 implements Comparator<Task> {
        C06701() {
        }

        public int compare(Task task, Task task2) {
            int i = -1;
            if ((task.view == null ? 1 : 0) != (task2.view == null ? 1 : 0)) {
                return task.view == null ? 1 : -1;
            } else {
                if (task.immediate != task2.immediate) {
                    if (!task.immediate) {
                        i = 1;
                    }
                    return i;
                }
                int i2 = task2.viewVelocity - task.viewVelocity;
                if (i2 != 0) {
                    return i2;
                }
                i2 = task.distanceToItem - task2.distanceToItem;
                return i2 == 0 ? 0 : i2;
            }
        }
    }

    static class LayoutPrefetchRegistryImpl implements LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
        }

        public void addPosition(int i, int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.mCount * 2;
            if (this.mPrefetchArray == null) {
                this.mPrefetchArray = new int[4];
                Arrays.fill(this.mPrefetchArray, -1);
            } else if (i3 >= this.mPrefetchArray.length) {
                Object obj = this.mPrefetchArray;
                this.mPrefetchArray = new int[(i3 * 2)];
                System.arraycopy(obj, 0, this.mPrefetchArray, 0, obj.length);
            }
            this.mPrefetchArray[i3] = i;
            this.mPrefetchArray[i3 + 1] = i2;
            this.mCount++;
        }

        void clearPrefetchPositions() {
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
        }

        void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
            LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                if (this.mCount > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.mCount;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        boolean lastPrefetchIncludedPosition(int i) {
            if (this.mPrefetchArray == null) {
                return false;
            }
            int i2 = this.mCount * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.mPrefetchArray[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        void setPrefetchVector(int i, int i2) {
            this.mPrefetchDx = i;
            this.mPrefetchDy = i2;
        }
    }

    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    static {
        sGapWorker = new ThreadLocal();
        sTaskComparator = new C06701();
    }

    GapWorker() {
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    private void buildTaskList() {
        int size = this.mRecyclerViews.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.mRecyclerViews.get(i2);
            recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
            i += recyclerView.mPrefetchRegistry.mCount;
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            recyclerView = (RecyclerView) this.mRecyclerViews.get(i3);
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
            boolean z2 = z;
            for (i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                Task task;
                if (z2 >= this.mTasks.size()) {
                    task = new Task();
                    this.mTasks.add(task);
                } else {
                    task = (Task) this.mTasks.get(z2);
                }
                int i4 = layoutPrefetchRegistryImpl.mPrefetchArray[i + 1];
                task.immediate = i4 <= abs;
                task.viewVelocity = abs;
                task.distanceToItem = i4;
                task.view = recyclerView;
                task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i];
                z2++;
            }
            i3++;
            z = z2;
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task task, long j) {
        ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Long.MAX_VALUE : j);
        if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null) {
            prefetchInnerRecyclerViewWithDeadline((RecyclerView) prefetchPositionWithDeadline.mNestedRecyclerView.get(), j);
        }
    }

    private void flushTasksWithDeadline(long j) {
        int i = 0;
        while (i < this.mTasks.size()) {
            Task task = (Task) this.mTasks.get(i);
            if (task.view != null) {
                flushTaskWithDeadline(task, j);
                task.clear();
                i++;
            } else {
                return;
            }
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
            if (layoutPrefetchRegistryImpl.mCount != 0) {
                try {
                    C0270h.m913a("RV Nested Prefetch");
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                        prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i], j);
                    }
                } finally {
                    C0270h.m912a();
                }
            }
        }
    }

    private ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        if (isPrefetchPositionAttached(recyclerView, i)) {
            return null;
        }
        Recycler recycler = recyclerView.mRecycler;
        ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i, false, j);
        if (tryGetViewHolderForPositionByDeadline == null) {
            return tryGetViewHolderForPositionByDeadline;
        }
        if (tryGetViewHolderForPositionByDeadline.isBound()) {
            recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
            return tryGetViewHolderForPositionByDeadline;
        }
        recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
        return tryGetViewHolderForPositionByDeadline;
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i, i2);
    }

    void prefetch(long j) {
        buildTaskList();
        flushTasksWithDeadline(j);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    public void run() {
        try {
            C0270h.m913a("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                long toNanos = TimeUnit.MILLISECONDS.toNanos(((RecyclerView) this.mRecyclerViews.get(0)).getDrawingTime());
                if (toNanos == 0) {
                    this.mPostTimeNs = 0;
                    C0270h.m912a();
                    return;
                }
                prefetch(toNanos + this.mFrameIntervalNs);
                this.mPostTimeNs = 0;
                C0270h.m912a();
            }
        } finally {
            this.mPostTimeNs = 0;
            C0270h.m912a();
        }
    }
}
