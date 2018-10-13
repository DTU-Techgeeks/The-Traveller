package com.example.android.thetraveller.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.thetraveller.Models.OnBoardItem;
import com.example.android.thetraveller.R;

import java.util.ArrayList;

public class OnBoard_Adapter extends PagerAdapter {


    private Context context;

    public OnBoard_Adapter(Context context, ArrayList<OnBoardItem> onBoardItems) {
        this.context = context;
        this.onBoardItems = onBoardItems;
    }

    private ArrayList<OnBoardItem> onBoardItems = new ArrayList<>();

    @Override
    public int getCount() {
        return onBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View itemView  = LayoutInflater.from(context).inflate(R.layout.onboard_item,container,false);
        OnBoardItem onBoardItem = onBoardItems.get(position);

        ImageView imageView = itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(onBoardItem.getImageID());

        TextView tv_title=(TextView)itemView.findViewById(R.id.tv_header);
        tv_title.setText(onBoardItem.getTitle());

        TextView tv_content=(TextView)itemView.findViewById(R.id.tv_desc);
        tv_content.setText(onBoardItem.getDescription());

        container.addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
