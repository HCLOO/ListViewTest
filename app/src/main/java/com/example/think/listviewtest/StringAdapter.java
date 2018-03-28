package com.example.think.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Think on 2018/3/19.
 */

public class StringAdapter extends ArrayAdapter<DataType>{

    int resourceID;

    public StringAdapter(@NonNull Context context, int resource, @NonNull List<DataType> objects) {
        super(context, resource, objects);

        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      DataType data=getItem(position);
      View view;
      ViewHolder holder;
      if(convertView==null) {
          view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
          holder=new ViewHolder(view);
          view.setTag(holder);
      } else {

          view=convertView;
          holder=(ViewHolder)view.getTag();
      }
      holder.text.setText(data.getName());
      return view;
    }

    class ViewHolder {
        TextView text;
        public ViewHolder(View view) {
            text=(TextView)view.findViewById(R.id.textView);
        }
    }
}
