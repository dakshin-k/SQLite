package com.dakshin.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Col4ListAdapter extends ArrayAdapter<Col4RowItem> {
    private ArrayList<Col4RowItem> dataSet;
    private Context mContext;
    private static class ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
    }
    public Col4ListAdapter(ArrayList<Col4RowItem> data, Context context) {
        super(context, R.layout.row_4_cols, data);
        this.dataSet = data;
        this.mContext=context;

    }
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Col4RowItem dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_4_cols, parent, false);
            viewHolder.tv1 = convertView.findViewById(R.id.col4_row1);
            viewHolder.tv2 = convertView.findViewById(R.id.col4_row2);
            viewHolder.tv3 = convertView.findViewById(R.id.col4_row3);
            viewHolder.tv4 = convertView.findViewById(R.id.col4_row4);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.tv1.setText(dataModel.getOne());
        viewHolder.tv2.setText(dataModel.getTwo());
        viewHolder.tv3.setText(dataModel.getThree());
        viewHolder.tv4.setText(dataModel.getFour());
        return convertView;
    }
}
