package com.ksbk.listview_pro;

import android.widget.TextView;

/**
 * Created by Administrator on 2016/2/19 0019.
 */
public class TextItem extends AbstractItem {
    String text;

    public TextItem(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * 是否可点击
     *
     * @return
     */
    @Override
    public Boolean canClick() {
        return true;
    }

    /**
     * 获取主键用于排序
     *
     * @return
     */
    @Override
    public String getMainString() {
        return text;
    }

    /**
     * 获取Item类型
     *
     * @return
     */
    @Override
    public int getType() {
        return TYPE_NORMAL_ITEM;
    }
}
