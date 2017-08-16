package com.oz.edu.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc-2 on 2017-08-09.
 */

class ChatAdapter extends BaseAdapter{
    Context context;
    int customlist;
    ArrayList<ChatVO> chatList;
    LayoutInflater lif;
    String id;

    public ChatAdapter(Context applicationContext, int customlist, ArrayList<ChatVO> chatList, String id) {
        this.context= applicationContext;
        this.customlist = customlist;
        this.chatList= chatList;
        this.lif=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.id = id;

    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = lif.inflate(customlist, parent, false);
        }

        ImageView img = (ImageView)convertView.findViewById(R.id.iv_profile);
        TextView tv = (TextView)convertView.findViewById(R.id.tv_name);
        TextView tv2 = (TextView)convertView.findViewById(R.id.tv_content);
        TextView tv3 = (TextView)convertView.findViewById(R.id.tv_time);

        TextView tv_myTime=(TextView)convertView.findViewById(R.id.tv_mytime);
        TextView tv_myMsg=(TextView)convertView.findViewById(R.id.tv_mymsg);

        if(chatList.get(position).getName().equals(id)){
            img.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
            tv2.setVisibility(View.GONE);
            tv3.setVisibility(View.GONE);

            tv_myMsg.setVisibility(View.VISIBLE);
            tv_myTime.setVisibility(View.VISIBLE);

            tv_myMsg.setText(chatList.get(position).getMsg());
            tv_myTime.setText(chatList.get(position).getTime());
        }else{
            img.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.VISIBLE);
            tv3.setVisibility(View.VISIBLE);

            tv_myMsg.setVisibility(View.GONE);
            tv_myTime.setVisibility(View.GONE);


            img.setImageResource(chatList.get(position).getImgID());
            tv.setText(chatList.get(position).getName());
            tv2.setText(chatList.get(position).getMsg());
            tv3.setText(chatList.get(position).getTime());

        }




        return convertView;
    }
}
