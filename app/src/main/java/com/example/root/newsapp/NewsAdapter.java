package com.example.root.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 5/1/18.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    NewsAdapter(@NonNull Context context, ArrayList<News> news) {
        super(context, 0,news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);

        final News news = getItem(position);
        assert news != null;

        TextView titleTextView = convertView.findViewById(R.id.title);
        titleTextView.setText(news.getTitle());

        TextView authorTextView = convertView.findViewById(R.id.author);
        authorTextView.setText(news.getAuthor());

        TextView dateTextView = convertView.findViewById(R.id.date);
        dateTextView.setText(news.getDate());

        TextView sectionTextView = convertView.findViewById(R.id.section);
        sectionTextView.setText(news.getSection());

        return convertView;
    }
}
