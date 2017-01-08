package com.example.ronakshah.hackforchange;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ReminderAdapter extends ArrayAdapter<RemindInfo> {
    private Context mContext;
    View listItemView;
    ListView listView;
    private ArrayList<RemindInfo> temporary;
    public ReminderAdapter(Activity context, ArrayList<RemindInfo> mainInfos, int resource,ListView listView) {
        super(context,resource, mainInfos);
        temporary=mainInfos;
        mContext = context;
        this.listView=listView;
    }
    @Override
    public int getCount() {return super.getCount();}
    @Override
    public RemindInfo getItem(int position) {
        return super.getItem(position);
    }
    @Override
    public int getPosition(RemindInfo item) {
        return super.getPosition(item);
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        listItemView = convertView;

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.remind_listitem, parent, false);

        final RemindInfo mainInfo = getItem(position);

        TextView tv1 = (TextView) listItemView.findViewById(R.id.name);    tv1.setText(mainInfo.getName());
        TextView tv2 = (TextView) listItemView.findViewById(R.id.description);   tv2.setText(mainInfo.getDescription());
        TextView tv3 = (TextView) listItemView.findViewById(R.id.time); tv3.setText(mainInfo.getTime());
        TextView tv4 = (TextView) listItemView.findViewById(R.id.interval); tv4.setText(mainInfo.getInterval());
        listItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Do you want to delete subject " + mainInfo.getName() + "?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
/*
                        deleteSubject(mainInfo.getmName());
                        temporary.remove(temporary.get(position));
                        notifyDataSetChanged();
*/
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });

        return listItemView;
    }
}
