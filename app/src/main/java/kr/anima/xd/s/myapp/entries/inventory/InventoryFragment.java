package kr.anima.xd.s.myapp.entries.inventory;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.anima.xd.s.myapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    private Context mContext;

    public InventoryFragment() {
        // Required empty public constructor
    }

    public InventoryFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

}
