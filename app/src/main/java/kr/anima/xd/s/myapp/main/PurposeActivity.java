package kr.anima.xd.s.myapp.main;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import kr.anima.xd.s.myapp.R;
import kr.anima.xd.s.myapp.db.DBManager;

public class PurposeActivity extends AppCompatActivity implements View.OnClickListener, DatePicker.OnDateChangedListener{

    EditText etTitle, etSummary;
    CheckBox cbAllday;
    DatePicker startDatePicker, endDatePicker;
    Spinner spiRepeatRule, spiRepeatDate;
    TextView tvOk, tvCancel;

//    insert item
    // id, title, content type(purpose, objective, schedule, task), start date, end date,
    // repeat type(true, false), repeat rule, repeat date, tracker type(true, false), status,
    // element A~S(NotNull), ref_objective_id, ref_purpose_id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);

        etTitle= (EditText) findViewById(R.id.etTitle);
        etSummary= (EditText) findViewById(R.id.etDescription);
        cbAllday= (CheckBox) findViewById(R.id.cbAllday);

        startDatePicker= (DatePicker) findViewById(R.id.dpStart);
        endDatePicker= (DatePicker) findViewById(R.id.dpEnd);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startDatePicker.setOnDateChangedListener(this);
            endDatePicker.setOnDateChangedListener(this);
        }


        spiRepeatRule= (Spinner) findViewById(R.id.spiRrule);
        spiRepeatDate= (Spinner) findViewById(R.id.spiRdate);
        tvOk= (TextView) findViewById(R.id.tvOk);
        tvCancel= (TextView) findViewById(R.id.tvCancel);

        String title=etTitle.getText().toString();
        String summary=etSummary.getText().toString();
        boolean isChecked=cbAllday.isChecked();
        if (isChecked){
            startDatePicker.setActivated(false);
            endDatePicker.setActivated(false);
        }

        initSpinner();

    }

    private void initSpinner(){
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this, R.array.days_full_name, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_imageview);
        spiRepeatDate.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvOk: // 저장 : Save SQLite
                saveData();
                break;
            case R.id.tvCancel: // 입력 취소
                finish();
        }
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfWeek) {

    }

    private boolean saveData(){
        DBManager dbManager=new DBManager(this);
        dbManager.openDB();

        dbManager.closeDB();

        return false;
    }

}
