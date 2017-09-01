package kr.anima.xd.s.myapp.entries.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by alfo6-10 on 8/30/2017.
 */

public class DataHelper extends Observable{

    private List<DataRow> dataRowList;

    public DataHelper(){
        dataRowList=new ArrayList<>();
    }

    public void initList(){
        dataRowList.clear();
    }

    public void createItem(DataRow dataRow){

    }

    public int getItemSize(){
        return dataRowList.size();
    }

    public DataRow get(int position){
        return dataRowList.get(position);
    }

    public void remove(int position){
        dataRowList.remove(position);
        if(dataRowList.size()==0){
            setChanged();
            notifyObservers();
        }
    }

}
