package com.chandan.android.xiaphiastask.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.chandan.android.xiaphiastask.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public DataSource() {

    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public DataItem createItem(DataItem item) {
        ContentValues values = item.toValues();
        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        return item;
    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }

    public void seedDatabase(List<DataItem> dataItemList) {
        long numItems = getDataItemsCount();
        if (numItems == 0) {
            for (DataItem item :
                    dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<DataItem> getAllItems(String category) {
        List<DataItem> dataItems = new ArrayList<>();

        Cursor cursor = null;
        if (category == null) {
            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS,
                    null, null, null, null, ItemsTable.COLUMN_TITLE);
        } else {
            String[] etag = {category};
            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS,
                    ItemsTable.COLUMN_ETAG + "=?", etag, null, null, ItemsTable.COLUMN_TITLE);
        }
//String title, String description, String posterPath, String publishedAt, String videoId, String etag, String channelTitle, int imageId)
        while (cursor.moveToNext()) {
            DataItem item = new DataItem();

            item.setTitle(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TITLE)));
            item.setDescription(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setPosterPath(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_POSTER_PATH)));
            item.setPublishedAt(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_PUBLISHED_AT)));
            item.setVideoId(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setEtag(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ETAG)));
            item.setChannelTitle(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CHANNEL_TITLE)));

            item.setImageId(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_IMAGE_ID)));

            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}
