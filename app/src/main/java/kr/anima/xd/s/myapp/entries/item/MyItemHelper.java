package kr.anima.xd.s.myapp.entries.item;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by PC on 2017-08-27.
 */

public class MyItemHelper extends Observable {

    private List<MyItemRow> itemlist;
    private LinearLayout layout_ItemContent;

    public MyItemHelper(LinearLayout layout_ItemContent) {
        this.layout_ItemContent = layout_ItemContent;
        this.itemlist=new ArrayList<>();
    }

    public void initList(){
        layout_ItemContent.removeAllViews();
        itemlist.clear();
        setChanged();
        notifyObservers();
    }

    public void createItem(MyItemRow row){
        layout_ItemContent.addView(itemlist.get(itemlist.size()-1).getView());
        if(itemlist.size()==1){
            setChanged();
            notifyObservers();
        }
    }

    public int getItemSize(){
        return itemlist.size();
    }

    public MyItemRow get(int position){
        return itemlist.get(position);
    }

    public void remove(int position){
        itemlist.remove(position);
        if(itemlist.size()==0){
            setChanged();
            notifyObservers();
        }
    }


}
