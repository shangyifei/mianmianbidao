package com.ghost.mianmianwwallpaper.commen;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghost.mianmianwwallpaper.BaseErrorView;
import com.ghost.mianmianwwallpaper.BaseLoadingView;
import com.ghost.mianmianwwallpaper.R;
/**
 * Created by hello on 2017/3/11.
 */

public class ContentDisplayManager {
    static int CONTENT_VIEW_ID = R.id.content_view;
    static int LOADING_VIEW_ID = R.id.content_view;
    View mContentView;
    View mLoadingView;
    View mErrorView;
    ViewGroup mContainerView;
    Context mContext;
    private ContentViewAttachCallback mContentViewAttachCallback;
    private CreateContentViewCallback mCreateContentViewCallback;

    public ContentDisplayManager(Context context) {
        this.mContext = context;
    }

    public void attchContainer(ViewGroup containerView){
        mContainerView = containerView;
    }
    public void attchContent(View view){
        this.mContentView = view;
    }

    public void displayContentView()throws Exception{
        mContainerView.removeAllViews();
//        mContentView = mContainerView.findViewById(R.id.content_view);
        mContainerView.addView(mContentView);
        if (mContentView==null){
            if (mCreateContentViewCallback == null){
                throw new Exception("please create content view");
            }
            LayoutInflater.from(mContext).inflate(mCreateContentViewCallback.onCreateContentView(),mContainerView);
        }

        mContentViewAttachCallback.onContentViewAttach(mContentView);

    }
    public void displayLoadingView(){
        mContainerView.removeAllViews();
        mLoadingView = new BaseLoadingView(mContext);
        mLoadingView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mContainerView.addView(mLoadingView);
    }
    public void displayErrorView(){
        mContainerView.removeAllViews();
        mErrorView = new BaseErrorView(mContext);
        mErrorView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mContainerView.addView(mErrorView);
    }
    public interface ContentViewAttachCallback{
        void onContentViewAttach(View view);
    }
    public interface CreateContentViewCallback{
        int onCreateContentView();
    }

    public void setContentViewAttachCallback(ContentViewAttachCallback mContentViewAttachCallback) {
        this.mContentViewAttachCallback = mContentViewAttachCallback;
    }

    public void setCreateContentViewCallback(CreateContentViewCallback mCreateContentViewCallback) {
        this.mCreateContentViewCallback = mCreateContentViewCallback;
    }
}
