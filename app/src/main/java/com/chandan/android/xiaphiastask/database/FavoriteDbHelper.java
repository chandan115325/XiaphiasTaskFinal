package com.chandan.android.xiaphiastask.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.chandan.android.xiaphiastask.model.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delaroy on 5/27/17.
 */
public class FavoriteDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RCB.db";

    private static final int DATABASE_VERSION = 1;

    public static final String LOGTAG = "RCB_DATA";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase db;

    public FavoriteDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){
        Log.i(LOGTAG, "Database Opened");
        db = dbhandler.getWritableDatabase();
    }

    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + FavoriteContract.FavoriteEntry.TABLE_NAME + " (" +
                FavoriteContract.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FavoriteContract.FavoriteEntry.COLUMN_ETAG + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteEntry.COLUMN_PUBLISHED_AT + " TEXT NOT NULL" +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void addFavorite(List<Items> itemsList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i=0 ; i < itemsList.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(FavoriteContract.FavoriteEntry.COLUMN_ETAG, itemsList.get(i).getEtag());
            values.put(FavoriteContract.FavoriteEntry.COLUMN_TITLE, itemsList.get(i).getSnippet().getTitle());
            values.put(FavoriteContract.FavoriteEntry.COLUMN_DESCRIPTION, itemsList.get(i).getSnippet().getDescription() );
            values.put(FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH, itemsList.get(i).getSnippet().getThumbnails().getHigh().getUrl());
            values.put(FavoriteContract.FavoriteEntry.COLUMN_PUBLISHED_AT, itemsList.get(i).getSnippet().getPublishedAt());

            db.insert(FavoriteContract.FavoriteEntry.TABLE_NAME, null, values);
            db.close();
        }
    }
  /* public long getDataItemsCount() {
       return DatabaseUtils.queryNumEntries(db, FavoriteContract.FavoriteEntry.TABLE_NAME);
   }*/




    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FavoriteContract.FavoriteEntry.TABLE_NAME, FavoriteContract.FavoriteEntry.COLUMN_ETAG+ "=" + id, null);
    }

    public List<Items> getAllFavorite(){
        String[] columns = {
              FavoriteContract.FavoriteEntry._ID,
                FavoriteContract.FavoriteEntry.COLUMN_ETAG,
                FavoriteContract.FavoriteEntry.COLUMN_TITLE,
                FavoriteContract.FavoriteEntry.COLUMN_DESCRIPTION,
                FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH,
                FavoriteContract.FavoriteEntry.COLUMN_PUBLISHED_AT

        };
        String sortOrder =
                FavoriteContract.FavoriteEntry._ID + " ASC";
        List<Items> favoriteList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FavoriteContract.FavoriteEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst()){
            do {
                /*Snippet snippet = new Snippet();
                Items item = new Items();
                item.setEtag(cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_ETAG)));
                item.setSnippet(snippet.setTitle((cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_TITLE)))));
                item.setSnippet(snippet.setDescription((cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_DESCRIPTION)))));
                item.setSnippet(snippet.setTitle((cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH)))));
                item.setSnippet(snippet.setTitle((cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteEntry.COLUMN_PUBLISHED_AT)))));
*/

              //  favoriteList.add(item);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return favoriteList;
    }

}
