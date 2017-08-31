package kr.anima.xd.s.myapp.setting;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import kr.anima.xd.s.myapp.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvAdminEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tvAdminEmail= (TextView) findViewById(R.id.tvAdminEmail);
        tvAdminEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvAdminEmail: // 관리자에게 이메일 전송
                Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:s.xd.anima@gmail.com"));
                intent.setType("text/plain");
                startActivity(intent);
                break;

        }
    }
}
