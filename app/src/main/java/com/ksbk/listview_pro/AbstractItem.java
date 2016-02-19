package com.ksbk.listview_pro;

/**
 * Created by KSBK on 2016/2/19 0019.
 */
public abstract class AbstractItem implements Comparable {
    public static final int TYPE_TITLE_ITEM = 0;//文本标题栏
    public static final int TYPE_NORMAL_ITEM = 1;//一般
    public static final int TYPE_PICTURE_ITEM = 2;//图片型

    CharacterParser characterParser = CharacterParser.getInstance();

    /** 获取主键用于排序
     * @return
     */
    public abstract String getMainString();

    /** 是否可点击
     * @return
     */
    public abstract Boolean canClick();

    /**获取Item类型
     * @return
     */
    public abstract int getType();

    public final String getFirstChar(){
        String temp = characterParser.getSelling(this.getMainString());
        temp = temp.substring(0,1).toUpperCase();
        return temp;
    }

    @Override
    public int compareTo(Object another) {
        return this.getFirstChar().compareTo(((AbstractItem) another).getFirstChar());
    }
}
