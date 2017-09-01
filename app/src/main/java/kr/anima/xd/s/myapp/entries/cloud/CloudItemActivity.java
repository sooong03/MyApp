package kr.anima.xd.s.myapp.entries.cloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.entries.cloud.comment.CommentListAdapter;

import static kr.anima.xd.s.myapp.db.DBStructure.COMMENT_DATA_LOAD_URL;


public class CloudItemActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvNumOfStar, tvNumOfDown;
    ImageView ivStar, ivDown, ivComment;
    ListView lvComments;

    // 코멘트 로드
    private List<HashMap<String, String>> commentsList=new ArrayList<>();
    private CommentListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_item);

        tvNumOfStar= (TextView) findViewById(R.id.tvNumOfStar);
        tvNumOfDown= (TextView) findViewById(R.id.tvNumOfDown);
        ivStar= (ImageView) findViewById(R.id.ivStar);
        ivDown= (ImageView) findViewById(R.id.ivDown);
        ivComment= (ImageView) findViewById(R.id.ivComment);
        ivComment.setOnClickListener(this);

        loadComment();

        lvComments= (ListView) findViewById(R.id.lvComments);
        adapter=new CommentListAdapter(commentsList);
        lvComments.setAdapter(adapter);

    }

    private void loadComment(){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url=new URL(COMMENT_DATA_LOAD_URL);
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();

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
                    // TODO :: 코멘트 목록 로드
                    commentsList.clear();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onClick(View view) {

    }

}
