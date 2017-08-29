package kr.anima.xd.s.myapp.init;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.main.MainActivity;
import kr.anima.xd.s.myapp.security.PasswordActivity;

public class InitActivity extends AppCompatActivity implements InitTask.InitCallBack{

    // 초회 한정 웹 서버에서 샘플 로드 == initTask
    // SQLite에서 사용자 데이터 불러오기
    // 비밀번호 여부에따라 password 와 main 으로 구분하기

    private Handler initHandler;
    private int initTime=2500; //3sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        initHandler=new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO :: 샘플로드
//        initHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                new InitTask(InitActivity.this, InitActivity.this).execute();
//            }
//        }, initTime);
    }

    @Override
    public void onInitCompiled(boolean showReleaseNote) {

        // 비밀번호가 있을경우
//        Intent goPasswordIntent=new Intent(InitActivity.this, PasswordActivity.class);
//        finish();;
//        InitActivity.this.startActivity(goPasswordIntent);

        // 비밀번호가 없다면
        Intent goMainIntent=new Intent(InitActivity.this, MainActivity.class);
        finish();
        InitActivity.this.startActivity(goMainIntent);
    }
}
