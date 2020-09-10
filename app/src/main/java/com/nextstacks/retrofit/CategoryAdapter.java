package com.nextstacks.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private String[] titles;
    private CategoryClickListener listener;

    private int selectedPostion;

    public CategoryAdapter(Context context) {
        this.context = context;
        titles = context.getResources().getStringArray(R.array.news_category);
    }

    public void setListener(CategoryClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {


        String categoryName = titles[position];

        holder.mTvCategoryName.setText(categoryName);

        holder.mRlRoot.setOnClickListener(view -> {
            if (listener != null) {
                listener.onCategoryClicked(categoryName);
                selectedPostion = position;
                notifyDataSetChanged();
            }
        });

        if (position == selectedPostion) {
            holder.mRlRoot.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.bg_category_selected, null));
            holder.mTvCategoryName.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorPrimary, null));
        } else {
            holder.mRlRoot.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.bg_category_unselected, null));
            holder.mTvCategoryName.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorgrey, null));
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout mRlRoot;
        private TextView mTvCategoryName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            mRlRoot = itemView.findViewById(R.id.rl_root_category);
            mTvCategoryName = itemView.findViewById(R.id.tv_category);
        }
    }

    public interface CategoryClickListener {
        void onCategoryClicked(String categoryname);
    }
}
