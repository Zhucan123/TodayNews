package com.example.zhucan.todaynews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhucan.todaynews.R;
import com.example.zhucan.todaynews.model.JokeModel;
import com.example.zhucan.todaynews.util.RandomUtil;
import com.example.zhucan.todaynews.util.StringConfig;

import java.util.List;

/**
 * Created by zhucan on 2017/4/17.
 */

public class JokeTextAdapter extends BaseAdapter {
    private List<JokeModel> list;
    private Context context;

    public JokeTextAdapter(Context context, List<JokeModel> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.headline_list_item, null);
            holder = new ViewHolder();
            holder.head = (ImageView) convertView.findViewById(R.id.headline_head);
            holder.nameText = (TextView) convertView.findViewById(R.id.headline_name);
            holder.textView = (TextView) convertView.findViewById(R.id.headline_time);
            holder.attention = (TextView) convertView.findViewById(R.id.attention);
            holder.news = (TextView) convertView.findViewById(R.id.headline_news);
            holder.read = (TextView) convertView.findViewById(R.id.headline_read);
            holder.goodCount = (TextView) convertView.findViewById(R.id.headline_goodCount);
            holder.comment = (TextView) convertView.findViewById(R.id.headline_comment);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getIconUrl()).fitCenter().into(((ImageView) convertView.findViewById(R.id.headline_head)));
        holder.nameText.setText(list.get(position).getUsername());
        holder.textView.setText(list.get(position).getCreateTime());
        holder.news.setText(list.get(position).getContent());
        holder.read.setText((RandomUtil.Ran(5000) + 3000) + "阅读");
        holder.goodCount.setText(list.get(position).getPraiseCount() + "赞");
        holder.comment.setText(list.get(position).getCommentCount() + "评论");


        return convertView;
    }

    public static class ViewHolder {
        public ImageView head;
        public TextView nameText;
        public TextView textView;
        public TextView attention;
        public TextView news;
        public TextView read;
        public TextView goodCount;
        public TextView comment;

    }
}
