package com.dakshin.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class Col4CursorAdapter extends CursorAdapter{

    public Col4CursorAdapter(Context context, Cursor cursor) {
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.row_4_cols,viewGroup,false);
    }
    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tv1 = (TextView) view.findViewById(R.id.col4_row1);
        TextView tv2 = (TextView) view.findViewById(R.id.col4_row2);
        TextView tv3 = (TextView) view.findViewById(R.id.col4_row3);
        TextView tv4 = (TextView) view.findViewById(R.id.col4_row4);
        // Extract properties from cursor
        String one = cursor.getString(1);
        String two = cursor.getString(2);
        String three = cursor.getString(3);
        String four = cursor.getString(4);
        // Populate fields with extracted properties
        tv1.setText(one);
        tv2.setText(two);
        tv3.setText(three);
        tv4.setText(four);
    }
}
