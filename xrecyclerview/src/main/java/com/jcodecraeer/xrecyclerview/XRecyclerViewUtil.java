package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


/**
 * Created by sunrain
 * Created Date 2020/6/10 12:05 AM
 */
public class XRecyclerViewUtil {
    public static final int LIST_V=10;
    public static final int LIST_H=11;
    public static final int FLOW_V=20;
    public static final int FLOW_H=21;
    public static final int GRID=30;
    public static void setDefaultXRecycleViewTheme(Context context, XRecyclerView recyclerView, int type) {
        setBaseInfo(context,recyclerView);
        RecyclerView.LayoutManager layoutManager=null;
        switch (type){
            case LIST_H://列表（横向）
                layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
                break;
            case FLOW_H://瀑布流（横向）
                layoutManager=new StaggeredGridLayoutManager(3,RecyclerView.HORIZONTAL);
                break;
            case FLOW_V://瀑布流（纵向）
                layoutManager=new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL);
                break;
            case GRID://网格布局
                layoutManager=  new GridLayoutManager(context,2);
                break;
            case LIST_V://列表（纵向）
            default:
                layoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
                break;
        }
        recyclerView.setLayoutManager(layoutManager);
    }
    private static void setBaseInfo(Context context, XRecyclerView recyclerView){
        recyclerView.setPullRefreshEnabled(false);//设置上啦刷新
        recyclerView.setLoadingMoreEnabled(false);//设置下拉加载更多
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotateMultiple);//设置刷新时效果
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);//设置加载时效果
        ArrowRefreshHeader arrowRefreshHeader = new ArrowRefreshHeader(context);
        arrowRefreshHeader.setRefreshTimeVisible(true);
        recyclerView.setRefreshHeader(arrowRefreshHeader);//设置刷新时上次刷新时间
        recyclerView.setFootViewText("加载中...","没有数据了T_T");//设置加载时数据
    }
    public static void setDefaultXRecycleViewTheme(Context context, XRecyclerView recyclerView, int type, int column) {
        setBaseInfo(context,recyclerView);
        RecyclerView.LayoutManager layoutManager=null;
        switch (type){
            case LIST_H://列表（横向）
                layoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
                break;
            case FLOW_H://瀑布流（横向）
                layoutManager=new StaggeredGridLayoutManager(column,RecyclerView.HORIZONTAL);
                break;
            case FLOW_V://瀑布流（纵向）
                layoutManager=new StaggeredGridLayoutManager(column,RecyclerView.VERTICAL);
                break;
            case GRID://网格布局
                layoutManager=  new GridLayoutManager(context,column);
                break;
            case LIST_V://列表（纵向）
            default:
                layoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
                break;
        }
        recyclerView.setLayoutManager(layoutManager);
    }
}
