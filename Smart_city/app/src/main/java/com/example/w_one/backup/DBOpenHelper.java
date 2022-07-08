package com.example.w_one.backup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {
    /**
     * 声明一个AndroidSDK自带的数据库变量db
     */
    private SQLiteDatabase db;

    /**
     * 写一个这个类的构造函数，参数为上下文context，所谓上下文就是这个类所在包的路径
     * 指明上下文，数据库名，工厂默认空值，版本号默认从1开始
     * super(context,"db_test",null,1);
     * 把数据库设置成可写入状态，除非内存已满，那时候会自动设置为只读模式
     * 不过，以现如今的内存容量，估计一辈子也见不到几次内存占满的状态
     * db = getReadableDatabase();
     */
    DBOpenHelper(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();
    }

    /**
     * 重写两个必须要重写的方法，因为class DBOpenHelper extends SQLiteOpenHelper
     * 而这两个方法是 abstract 类 SQLiteOpenHelper 中声明的 abstract 方法
     * 所以必须在子类 DBOpenHelper 中重写 abstract 方法
     * 想想也是，为啥规定这么死必须重写？
     * 因为，一个数据库表，首先是要被创建的，然后免不了是要进行增删改操作的
     * 所以就有onCreate()、onUpgrade()两个方法
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql="CREATE TABLE IF NOT EXISTS user(id integer primary key autoincrement," +
                "username varchar(50),nicheng varchar(50),email varchar(50)," +
                "phone integer,password varchar(20),sex integer,yue varchar(50)," +
                "jifen varchar(50))";
        db.execSQL(sql);
    }
    //版本适应
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
    /**
     * 接下来写自定义的增删改查方法
     * 这些方法，写在这里归写在这里，以后不一定都用
     * add()
     * delete()
     * update()
     * getAllData()
     */
    void add(String username, String password,String email,String phone){
        db.execSQL("INSERT INTO user (username,password,email,phone) VALUES(?,?,?,?)",new Object[]{username,password,email,phone});
    }
    public void delete(String username,String password){
        db.execSQL("DELETE FROM user WHERE name = AND password ="+username+password);
    }
    public void updata(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
    }
    public void updatauser(String nicheng,String phone,int sex){
        db.execSQL("UPDATE user SET nicheng = ?,phone=?,sex=?",new Object[]{nicheng,phone,sex});
    }

    /**
     * 前三个没啥说的，都是一套的看懂一个其他的都能懂了
     * 下面重点说一下查询表Userwe全部内容的方法
     * 我们查询出来的内容，需要有个容器存放，以供使用，
     * 所以定义了一个ArrayList类的list
     * 有了容器，接下来就该从表中查询数据了，
     * 这里使用游标Cursor，这就是数据库的功底了，
     * 在Android中我就不细说了，因为我数据库功底也不是很厚，
     * 但我知道，如果需要用Cursor的话，第一个参数："表名"，中间5个：null，
     *  最后是查询出来内容的排序方式："name DESC"
     * 游标定义好了，接下来写一个while循环，让游标从表头游到表尾
     * 在游的过程中把游出来的数据存放到list容器中
     *
     */
    ArrayList<Userwe> getAllData(){
        ArrayList<Userwe> list = new ArrayList<Userwe>();
        @SuppressLint("Recycle") Cursor cursor = db.query("user",null,null,null,null,null,"username DESC");
        while(cursor.moveToNext()){
            @SuppressLint("Range") String id1 = cursor.getString(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String username1 = cursor.getString(cursor.getColumnIndex("username"));
            @SuppressLint("Range") String password1 = cursor.getString(cursor.getColumnIndex("password"));
            @SuppressLint("Range") String email1 = cursor.getString(cursor.getColumnIndex("email"));
            @SuppressLint("Range") String phone1 = cursor.getString(cursor.getColumnIndex("phone"));
            @SuppressLint("Range") String nicheng1 = cursor.getString(cursor.getColumnIndex("nicheng"));
            @SuppressLint("Range") String sex1 = String.valueOf(0);
            @SuppressLint("Range") String yue1 =  String.valueOf(100);
            @SuppressLint("Range") String jifen1 = String.valueOf(1000);

            Integer iid1= Integer.valueOf(id1);
            Integer ssex1= Integer.valueOf(sex1);

            list.add(new Userwe(iid1,username1,nicheng1,email1,phone1,password1,ssex1,yue1,jifen1));
        }
        return list;
    }

}
