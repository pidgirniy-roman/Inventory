package com.example.inventory.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.inventory.Model.Inventar;
import com.example.inventory.Utils.Util;

public class DataBaseHendler extends SQLiteOpenHelper {
    public DataBaseHendler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INVENTAR_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_NAME + " text, "
                + Util.KEY_NAME_INV + " text, "
                + Util.KEY_COMMENT + " text, "
                + Util.KEY_READINESSSTATUS + " text, "
                + Util.KEY_STATUSSENT + " text, "
                + Util.KEY_DATE + " INTEGER" + ")";

        db.execSQL(CREATE_INVENTAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        onCreate(db);
    }

    //CRUD
    //Create, Read, Update, Delete

    public void addInv(Inventar inv){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_NAME, inv.getName());
        contentValues.put(Util.KEY_NAME_INV, inv.getNameInv());
        contentValues.put(Util.KEY_COMMENT, inv.getComment());
        contentValues.put(Util.KEY_READINESSSTATUS, inv.getReadinessStatus());
        contentValues.put(Util.KEY_STATUSSENT, inv.getStatusSent());
        contentValues.put(Util.KEY_DATE, inv.getDate());

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Inventar getInv(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME,
                Util.KEY_NAME_INV, Util.KEY_COMMENT, Util.KEY_READINESSSTATUS,
                Util.KEY_STATUSSENT, Util.KEY_DATE}, Util.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Inventar inv = new Inventar(Integer.parseInt(
                cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5),
                cursor.getString(6));

        return inv;
    }

    public List<Inventar> getAllInventars(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Inventar> invList = new ArrayList<>();
        String selectAllInventars = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllInventars, null);
        if (cursor.moveToFirst()){
            do {
                Inventar inv = new Inventar();
                inv.setId(Integer.parseInt(cursor.getString(0)));
                inv.setName(cursor.getString(1));
                inv.setNameInv(cursor.getString(2));
                inv.setComment(cursor.getString(3));
                inv.setReadinessStatus(cursor.getString(4));
                inv.setStatusSent(cursor.getString(5));
                inv.setDate(cursor.getString(6));

                invList.add(inv);
            }while (cursor.moveToNext());
        }
        return invList;
    }
}
