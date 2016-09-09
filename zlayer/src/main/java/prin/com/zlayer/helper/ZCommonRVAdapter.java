package prin.com.zlayer.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prin on 2016/4/13.
 * RecyclerView通用的adapter
 * （1）简单的无加载更多的信息直接显示
 * （2）添加数据 活动数据  删除数据更新
 */
public abstract class ZCommonRVAdapter<T> extends RecyclerView.Adapter<ZViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private OnGItemClickListener onGItemClickListener;
    public static final int IS_NORMAL = 1;  //只有内容
    public static final int IS_HEADER = 2;  //只有header
    public static final int IS_BOTTOM = 3;  //只有botton
    public static final int IS_FULL = 4;    //全部都有

    public ZCommonRVAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ZViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ZViewHolder gViewHolder = ZViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, gViewHolder, viewType);
        return gViewHolder;
    }

    @Override
    public void onBindViewHolder(ZViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(ZViewHolder gViewHolder, T t);

    public void convert(ZViewHolder gViewHolder, T t, int position) {
        convert(gViewHolder, t);
    }

    @Override
    public int getItemCount() {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
            return 0;
        }
        return mDatas.size();
    }

    /**
     * 添加数据
     */
    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 获得数据
     */
    public List<T> getAll() {
        return mDatas;
    }

    /**
     * 增加一行数据
     */
    public void addItem(int position, T data) {
        mDatas.add(data);
        notifyItemInserted(position);
    }

    /**
     * 删除一行数据
     */
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 清空数据
     */
    public void clear() {
        if (mDatas != null) {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 获得position
     */
    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    /**
     * 控制是否设置点击
     */
    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * 设置item点击
     */
    protected void setListener(final ViewGroup parent, final ZViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onGItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    onGItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                }
            }
        });
    }

    /**
     * 设置RV的item点击监听
     *
     * @param onGItemClickListener
     */
    public void setOnGItemClickListener(OnGItemClickListener onGItemClickListener) {
        this.onGItemClickListener = onGItemClickListener;
    }

    public interface OnGItemClickListener<T> {
        void onItemClick(ViewGroup parent, View view, T data, int position);
    }
}
