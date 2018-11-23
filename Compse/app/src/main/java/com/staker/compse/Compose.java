package com.staker.compse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Compose extends Activity {
    private String melody;
    private int speed;
    private Handler handler;
    private EditText melody_ed;
    private String song_name;
    private String song_speed;
    private int get_times;
    private int low;
    private int high;
    private int real_times;
    private String auto_melody;
    private int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.compose);
        low=0;
        real_times=0;
        auto_melody=" ";
        Button button_name = (Button) findViewById(R.id.compose_name);
        Intent intent = getIntent();
        song_name = intent.getSerializableExtra("Song_Name").toString();
        SharedPreferences spf = getSharedPreferences(song_name, 0);
        song_speed = spf.getString("Speed", "90");
        String context = spf.getString("Content", "");
        float speed_f = (60000 / (Integer.valueOf(song_speed)));
        speed = (int) speed_f;
        button_name.setText(song_name);
        melody_ed = (EditText) findViewById(R.id.melody);
        melody_ed.setText(context);
        melody_ed.setSelection(melody_ed.getText().length());//光标移到最后
        //基础内容显示
    }
    public void run(View v) {
        melody = "0" + melody_ed.getText().toString();
        int length = melody.length();
        for (int times = 0; times < length; times++) {
            String note = melody.substring(times, times + 1);
            handler = new Handler();
            switch (note) {
                case "0":
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //休止符
                        }
                    }, real_times * speed);
                    real_times = real_times + 1;
                    break;
                case "1":
                    if (low == 1) {
                        final MediaPlayer Mp1 = MediaPlayer.create(Compose.this, R.raw.c5);
                        stop(real_times, speed, Mp1);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp1.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp1 = MediaPlayer.create(Compose.this, R.raw.c5);
                        stop(real_times, speed, Mp1);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp1.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp1 = MediaPlayer.create(Compose.this, R.raw.c6);
                        stop(real_times, speed, Mp1);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp1.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "2":
                    if (low == 1) {
                        final MediaPlayer Mp2 = MediaPlayer.create(Compose.this, R.raw.d5);
                        stop(real_times, speed, Mp2);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp2.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp2 = MediaPlayer.create(Compose.this, R.raw.d5);
                        stop(real_times, speed, Mp2);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp2.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp2 = MediaPlayer.create(Compose.this, R.raw.d6);
                        stop(real_times, speed, Mp2);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp2.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "3":
                    if (low == 1) {
                        final MediaPlayer Mp3 = MediaPlayer.create(Compose.this, R.raw.e4);
                        stop(real_times, speed, Mp3);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp3.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp3 = MediaPlayer.create(Compose.this, R.raw.e5);
                        stop(real_times, speed, Mp3);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp3.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp3 = MediaPlayer.create(Compose.this, R.raw.e6);
                        stop(real_times, speed, Mp3);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp3.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "4":
                    if (low == 1) {
                        final MediaPlayer Mp4 = MediaPlayer.create(Compose.this, R.raw.f4);
                        stop(real_times, speed, Mp4);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp4.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp4 = MediaPlayer.create(Compose.this, R.raw.f5);
                        stop(real_times, speed, Mp4);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp4.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp4 = MediaPlayer.create(Compose.this, R.raw.f6);
                        stop(real_times, speed, Mp4);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp4.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    if (high == 1) {
                        final MediaPlayer Mp4 = MediaPlayer.create(Compose.this, R.raw.f6);
                        stop(real_times, speed, Mp4);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp4.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "5":
                    if (low == 1) {
                        final MediaPlayer Mp5 = MediaPlayer.create(Compose.this, R.raw.g4);
                        stop(real_times, speed, Mp5);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp5.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp5 = MediaPlayer.create(Compose.this, R.raw.g5);
                        stop(real_times, speed, Mp5);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp5.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp5 = MediaPlayer.create(Compose.this, R.raw.g6);
                        stop(real_times, speed, Mp5);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp5.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "6":
                    if (low == 1) {
                        final MediaPlayer Mp6 = MediaPlayer.create(Compose.this, R.raw.a4);
                        stop(real_times, speed, Mp6);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp6.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp6 = MediaPlayer.create(Compose.this, R.raw.a5);
                        stop(real_times, speed, Mp6);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp6.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp6 = MediaPlayer.create(Compose.this, R.raw.a6);
                        stop(real_times, speed, Mp6);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp6.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "7":
                    if (low == 1) {
                        final MediaPlayer Mp7 = MediaPlayer.create(Compose.this, R.raw.b4);
                        stop(real_times, speed, Mp7);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp7.start();
                            }
                        }, real_times * speed);
                        low = 0;
                    }
                    if (low == 0 && high == 0) {
                        final MediaPlayer Mp7 = MediaPlayer.create(Compose.this, R.raw.b5);
                        stop(real_times, speed, Mp7);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp7.start();
                            }
                        }, real_times * speed);
                    }
                    if (high == 1) {
                        final MediaPlayer Mp7 = MediaPlayer.create(Compose.this, R.raw.b6);
                        stop(real_times, speed, Mp7);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Mp7.start();
                            }
                        }, real_times * speed);
                        high = 0;
                    }
                    real_times = real_times + 1;
                    break;
                case "8":
                    low = low + 1;
                    break;
                case "9":
                    high = high + 1;
                    break;
                default:
            }
        }
        //旋律
    }
    public void auto_compose(View v){
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(Compose.this);
        normalDialog.setTitle("自动作曲（β）");
        normalDialog.setMessage("确认开始自动作曲？");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (times < 2) {
                            if (melody_ed.getText().toString().length() >= 4) {
                                String ed_str = melody_ed.getText().toString();
                                auto(Integer.valueOf(melody_ed.getText().toString()));
                            } else {
                                Toast.makeText(Compose.this, "至少需要四个音符", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Compose.this, "次数过多", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        normalDialog.show();
    }
    public void song_change(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(Compose.this);
        final View dialogView = LayoutInflater.from(Compose.this).inflate(R.layout.change_dialog,null);
        dialog.setTitle("歌曲信息");
        dialog.setView(dialogView);
        dialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText ed_speed=dialogView.findViewById(R.id.change_song_speed);
                int dialog_speed=ed_speed.getText().toString().length();
                if(dialog_speed==0) {
                    song_speed = "90";
                    speed = (int) (60000 / (Integer.valueOf(song_speed)));
                    SharedPreferences.Editor editor = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                    editor.putString("Speed", song_speed);
                    editor.commit();
                    Toast.makeText(Compose.this, "成功(90bmp)", Toast.LENGTH_SHORT).show();
                }else{
                    song_speed = ed_speed.getText().toString();
                    speed = (int) (60000 / (Integer.valueOf(song_speed)));
                    SharedPreferences.Editor editor = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                    editor.putString("Speed", song_speed);
                    editor.commit();
                    Toast.makeText(Compose.this, "成功("+song_speed+"bmp)", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                });
        dialog.setNeutralButton("删除",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final AlertDialog.Builder normalDialog =new AlertDialog.Builder(Compose.this);
                        normalDialog.setTitle("确定删除？");
                        normalDialog.setNegativeButton("确定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SharedPreferences spf= getSharedPreferences("Song", 0);
                                        String song_allnames = spf.getString("Name","00;");
                                        get_times=Integer.valueOf(song_allnames.substring(0,2));
                                        if(String.valueOf(get_times).substring(0,1).equals("0")) {
                                            get_times = Integer.valueOf(song_allnames.substring(1, 2));
                                        }else{
                                            get_times = Integer.valueOf(song_allnames.substring(0, 2));
                                        }
                                        if(get_times<10) {
                                            if (song_name.length() < 10) {
                                                String delete_context = "0" + String.valueOf(song_name.length()) + song_name + ";";
                                                String deletestr1 = song_allnames.replace(delete_context, "");
                                                String deletestr2 = deletestr1.replace("0"+String.valueOf(get_times)+";", "");
                                                String deletestr = "0"+String.valueOf(get_times - 1) +";"+ deletestr2;
                                                SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                editor.putString("Name", deletestr);
                                                editor.commit();
                                                //删除名称（简略内容）
                                                SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                editors.remove("Name");
                                                editors.commit();
                                                //删除名称（详细内容）
                                                finish();

                                            } else {
                                                String delete_context = String.valueOf(song_name.length()) + song_name + ";";
                                                String deletestr1 = song_allnames.replace(delete_context, "");
                                                String deletestr2 = deletestr1.replace("0"+String.valueOf(get_times)+";", "");
                                                String deletestr = "0"+String.valueOf(get_times - 1) +";"+ deletestr2;
                                                SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                editor.putString("Name", deletestr);
                                                editor.commit();
                                                SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                editors.remove("Name");
                                                editors.commit();
                                                finish();
                                            }
                                        }
                                        if(get_times==10) {
                                            if (song_name.length() < 10) {
                                                String delete_context = "0" + String.valueOf(song_name.length()) + song_name + ";";
                                                String deletestr1 = song_allnames.replace(delete_context, "");
                                                String deletestr2 = deletestr1.replace(String.valueOf(get_times) + ";", "");
                                                String deletestr = "0"+String.valueOf(get_times - 1) + ";" + deletestr2;
                                                SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                editor.putString("Name", deletestr);
                                                editor.commit();
                                                SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                editors.remove("Name");
                                                editors.commit();
                                                finish();
                                            }else {
                                                    String delete_context = String.valueOf(song_name.length()) + song_name + ";";
                                                    String deletestr1 = song_allnames.replace(delete_context, "");
                                                    String deletestr2 = deletestr1.replace("0"+String.valueOf(get_times)+";", "");
                                                    String deletestr = "0"+String.valueOf(get_times - 1) +";"+ deletestr2;
                                                    SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                    editor.putString("Name", deletestr);
                                                    editor.commit();
                                                    SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                    editors.remove("Name");
                                                    editors.commit();
                                                    finish();
                                            }
                                        }
                                        if(get_times>10) {
                                            if (song_name.length() < 10) {
                                                String delete_context = "0" + String.valueOf(song_name.length()) + song_name + ";";
                                                String deletestr1 = song_allnames.replace(delete_context, "");
                                                String deletestr2 = deletestr1.replace(String.valueOf(get_times)+";", "");
                                                String deletestr = String.valueOf(get_times - 1) +";"+ deletestr2;
                                                SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                editor.putString("Name", deletestr);
                                                editor.commit();
                                                SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                editors.remove("Name");
                                                editors.commit();
                                                finish();
                                            } else {
                                                String delete_context = String.valueOf(song_name.length()) + song_name + ";";
                                                String deletestr1 = song_allnames.replace(delete_context, "");
                                                String deletestr2 = deletestr1.replace(String.valueOf(get_times), "");
                                                String deletestr = String.valueOf(get_times - 1) +";"+ deletestr2;
                                                SharedPreferences.Editor editor = getSharedPreferences("Song", MODE_PRIVATE).edit();
                                                editor.putString("Name", deletestr);
                                                editor.commit();
                                                SharedPreferences.Editor editors = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                                                editors.remove("Name");
                                                editors.commit();
                                                finish();
                                            }
                                        }
                                    }
                                });
                        normalDialog.setPositiveButton("关闭",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //do nothing
                                    }
                                });
                        normalDialog.show();
                    }
                });
        dialog.setCancelable(false).create().show();
        //创建Dialog
    }
    public void save(View v) {
        melody = melody_ed.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences(song_name, MODE_PRIVATE).edit();
        editor.putString("Content",melody);
        editor.commit();
        Toast.makeText(this, "成功啦", Toast.LENGTH_SHORT).show();
    }
    void stop(int times, int speed, final MediaPlayer MpPlayer) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MpPlayer != null) {
                    MpPlayer.stop();
                    MpPlayer.release();
                }
            }
        }, times * speed + 1000);
        //暂停设置
    }
    void auto(int song_melody) {
        String melody_string=String.valueOf(song_melody);
        int last=Integer.valueOf(melody_string.substring(melody_string.length()-1,melody_string.length()));
        int last2=Integer.valueOf(melody_string.substring(melody_string.length()-2,melody_string.length()-1));
        int last3=Integer.valueOf(melody_string.substring(melody_string.length()-3,melody_string.length()-2));
        int last4=Integer.valueOf(melody_string.substring(melody_string.length()-4,melody_string.length()-3));
        if (last != 0) {
            if (last2 != last && last - last2 == 4) {
                auto_melody = String.valueOf(last2) + String.valueOf(last - 2) + String.valueOf(last) + String.valueOf(last2) + String.valueOf(last - 2) + String.valueOf(last2) + String.valueOf(last - 2) + String.valueOf(last2);
            }
            if (last2 != last && last2 - last == 4) {
                auto_melody = String.valueOf(last) + String.valueOf(last2 - 2) + String.valueOf(last2) + String.valueOf(last) + String.valueOf(last2 - 2) + String.valueOf(last) + String.valueOf(last2 - 2) + String.valueOf(last);
            }
            if (last2 != last && last % 2 == 1 && last2 % 2 == 1) {
                if (last == 1) {
                    auto_melody = String.valueOf("3157");
                }
                if (last == 3) {
                    auto_melody = String.valueOf("1535");
                }
                if (last == 5) {
                    auto_melody = String.valueOf("3151");
                }
                if (last == 7) {
                    auto_melody = String.valueOf("5313");
                }
            }
        }else{
            if(last!=1 && last!=7 && last!=2 && last!=6) {
                auto_melody = String.valueOf((last + 2) + (last - 2) + last + (last + 2));
            }
            if(last==2||last==6){
                auto_melody = String.valueOf((last + 1) + (last - 1) + last + (last + 1));
            }
            if(last==1){
                auto_melody = String.valueOf("3157");
            }
            if(last==7){
                auto_melody = String.valueOf("5313");
            }
        }
        times=times+1;
        String finalstr=String.valueOf(song_melody)+auto_melody;
        melody_ed.setText(finalstr);
        Toast.makeText(this, String.valueOf(last), Toast.LENGTH_SHORT).show();
    }
}
