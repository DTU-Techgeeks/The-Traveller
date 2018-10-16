package com.example.android.thetraveller;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.thetraveller.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Activity activity;
    List<com.example.android.thetraveller.UserModel> users;
    LayoutInflater inflater;

    public CustomAdapter(Activity activity) {
        this.activity = activity;
    }

    public CustomAdapter(Activity activity, List<com.example.android.thetraveller.UserModel> users) {
        this.activity = activity;
        this.users = users;
        inflater=activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder=null;
       if(view==null)
       {
           view=inflater.inflate(R.layout.list_view_item,viewGroup,false);
           holder=new ViewHolder();
           holder.tvuserName=view.findViewById(R.id.tv_user_name);
           holder.ivCheckBox=view.findViewById(R.id.iv_check_box);

           view.setTag(holder);
       }else
           holder=(ViewHolder) view.getTag();

       com.example.android.thetraveller.UserModel model=users.get(i);

       holder.tvuserName.setText(model.getUsername());
       if(model.isSelected)
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);
       else if(!model.isSelected)
           holder.ivCheckBox.setBackgroundResource(R.drawable.unchecked);
       else
           holder.ivCheckBox.setBackgroundResource(R.drawable.ic_date_range_black_24dp);


       return view;
    }
//    public void remove(ListView lv,int position)
//    {
//       int size=lv.getCount()-1;
//        this.notifyDataSetChanged();
//    }
public void updateRecords(List<com.example.android.thetraveller.UserModel> users)
{
    this.users=users;
    notifyDataSetChanged();
}
    class ViewHolder
    {
        TextView tvuserName;
        ImageView ivCheckBox;

    }
}
