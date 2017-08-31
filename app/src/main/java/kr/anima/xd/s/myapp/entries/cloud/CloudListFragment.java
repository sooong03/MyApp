package kr.anima.xd.s.myapp.entries.cloud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;
import kr.anima.xd.s.myapp.entries.item.DataRow;

import static kr.anima.xd.s.myapp.db.DBStructure.CLOUD_DATA_LOAD_URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class CloudListFragment extends Fragment {

    // 서버에서 공유된 항목 로드
    // cloudListAdapter로 리스트를 넘겨줌
    RecyclerView rvCloudList;
    CloudListAdapter adapter;

    private List<DataRow> dataRowList=new ArrayList<>();

    public CloudListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cloud_list, container, false);
        loadCloudDate();

        rvCloudList=view.findViewById(R.id.rvCloudList);
        adapter=new CloudListAdapter(dataRowList);
        rvCloudList.setAdapter(adapter);

        return view;
    }

    private void loadCloudDate(){
        // 서버에서 공유된 항목 로드
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url=new URL(CLOUD_DATA_LOAD_URL);
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    connection.setUseCaches(false);

                    InputStream is=connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader reader=new BufferedReader(isr);

                    StringBuffer buffer=new StringBuffer();
                    String line=reader.readLine();

                    while (line!=null){
                        buffer.append(line);
                        line=reader.readLine();
                    }

                    String str=buffer.toString();
                    dataRowList.clear();

                    // TODO :: 로드받은 데이타를 분류해서 넣기
                    // schedule : title, parent, date, time
                    // task : title, parent, checked



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}
