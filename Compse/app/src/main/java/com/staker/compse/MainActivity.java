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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private int id;
    private String song_name;
    private String song_speed;
    private String song_allnames;
    private String analyze_names;
    private String now_names;
    private String save_songlength;
    private int get_length;
    private int get_times;
    private ArrayList all;
    private SimpleAdapter simAdapt;
    private List<Map<String, Object>> data;
    private String  color;
    private int color_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        onResume();
        data= new ArrayList<Map<String, Object>>();
        color_int=R.drawable.cirlcle_blue;
        SharedPreferences spf= getSharedPreferences("Song", 0);
        song_allnames = spf.getString("Name","00;");
        get_times=Integer.valueOf(song_allnames.substring(0,2));
        if(String.valueOf(get_times).substring(0,1).equals("0")) {
            get_times = Integer.valueOf(song_allnames.substring(1, 2));
        }else{
            get_times = Integer.valueOf(song_allnames.substring(0, 2));
        }
        //获取数据数量
        all=new ArrayList();
        analyze_names = song_allnames.substring(3, song_allnames.length());
        //去除总次数显示
        now_names = song_allnames.substring(3, song_allnames.length());
        for(int id=0;id<get_times;id++){
            get_length=Integer.valueOf(analyze_names.substring(0,2));
            //解析第一个的长度
            if(String.valueOf(get_length).substring(0,1).equals("0")){
                get_length = Integer.valueOf(analyze_names.substring(1, 2));
            }else{
                get_length = Integer.valueOf(analyze_names.substring(0, 2));
            }
            //获取单个长度
            String name=analyze_names.substring(2,get_length+2);
            SharedPreferences spfs = getSharedPreferences(name, 0);
            color = spfs.getString("Color", "");
            get_color(color);
            String speed=spfs.getString("Speed", "");
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("name",name);
            item.put("color",color_int);
            item.put("speed",speed+"bmp");
            data.add(item);
            analyze_names=analyze_names.substring(get_length+3,analyze_names.length());
        }
        final ListView listview = (ListView) findViewById(R.id.song_list);
        simAdapt = new SimpleAdapter(
                this,
                data,
                R.layout.list,
                new String[] { "name", "color", "speed" },
                new int[] { R.id.list_name, R.id.list_color, R.id.list_speed });
        listview.setAdapter(simAdapt);

        Toast.makeText(this, song_allnames, Toast.LENGTH_SHORT).show();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text= listview.getItemAtPosition(position)+"";
                String intent_name=text.substring(6,text.indexOf(", speed"));
                Intent intent = new Intent(MainActivity.this, Compose.class);
                intent.putExtra("Song_Name",intent_name);
                startActivity(intent);
            }
        });
    }
    public void blue(View v){
        color="blue";
        Toast.makeText(this, "蓝色", Toast.LENGTH_SHORT).show();
    }
    public void yellow(View v){
        color="yellow";
        Toast.makeText(this, "黄色", Toast.LENGTH_SHORT).show();
    }
    public void red(View v){
        color="red";
        Toast.makeText(this, "红色", Toast.LENGTH_SHORT).show();
    }
    public void pink(View v){
        color="pink";
        Toast.makeText(this, "粉色", Toast.LENGTH_SHORT).show();
    }
    public void brown(View v){
        color="brown";
        Toast.makeText(this, "棕色", Toast.LENGTH_SHORT).show();
    }
    public void grey(View v){
        color="grey";
        Toast.makeText(this, "灰色", Toast.LENGTH_SHORT).show();
    }
    public void bluegrey(View v){
        color="bluegrey";
        Toast.makeText(this, "蓝灰色", Toast.LENGTH_SHORT).show();
    }
    public void green(View v){
        color="green";
        Toast.makeText(this, "绿色", Toast.LENGTH_SHORT).show();
    }
    public void compose(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.create_dialog,null);
        dialog.setTitle("歌曲信息");
        dialog.setView(dialogView);
        dialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText song_name_ed = (EditText)dialogView.findViewById(R.id.song_name);
                EditText song_speed_ed = (EditText)dialogView.findViewById(R.id.song_speed);
                song_name=song_name_ed.getText().toString();
                song_speed=song_speed_ed.getText().toString();
                SharedPreferences spf= getSharedPreferences(song_name, 0);
                final String exist = spf.getString("Name","0");
                if(song_speed.length()==0){
                    song_speed=String.valueOf(90);
                }
                if(song_name.contains(";")) {
                    Toast.makeText(MainActivity.this, "包含非法字\";\"", Toast.LENGTH_LONG).show();
                }
                else if(get_times==99){
                    Toast.makeText(MainActivity.this, "存储的歌曲已达极值，请删除部分后重试", Toast.LENGTH_LONG).show();
                }
                else if(song_name.length()>=100){
                    Toast.makeText(MainActivity.this, "名称不能超过两位数", Toast.LENGTH_LONG).show();
                }
                else if(song_name.equals(exist)){
                    Toast.makeText(MainActivity.this, "歌曲已存在", Toast.LENGTH_LONG).show();
                }
                else if(Integer.valueOf(song_speed)<40 || Integer.valueOf(song_speed)>210){
                    Toast.makeText(MainActivity.this, "速度范围：40bmp-210bmp", Toast.LENGTH_LONG).show();
                }
                //各类奇奇怪怪的设定
                else {
                    if(color.length()==0) {
                        SharedPreferences.Editor editor = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                        editor.putString("Name", song_name);
                        editor.putString("Speed", song_speed);
                        editor.putString("Color", "blue");
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = getSharedPreferences(song_name, MODE_PRIVATE).edit();
                        editor.putString("Name", song_name);
                        editor.putString("Speed", song_speed);
                        editor.putString("Color", color);
                        editor.putString("Content", "");
                        editor.commit();
                    }
                    //存储歌曲的信息
                    get_times = get_times + 1;
                    String times = String.valueOf(get_times);
                    if(song_name.length()<10) {
                        save_songlength = "0" + String.valueOf(song_name.length());
                    }else{
                        save_songlength = String.valueOf(song_name.length());
                    }
                    if (times.length() < 2) {
                        SharedPreferences.Editor editor2 = getSharedPreferences("Song", MODE_PRIVATE).edit();
                        editor2.putString("Name", "0"+times + ";" + now_names + save_songlength + song_name + ";");
                        editor2.commit();
                    } else {
                        SharedPreferences.Editor editor2 = getSharedPreferences("Song", MODE_PRIVATE).edit();
                        editor2.putString("Name", times + ";" + now_names + save_songlength + song_name + ";");
                        editor2.commit();
                    }
                    //存储歌曲的信息
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, Compose.class);
                            intent.putExtra("Song_Name",song_name);
                            intent.putExtra("Song_Speed",song_speed);
                            startActivity(intent);
                        }
                    }, 800);
                    //界面跳转
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
        dialog.setCancelable(false).create().show();
        //创建Dialog
    }
    void get_color(String which_color) {
        switch (which_color) {
            case "blue":
                color_int = R.drawable.cirlcle_blue;
                break;
            case "red":
                color_int = R.drawable.circle_red;
                break;
            case "yellow":
                color_int = R.drawable.circle_yellow;
                break;
            case "brown":
                color_int = R.drawable.circle_brown;
                break;
            case "pink":
                color_int = R.drawable.circle_pink;
                break;
            case "green":
                color_int = R.drawable.circle_green;
                break;
            case "grey":
                color_int = R.drawable.circle_grey;
                break;
            case "bluegrey":
                color_int = R.drawable.circle_bluegrey;
                break;
            default:
        }
    }
        @Override
        protected void onResume() {
            super.onResume();
            data= new ArrayList<Map<String, Object>>();
            color_int=R.drawable.cirlcle_blue;
            SharedPreferences spf= getSharedPreferences("Song", 0);
            song_allnames = spf.getString("Name","00;");
            get_times=Integer.valueOf(song_allnames.substring(0,2));
            if(String.valueOf(get_times).substring(0,1).equals("0")) {
                get_times = Integer.valueOf(song_allnames.substring(1, 2));
            }else{
                get_times = Integer.valueOf(song_allnames.substring(0, 2));
            }
            //获取数据数量
            all=new ArrayList();
            analyze_names = song_allnames.substring(3, song_allnames.length());
            //去除总次数显示
            now_names = song_allnames.substring(3, song_allnames.length());
            for(int id=0;id<get_times;id++){
                get_length=Integer.valueOf(analyze_names.substring(0,2));
                //解析第一个的长度
                if(String.valueOf(get_length).substring(0,1).equals("0")){
                    get_length = Integer.valueOf(analyze_names.substring(1, 2));
                }else{
                    get_length = Integer.valueOf(analyze_names.substring(0, 2));
                }
                //获取单个长度
                String name=analyze_names.substring(2,get_length+2);
                Map<String, Object> item = new HashMap<String, Object>();
                SharedPreferences spfs = getSharedPreferences(name, 0);
                color = spfs.getString("Color", "");
                get_color(color);
                String speed=spfs.getString("Speed", "");
                item.put("name",name);
                item.put("color",color_int);
                item.put("speed",speed+"bmp");
                data.add(item);
                analyze_names=analyze_names.substring(get_length+3,analyze_names.length());
            }
            ListView listview = (ListView) findViewById(R.id.song_list);
            simAdapt = new SimpleAdapter(
                    this,
                    data,
                    R.layout.list,
                    new String[] { "name", "color", "speed" },// 与下面数组元素要一一对应
                    new int[] { R.id.list_name, R.id.list_color, R.id.list_speed });

            listview.setAdapter(simAdapt);
        }
}