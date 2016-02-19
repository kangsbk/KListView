package com.ksbk.listview_pro;

/**
 * Created by Administrator on 2016/2/19 0019.
 */
public class TitleItem extends AbstractItem {
    String title;

    public TitleItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取主键用于排序
     *
     * @return
     */
    @Override
    public String getMainString() {
        return title;
    }

    /**
     * 是否可点击
     *
     * @return
     */
    @Override
    public Boolean canClick() {
        return false;
    }

    /**
     * 获取Item类型
     *
     * @return
     */
    @Override
    public int getType() {
        return TYPE_TITLE_ITEM;
    }
}
