package com.inconceptlabs.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "data.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE items ("
                        + "name TEXT, "
                        + "age INTEGER "
                        + ");");

        // Test data
        db.insert("items", null, makeContentValues("Liam", 12));
        db.insert("items", null, makeContentValues("Noah", 22));
        db.insert("items", null, makeContentValues("Oliver", 54));
        db.insert("items", null, makeContentValues("Elijah", 43));
        db.insert("items", null, makeContentValues("William", 43));
        db.insert("items", null, makeContentValues("James", 21));
        db.insert("items", null, makeContentValues("Benjamin", 33));
        db.insert("items", null, makeContentValues("Lucas", 11));
        db.insert("items", null, makeContentValues("Henry", 27));
        db.insert("items", null, makeContentValues("Alexander", 26));
        db.insert("items", null, makeContentValues("Olivia", 55));
        db.insert("items", null, makeContentValues("Emma", 41));
        db.insert("items", null, makeContentValues("Ava", 47));
        db.insert("items", null, makeContentValues("Charlotte", 28));
        db.insert("items", null, makeContentValues("Sophia", 38));
        db.insert("items", null, makeContentValues("Amelia", 32));
        db.insert("items", null, makeContentValues("Isabella", 33));
        db.insert("items", null, makeContentValues("Mia", 19));
        db.insert("items", null, makeContentValues("Evelyn", 16));
        db.insert("items", null, makeContentValues("Harper", 77));
        db.insert("items", null, makeContentValues("Michael", 12));
        db.insert("items", null, makeContentValues("David", 22));
        db.insert("items", null, makeContentValues("William", 54));
        db.insert("items", null, makeContentValues("Richard", 43));
        db.insert("items", null, makeContentValues("Thomas", 43));
        db.insert("items", null, makeContentValues("Charles", 21));
        db.insert("items", null, makeContentValues("Gary", 33));
        db.insert("items", null, makeContentValues("Larry", 11));
        db.insert("items", null, makeContentValues("Ronald", 27));
        db.insert("items", null, makeContentValues("Joseph", 26));
        db.insert("items", null, makeContentValues("Donald", 55));
        db.insert("items", null, makeContentValues("Kenneth", 41));
        db.insert("items", null, makeContentValues("Steven", 47));
        db.insert("items", null, makeContentValues("Dennis", 21));
        db.insert("items", null, makeContentValues("Paul", 33));
        db.insert("items", null, makeContentValues("Stephen", 11));
        db.insert("items", null, makeContentValues("George", 27));
        db.insert("items", null, makeContentValues("Daniel", 26));
        db.insert("items", null, makeContentValues("Edward", 55));
        db.insert("items", null, makeContentValues("Mark", 41));
        db.insert("items", null, makeContentValues("Jerry", 47));
        db.insert("items", null, makeContentValues("Gregory", 28));
        db.insert("items", null, makeContentValues("Bruce", 38));
        db.insert("items", null, makeContentValues("Roger", 32));
        db.insert("items", null, makeContentValues("Douglas", 33));
        db.insert("items", null, makeContentValues("Frank", 19));
        db.insert("items", null, makeContentValues("Terry", 16));
        db.insert("items", null, makeContentValues("Raymond", 77));
    }

    private ContentValues makeContentValues(String name, int age) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        return values;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor queryAll() {
        return getReadableDatabase().query("items", null, null, null, null, null, "age");
    }
}
