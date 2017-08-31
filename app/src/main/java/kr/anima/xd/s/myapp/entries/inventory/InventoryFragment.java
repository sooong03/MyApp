package kr.anima.xd.s.myapp.entries.inventory;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    private Context mContext;

    RecyclerView rvInventory;
    private List<String> purposeList=new ArrayList<>();

    public InventoryFragment() {
        // Required empty public constructor
    }

    public InventoryFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loadPurposeEntries();

        View view=inflater.inflate(R.layout.fragment_inventory, container, false);
        rvInventory=view.findViewById(R.id.rvInventory);
        rvInventory.setAdapter(new InventoryListAdapter(purposeList));

        return view;
    }

    private void loadPurposeEntries(){
        // 인벤토리에 보여질 목적 리스트 로드
        DBManager dbManager=new DBManager(mContext);
        dbManager.openDB();
        // purpose title, id

        dbManager.closeDB();

    }

}
