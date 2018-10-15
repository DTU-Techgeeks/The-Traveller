package com.example.android.thetraveller.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import  com.example.android.thetraveller.Models.CurrencyName;
import com.example.android.thetraveller.R;
import com.example.android.thetraveller.Utils.CurrencyConverterGlobal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyConverterAdapter extends RecyclerView.Adapter<CurrencyConverterAdapter.ViewHolder> {

    private ArrayList<CurrencyName> mListCurencyNames;
    public Context context;

    public CurrencyConverterAdapter(Context context, ArrayList<CurrencyName> list) {
        this.context = context;
        this.mListCurencyNames = list;
        Log.d("my list size", "" + getCount());
    }

    public int getCount() {
        return mListCurencyNames.size();
    }

    public Object getItem(int position) {
        return mListCurencyNames.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_curency_converter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (android.os.Build.VERSION.SDK_INT >= 5.0) {
            holder.mShortTitle.setText(mListCurencyNames.get(position).shortName);
        } else {
            holder.mShortTitle.setText(mListCurencyNames.get(position).abrivation);
        }

        int mResId;
        if (android.os.Build.VERSION.SDK_INT >= 5.0) {
            mResId = context.getResources().getIdentifier(mListCurencyNames.get(position).abrivation.toLowerCase(),
                    "drawable", context.getPackageName());
        } else {
            mResId = context.getResources().getIdentifier(mListCurencyNames.get(position).shortName.toLowerCase(),
                    "drawable", context.getPackageName());
        }
        Log.d("Resouce resouce id", "" + mListCurencyNames.get(position).shortName);

        if (mResId == 0) {
            mResId = context.getResources().getIdentifier("tryk", "drawable", context.getPackageName());
            holder.mImageView.setImageResource(mResId);
        }
        holder.mImageView.setImageResource(mResId);

        holder.itemView.setOnClickListener(view -> {
            if (android.os.Build.VERSION.SDK_INT >= 5.0) {
                CurrencyConverterGlobal.global_image_id =
                        context.getResources().getIdentifier(
                                mListCurencyNames.get(position).abrivation.toLowerCase(),
                                "drawable", context.getPackageName());
                CurrencyConverterGlobal.global_country_name = mListCurencyNames.get(position).shortName;
                CurrencyConverterGlobal.country_id = mListCurencyNames.get(position).abrivation;

                if (CurrencyConverterGlobal.country_id.contains("TRY")) {
                    CurrencyConverterGlobal.global_image_id = context.getResources().getIdentifier("tryk",
                            "drawable", context.getPackageName());

                }
                if (CurrencyConverterGlobal.country_id.contains("TMM")) {
                    CurrencyConverterGlobal.global_image_id = context.getResources().getIdentifier("tryk",
                            "drawable", context.getPackageName());
                }
            } else {
                CurrencyConverterGlobal.global_image_id =
                        context.getResources().getIdentifier(
                                mListCurencyNames.get(position).shortName.toLowerCase(),
                                "drawable", context.getPackageName());
                CurrencyConverterGlobal.global_country_name = mListCurencyNames.get(position).abrivation;
                CurrencyConverterGlobal.country_id = mListCurencyNames.get(position).shortName;
                if (CurrencyConverterGlobal.country_id.contains("TRY")) {
                    CurrencyConverterGlobal.global_image_id = context.getResources().getIdentifier("tryk",
                            "drawable", context.getPackageName());
                }
                if (CurrencyConverterGlobal.country_id.contains("TMM")) {
                    CurrencyConverterGlobal.global_image_id = context.getResources().getIdentifier("tryk",
                            "drawable", context.getPackageName());
                }
            }
//           context.finish();
        });
    }

    @Override
    public int getItemCount() {
        return mListCurencyNames.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mShortTitle;
        @BindView(R.id.imageView)
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
