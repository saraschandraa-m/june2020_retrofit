package com.nextstacks.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private ArrayList<Article> articles;

    public NewsAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(context).inflate(R.layout.cell_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Article data = articles.get(position);

        holder.mTvNewsTitle.setText(data.title);
        holder.mTvNewsDescription.setText(data.description);



        Glide.with(context).load(data.urlToImage).into(holder.mIvNewsImg);

//        Picasso.get().load(data.urlToImage).into(holder.mIvNewsImg);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        private ImageView mIvNewsImg;
        private TextView mTvNewsTitle;
        private TextView mTvNewsDescription;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            mIvNewsImg = itemView.findViewById(R.id.iv_news_image);
            mTvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            mTvNewsDescription = itemView.findViewById(R.id.tv_news_desc);
        }
    }
}
