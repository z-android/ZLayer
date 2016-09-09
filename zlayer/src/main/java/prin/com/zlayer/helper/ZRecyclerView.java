package prin.com.zlayer.helper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by prin on 2016/4/12.
 * 扩展的RecyclerView
 * （1）实现设置EmptyView
 */
public class ZRecyclerView<T> extends RecyclerView {

    public View mEmptyView;

    public ZRecyclerView(Context context) {
        super(context);
    }

    public ZRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void checkIfEmpty(){
        if (mEmptyView!=null){
            mEmptyView.setVisibility(getAdapter().getItemCount()>0?GONE:VISIBLE);
        }
    }

    /**
     * 观察adapter的变化
     */
    final AdapterDataObserver observer=new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }
    };

    @Override
    public void swapAdapter(Adapter adapter, boolean removeAndRecycleExistingViews) {
        final Adapter oldAdapter=getAdapter();
        if (oldAdapter!=null){
            adapter.unregisterAdapterDataObserver(observer);
        }
        if (adapter!=null){
            adapter.registerAdapterDataObserver(observer);
        }
        super.swapAdapter(adapter, removeAndRecycleExistingViews);
        checkIfEmpty();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter=getAdapter();
        if (oldAdapter!=null){
            oldAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter!=null){
            adapter.registerAdapterDataObserver(observer);
        }
    }

    /**
     * 设置EmptyView
     */
    public void setEmptyView(View emptyView){
        this.mEmptyView=emptyView;
        checkIfEmpty();
    }




}
