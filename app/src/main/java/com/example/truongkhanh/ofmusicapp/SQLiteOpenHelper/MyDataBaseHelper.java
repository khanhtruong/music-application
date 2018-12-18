package com.example.truongkhanh.ofmusicapp.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    // DataBase Information
    private final static String DATABASE_NAME = "MusicApp";
    private final static int DATABASE_VERSION = 1;

    // Table in Database
    // Main Table
    private final static String BAI_HAT = "Bai_Hat";
    private final static String PLAY_LIST = "Play_List";
    private final static String ALBUM = "Album";
    private final static String CHU_DE = "Chu_De";
    private final static String THE_LOAI = "The_Loai";
    private final static String BANNER = "Banner";
    private final static String IMG = "IMG";

    // Table use for link other table
    private final static String ALBUM_BAIHAT = "Album_BaiHat";
    private final static String CHUDE_PLAYLIST = "ChuDe_PlayList";
    private final static String CHUDE_THELOAI = "ChuDe_TheLoai";
    private final static String BAIHAT_THELOAI = "BaiHat_TheLoai";
    private final static String BAIHAT_PLAYLIST = "BaiHat_PlayList";

    // Todo: Columns for table BAI_HAT
    private final static String ID_BAI_HAT = "ID_BAI_HAT";
    private final static String NAME_BAI_HAT = "NAME_BAI_HAT";
    private final static String NAME_CA_SI = "NAME_CA_SI";
    private final static String PATH_BAI_HAT = "PATH_BAI_HAT";
    // ID_IMG
    // Todo: Columns for table PLAY_LIST
    private final static String ID_PLAY_LIST = "ID_PLAY_LIST";
    private final static String NAME_PLAY_LIST = "NAME_PLAY_LIST";
    // ID_IMG
    // Todo: Columns for table ALBUM
    private final static String ID_ALBUM = "ID_ALBUM";
    private final static String NAME_ALBUM = "NAME_ALBUM";
    // ID_IMG
    // Todo: Columns for table CHU_DE
    private final static String ID_CHU_DE = "ID_CHU_DE";
    private final static String NAME_CHU_DE = "NAME_CHU_DE";
    // ID_IMG
    // Todo: Columns for table THE_LOAI
    private final static String ID_THE_LOAI = "ID_THE_LOAI";
    private final static String NAME_THE_LOAI = "NAME_THE_LOAI";
    // ID_IMG
    // Todo: Columns for table BANNER
    private final static String ID_BANNER = "ID_BANNER";
    private final static String NAME_BANNER = "NAME_BANNER";
    // ID_BAI_HAT
    // ID_ALBUM
    // ID_PLAY_LIST
    // ID_THE_LOAI
    // ID_CHU_DE
    // ID_IMG
    // Todo: Columns for table IMG
    private final static String ID_IMG = "ID_IMG";
    private final static String LINK_IMG = "LINK_IMG";
    // Todo: Columns for table CHUDE_THELOAI
    private final static String ID_CHUDE_THELOAI = "ID_CHUDE_THE_LOAI";
    // ID_CHU_DE
    // ID_THE_LOAI
    // Todo: Columns for table CHUDE_PLAYLIST
    private final static String ID_CHUDE_PLAYLIST = "ID_CHUDE_PLAYLIST";
    // ID_CHU_DE
    // ID_PLAY_LIST
    // Todo: Columns for table ALBUM_BAIHAT
    private final static String ID_ALBUM_BAIHAT = "ID_ALBUM_BAIHAT";
    // ID_ALBUM
    // ID_BAI_HAT
    // Todo: Columns for table BAIHAT_PLAYLIST
    private final static String ID_BAIHAT_PLAYLIST = "ID_BAIHAT_PLAYLIST";
    // ID_BAI_HAT
    // ID_PLAY_LIST
    // Todo: Coluns for table BAIHAT_THELOAI
    private final static String ID_BAIHAT_THELOAI = "ID_BAIHAT_THELOAI";
    // ID_BAI_HAT
    // ID_THE_LOAI

    // Todo: Query Create Table
    private final static String CREATE_TABLE_BAIHAT = "CREATE TABLE " + BAI_HAT + "("
            + ID_BAI_HAT + " INTEGER PRIMARY KEY, " + NAME_BAI_HAT + " TEXT, " + NAME_CA_SI + " TEXT, "
            + PATH_BAI_HAT + " TEXT, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_ALBUM = "CREATE TABLE " + ALBUM + "("
            + ID_ALBUM + " INTEGER PRIMARY KEY, " + NAME_ALBUM + " TEXT, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_THELOAI = "CREATE TABLE " + THE_LOAI + "("
            + ID_THE_LOAI + " INTEGER PRIMARY KEY, " + NAME_THE_LOAI + " TEXT, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_CHUDE = "CREATE TABLE " + CHU_DE + "("
            + ID_CHU_DE + " INTEGER PRIMARY KEY, " + NAME_CHU_DE + " TEXT, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_PLAYLIST = "CREATE TABLE " + PLAY_LIST + "("
            + ID_PLAY_LIST + " INTEGER PRIMARY KEY, " + NAME_PLAY_LIST + " TEXT, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_IMG = "CREATE TABLE " + IMG + "("
            + ID_IMG + " INTEGER PRIMARY KEY, " + LINK_IMG + " TEXT" + ")";
    private final static String CREATE_TABLE_BANNER = "CREATE TABLE " + BANNER + "("
            + ID_BANNER + " INTEGER PRIMARY KEY, " + NAME_BANNER + " TEXT, " + ID_BAI_HAT + " INTEGER, "
            + ID_ALBUM + " INTEGER, " + ID_CHU_DE + " INTEGER," + ID_THE_LOAI + " INTEGER, "
            + ID_PLAY_LIST + " INTEGER, " + ID_IMG + " INTEGER" + ")";
    private final static String CREATE_TABLE_CHUDE_PLAYLIST = "CREATE TABLE " + CHUDE_PLAYLIST + "("
            + ID_CHUDE_PLAYLIST + " INTEGER PRIMARY KEY, " + ID_CHU_DE + " INTEGER, " + ID_PLAY_LIST
            + " INTEGER" + ")";
    private final static String CREATE_TABLE_ALBUM_BAIHAT = "CREATE TABLE " + ALBUM_BAIHAT + "("
            + ID_ALBUM_BAIHAT + " INTEGER PRIMARY KEY, " + ID_ALBUM + " INTEGER, " + ID_BAI_HAT
            + " INTEGER" + ")";
    private final static String CREATE_TABLE_BAIHAT_PLAYLIST = "CREATE TABLE " + BAIHAT_PLAYLIST + "("
            + ID_BAIHAT_PLAYLIST + " INTEGER PRIMARY KEY, " + ID_BAI_HAT + " INTEGER, " + ID_PLAY_LIST
            + " INTEGER" + ")";
    private final static String CREATE_TABLE_CHUDE_THELOAI = "CREATE TABLE " + CHUDE_THELOAI + "("
            + ID_CHUDE_THELOAI + " INTEGER PRIMARY KEY, " + ID_CHU_DE + " INTEGER, " + ID_THE_LOAI
            + " INTEGER" + ")";
    private final static String CREATE_TABLE_BAIHAT_THELOAI = "CREATE TABLE " + BAIHAT_THELOAI + "("
            + ID_BAIHAT_THELOAI + " INTEGER PRIMARY KEY, " + ID_BAI_HAT + " INTEGER, " + ID_THE_LOAI
            + " INTEGER" + ")";

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BAIHAT);
        db.execSQL(CREATE_TABLE_ALBUM);
        db.execSQL(CREATE_TABLE_CHUDE);
        db.execSQL(CREATE_TABLE_PLAYLIST);
        db.execSQL(CREATE_TABLE_BANNER);
        db.execSQL(CREATE_TABLE_IMG);
        db.execSQL(CREATE_TABLE_ALBUM_BAIHAT);
        db.execSQL(CREATE_TABLE_BAIHAT_PLAYLIST);
        db.execSQL(CREATE_TABLE_BAIHAT_THELOAI);
        db.execSQL(CREATE_TABLE_CHUDE_PLAYLIST);
        db.execSQL(CREATE_TABLE_CHUDE_THELOAI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // IF newVersion is Higher than DATABASE_VERSION then onUpgrade is call
        db.execSQL("DROP TABLE IF EXISTS " + BAI_HAT);
        db.execSQL("DROP TABLE IF EXISTS " + ALBUM);
        db.execSQL("DROP TABLE IF EXISTS " + CHU_DE);
        db.execSQL("DROP TABLE IF EXISTS " + THE_LOAI);
        db.execSQL("DROP TABLE IF EXISTS " + BANNER);
        db.execSQL("DROP TABLE IF EXISTS " + IMG);
        db.execSQL("DROP TABLE IF EXISTS " + BAIHAT_THELOAI);
        db.execSQL("DROP TABLE IF EXISTS " + BAIHAT_PLAYLIST);
        db.execSQL("DROP TABLE IF EXISTS " + CHUDE_THELOAI);
        db.execSQL("DROP TABLE IF EXISTS " + CHUDE_PLAYLIST);
        db.execSQL("DROP TABLE IF EXISTS " + ALBUM_BAIHAT);

        onCreate(db);
    }
}
