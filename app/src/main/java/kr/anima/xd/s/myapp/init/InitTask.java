package kr.anima.xd.s.myapp.init;

import android.content.Context;
import android.os.AsyncTask;

import kr.anima.xd.s.myapp.db.DBManager;

/**
 * Created by PC on 2017-08-26.
 */

public class InitTask extends AsyncTask<Long, Void, Boolean> {

    public interface InitCallBack{
        void onInitCompiled(boolean showReleaseNote);
    }

    private InitCallBack callBack;
    private Context mContext;
    boolean showReleaseNote;

    public InitTask(Context mContext, InitCallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
    }

    @Override
    protected Boolean doInBackground(Long... longs) {

        try {
            DBManager dbManager=new DBManager(mContext);
            dbManager.openDB();
//            loadSampleData(dbManager);
//            updateData(dbManager);
            dbManager.closeDB();
//            saveCurrentVersionCode();
        } catch (Exception e){}

        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        callBack.onInitCompiled(true);
    }

    private void loadSampleData(DBManager dbManager){
        // TODO :: 샘플로드
    }

    private void updateData(DBManager dbManager){

    }

}
