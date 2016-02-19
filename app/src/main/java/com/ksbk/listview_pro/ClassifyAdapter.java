package com.ksbk.listview_pro;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by KSBK on 2016/2/19 0019.
 */
public class ClassifyAdapter extends BaseAdapter {

    private ArrayList<AbstractItem> mDatas;
    private Context context;

    public ClassifyAdapter(ArrayList<AbstractItem> datas,Context context) {
        mDatas = datas;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        // 异常情况处理
        if (null == mDatas || position <  0|| position > getCount()) {
            return true;
        }

        AbstractItem item = mDatas.get(position);
        if (!item.canClick()) {
            return false;
        }

        return true;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        // 异常情况处理
        if (null == mDatas || position <  0|| position > getCount()) {
            return AbstractItem.TYPE_NORMAL_ITEM;
        }

        AbstractItem item = mDatas.get(position);
        switch (item.getType()){
            case AbstractItem.TYPE_NORMAL_ITEM:
                return AbstractItem.TYPE_NORMAL_ITEM;
            case AbstractItem.TYPE_PICTURE_ITEM:
                return AbstractItem.TYPE_PICTURE_ITEM;
            case AbstractItem.TYPE_TITLE_ITEM:
                return AbstractItem.TYPE_TITLE_ITEM;

        }

        return AbstractItem.TYPE_NORMAL_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return (position >= 0 && position < mDatas.size()) ? mDatas.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        AbstractItem data = (AbstractItem) getItem(position);
        View view=null;

        switch (type) {
            case AbstractItem.TYPE_NORMAL_ITEM:
                ViewHolderNormal viewHolderNormal;
                if (null == convertView) {
                    viewHolderNormal = new ViewHolderNormal();
                    view = LayoutInflater.from(context).inflate(R.layout.text_item,null);
                    viewHolderNormal.textView= (TextView) view.findViewById(R.id.text);
                    view.setTag(viewHolderNormal);
                }else{
                    view=convertView;
                    viewHolderNormal= (ViewHolderNormal) view.getTag();
                }
                TextItem textItem = (TextItem) getItem(position);
                viewHolderNormal.textView.setText(textItem.getText());


                break;

            case AbstractItem.TYPE_TITLE_ITEM:
                ViewHolderTitle viewHolderTitle;
                if (null == convertView) {
                    viewHolderTitle = new ViewHolderTitle();
                    view = LayoutInflater.from(context).inflate(R.layout.text_item,null);
                    viewHolderTitle.textView= (TextView) view.findViewById(R.id.text);
                    view.setTag(viewHolderTitle);
                }else{
                    view=convertView;
                    viewHolderTitle= (ViewHolderTitle) view.getTag();
                }
                TitleItem titleItem = (TitleItem) getItem(position);
                viewHolderTitle.textView.setText(titleItem.getTitle());

                break;
            case AbstractItem.TYPE_PICTURE_ITEM:
                ViewHolderPicture viewHolderPicture;
                if (null == convertView) {
                    viewHolderPicture = new ViewHolderPicture();
                    view = LayoutInflater.from(context).inflate(R.layout.picture_item,null);
                    viewHolderPicture.imageView= (ImageView) view.findViewById(R.id.image);
                    view.setTag(viewHolderPicture);
                }else{
                    view=convertView;
                    viewHolderPicture= (ViewHolderPicture) view.getTag();
                }
                PictureItem pictureItem = (PictureItem) getItem(position);

                Glide.with(context).load(pictureItem.getUrl()).into( viewHolderPicture.imageView);


                break;
            default:
                break;

        }

        return view;
    }


    class ViewHolderNormal{
        TextView textView;
    }
    class ViewHolderTitle{
        TextView textView;
    }
    class ViewHolderPicture{
        ImageView imageView;
    }


}
