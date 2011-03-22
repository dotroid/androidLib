package net.dotroid.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

/**************************************************
 * 初期化処理にプログレスダイアログを表示するActivity
 * @author dotroid
 **************************************************/
public class InitBehindProgressActivity extends Activity {
	
	// ProgressDialog定義
	private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    /********************************************
     * プログレスダイアログの表示、及び初期化処理の実行
     * @param message プログレスダイアログに表示するメッセージ
     ********************************************/
    protected void startInitProgress(String message){
    	
    	// Setting ProgressDialog
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mProgressDialog.setMessage(message);
		mProgressDialog.setCancelable(true);
		mProgressDialog.show();

		// Start init thread
        (new Thread(runnable)).start();
    }
    
    /********************************************
     * 初期化処理
     * Overrideして使用する
     *******************************************/
    protected void Init() throws Exception{
    	
    	// Do Anything behind a ProgressDialog
    	return;
    	
    }
    
    /********************************************
     * 初期化処理実行用Runnableオブジェクト
     *******************************************/
    private Runnable runnable = new Runnable(){
        public void run() {

            try {
            	// invoke init progress
                Init();
            }catch (Exception e) {
            	Log.e("InitBehindProgressActivity", e.getMessage());
            }
            
            // dismiss a ProgressDialog
            mProgressDialog.dismiss();

        }
    };
	
}
