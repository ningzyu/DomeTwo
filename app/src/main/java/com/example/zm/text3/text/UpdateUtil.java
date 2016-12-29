package com.example.zm.text3.text;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 2016/12/16
 *
 * @author Michael Zhao
 */

public class UpdateUtil {
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    public static void update(final Context context) {
        final String downloadUrl = "http://124.163.206.251:7066/CivilAirDE.apk";
        showUpdateDialog(context,downloadUrl);
    }

    //提示窗口
    private static void showUpdateDialog(final Context context, final String downloadUrl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setTitle("请升级APP至版本");
        builder.setMessage("检测到最新版本，请及时更新！");
//        builder.setCancelable(false);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    fileUpload(context,downloadUrl);
                } else {
                    Toast.makeText(context, "SD卡不可用，请插入SD卡",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        builder.create().show();
    }
    /*
	 * 从服务器中下载APK
	 */
    public static void fileUpload(final Context context, final String downloadUrl) {
        final ProgressDialog pBar = new ProgressDialog(context);    //进度条，在下载的时候实时更新进度，提高用户友好度
        pBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pBar.setTitle("正在下载");
        pBar.setMessage("请稍候...");
        pBar.setProgress(0);
        pBar.show();
        Request reqDownload = new Request.Builder()
                .post(new FormBody.Builder().build())
                .url(downloadUrl)
                .build();

        okHttpClient.newCall(reqDownload).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("updateUtil", call.request().toString() + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String storagePath = context.getExternalCacheDir() + "/" + context.getPackageName() + ".apk";
                FileOutputStream out = new FileOutputStream(storagePath);
                InputStream in = response.body().byteStream();
                pBar.setMax((int) response.body().contentLength());
                byte[] buf = new byte[2048];
//                int len;
//                while ((len = in.read(buf)) != -1) {
//                    out.write(buf, 0, len);
//                    pBar.setProgress(len);
//                }
                int len ;
                int total=0;
                while((len =in.read(buf))!=-1){
                    out.write(buf, 0, len);
                    total+= len;
                    //获取当前下载量
                    pBar.setProgress(total);
                }
                out.flush();
                pBar.dismiss(); //结束掉进度条对话框
                install(context, new File(storagePath));//安装apk
            }
        });

    }
    //获取当前版本号
    private static String getVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "版本号未知";
        }
    }

    private static void install(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//如果不加，最后安装完成，点打开，无法打开新版本应用。
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());//如果不加，最后不会提示完成、打开。
    }
}
