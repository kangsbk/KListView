package com.ksbk.listview_pro;

/**
 * Created by Administrator on 2016/2/19 0019.
 */
public class PictureItem extends AbstractItem {
    String name;
    String url;

    public PictureItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取主键用于排序
     *
     * @return
     */
    @Override
    public String getMainString() {
        return name;
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
     * 获取Item类型
     *
     * @return
     */
    @Override
    public int getType() {
        return TYPE_PICTURE_ITEM;
    }
}
