package com.example.zhangyuanyuan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhangyuanyuan.R;
import com.example.zhangyuanyuan.bean.Bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RecviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Bean.ResultBean> list;

    public RecviewAdapter(Context context, ArrayList<Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view=View.inflate(context,R.layout.recview_item1,null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        }if (i==1){
            View view=View.inflate(context,R.layout.recview_item2,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        }if (i==2){
            View view=View.inflate(context,R.layout.recview_item3,null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        }else {
            View view=View.inflate(context,R.layout.recview_item4,null);
            ViewHolder4 holder4 = new ViewHolder4(view);
            return holder4;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int viewType = getItemViewType(i);
        if (viewType==0){
             ViewHolder1 holder1= (ViewHolder1) viewHolder;
            holder1.bam.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bean.ResultBean bnn= (Bean.ResultBean) path;
                    Glide.with(context).load(bnn.getThumbnail()).into(imageView);
                }
            }).start();
        }else if (viewType==1){
            ViewHolder2 holder2= (ViewHolder2) viewHolder;
            holder2.item2_tv1.setText(list.get(i).getName());
            holder2.item2_tv2.setText(list.get(i).getText());
            Glide.with(context).load(list.get(i).getHeader()).into(holder2.im);
        }else if (viewType==2){
            ViewHolder3 holder3= (ViewHolder3) viewHolder;
            holder3.item3_tv1.setText(list.get(i).getName());
            holder3.item3_tv2.setText(list.get(i).getText());
            Glide.with(context).load(list.get(i).getHeader()).into(holder3.item3_im1);
            Glide.with(context).load(list.get(i).getHeader()).into(holder3.item3_im2);
        }else {
            ViewHolder4 holder4= (ViewHolder4) viewHolder;
            holder4.item4_tv1.setText(list.get(i).getName());
            holder4.item4_tv2.setText(list.get(i).getText());
            Glide.with(context).load(list.get(i).getHeader()).into(holder4.item4_im1);
            Glide.with(context).load(list.get(i).getHeader()).into(holder4.item4_im2);
            Glide.with(context).load(list.get(i).getHeader()).into(holder4.item4_im3);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onclick(view,i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size()>0&&position==0){
            return 0;
        }else if (position%4==3){
            return 1;
        }else if (position%4==1){
            return 2;
        }else {
            return 3;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{

        private Banner bam;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            bam = itemView.findViewById(R.id.ban);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{

        private ImageView im;
        private TextView item2_tv1;
        private TextView item2_tv2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.item_im);
            item2_tv1 = itemView.findViewById(R.id.item_tv1);
            item2_tv2 = itemView.findViewById(R.id.item_tv2);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{

        private ImageView item3_im1;
        private ImageView item3_im2;
        private TextView item3_tv1;
        private TextView item3_tv2;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            item3_im1 = itemView.findViewById(R.id.item3_im1);
            item3_im2 = itemView.findViewById(R.id.item3_im2);
            item3_tv1 = itemView.findViewById(R.id.item3_tv1);
            item3_tv2= itemView.findViewById(R.id.item3_tv2);
        }
    }
    class ViewHolder4 extends RecyclerView.ViewHolder{

        private ImageView item4_im1;
        private ImageView item4_im2;
        private ImageView item4_im3;
        private TextView item4_tv1;
        private TextView item4_tv2;

        public ViewHolder4(@NonNull View itemView) {
            super(itemView);
            item4_im1 = itemView.findViewById(R.id.item4_im1);
            item4_im2 = itemView.findViewById(R.id.item4_im2);
            item4_im3 = itemView.findViewById(R.id.item4_im3);
            item4_tv1= itemView.findViewById(R.id.item4_tv1);
            item4_tv2 = itemView.findViewById(R.id.item4_tv2);
        }
    }

    private onclick click;

    public void setClick(onclick click) {
        this.click = click;
    }
    public interface onclick{
        void onclick(View view,int i);
    }
}
