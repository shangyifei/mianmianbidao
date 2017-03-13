package com.ghost.mianmianwwallpaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
/**
 * Created by hello on 2017/3/11.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<T> mEntitys;
    private int mResId;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    public BaseRecyclerViewAdapter(List<T> mEntitys, int mResId, Context mContext) {
        this.mEntitys = mEntitys;
        this.mResId = mResId;
        this.mContext = mContext;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final BaseViewHolder baseViewHolder = new BaseViewHolder(LayoutInflater.from(mContext).inflate(mResId,parent,false));
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(v,baseViewHolder.getLayoutPosition());
                }
            }
        });
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder,mEntitys.get(position));
    }

    @Override
    public int getItemCount() {
        return mEntitys.size();
    }
    abstract protected void convert(BaseViewHolder holder,T entity);

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }

    public List<T> getmEntitys() {
        return mEntitys;
    }
}
