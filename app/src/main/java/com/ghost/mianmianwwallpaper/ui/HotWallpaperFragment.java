package com.ghost.mianmianwwallpaper.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghost.mianmianwwallpaper.BaseRecyclerViewAdapter;
import com.ghost.mianmianwwallpaper.R;
import com.ghost.mianmianwwallpaper.commen.ContentDisplayManager;
import com.ghost.mianmianwwallpaper.configure.NetWorkConfig;
import com.ghost.mianmianwwallpaper.entity.ImageEntity;
import com.ghost.mianmianwwallpaper.interfaces.ImageListCallback;
import com.ghost.mianmianwwallpaper.interfaces.NetWorkErrorCallback;
import com.ghost.mianmianwwallpaper.model.ImageList;
import com.ghost.mianmianwwallpaper.model.ImageListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotWallpaperFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotWallpaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotWallpaperFragment extends Fragment  implements ContentDisplayManager.ContentViewAttachCallback,NetWorkErrorCallback{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ContentDisplayManager mContentDisplayManager;
    private List<ImageEntity.DataBean> dataBeanList;
    private OnFragmentInteractionListener mListener;

    public HotWallpaperFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotWallpaperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotWallpaperFragment newInstance(String param1, String param2) {
        HotWallpaperFragment fragment = new HotWallpaperFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                NetWorkConfig.gBaseUrl = "http://image.baidu.com/channel/listjson";
        mContentDisplayManager = new ContentDisplayManager(getActivity());
        mContentDisplayManager.setContentViewAttachCallback(this);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view  = inflater.inflate(R.layout.fragment_hot_wallpaper, container, false);
        mContentDisplayManager.attchContainer((ViewGroup) view.findViewById(R.id.fl_container));
        mContentDisplayManager.attchContent(view.findViewById(R.id.content_view));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageList imageList = new ImageList();
        imageList.setNetWorkErrorCallback(this);
        imageList.setmImageListCallback(new ImageListCallback() {
            @Override
            public void haveImageList(List<ImageEntity.DataBean> imageList) {
                dataBeanList = imageList;
                try {
                    mContentDisplayManager.displayContentView();
                }catch (Exception e){

                }

            }
        });
        mContentDisplayManager.displayLoadingView();
        imageList.getImageList("1","动漫","全部");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onContentViewAttach(View view) {
        RecyclerView recyclerView = (RecyclerView)view;
        final ImageListAdapter imageListAdapter = new ImageListAdapter(dataBeanList,R.layout.item_image,getActivity());
        imageListAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),ImageDetailsActivity.class);
                intent.putExtra("image_url",imageListAdapter.getmEntitys().get(position).getImage_url());
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = 8;
                outRect.right = 8;
                outRect.top = 8;
                outRect.bottom = 8;
            }
        });
        recyclerView.setAdapter(imageListAdapter);
    }

    @Override
    public void onNetQorkError() {
        mContentDisplayManager.displayErrorView();
    }
}
