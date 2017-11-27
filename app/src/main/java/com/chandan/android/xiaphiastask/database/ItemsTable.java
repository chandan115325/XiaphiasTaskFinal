package com.chandan.android.xiaphiastask.database;


public class ItemsTable {
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "videoId";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_POSTER_PATH = "posterPath";
    public static final String COLUMN_PUBLISHED_AT = "publishedAt";
    public static final String COLUMN_ETAG = "etag";
    public static final String COLUMN_CHANNEL_TITLE = "channelTitle";
    public static final String COLUMN_IMAGE_ID = "imageId";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION,
                     COLUMN_POSTER_PATH, COLUMN_PUBLISHED_AT, COLUMN_ETAG, COLUMN_CHANNEL_TITLE, COLUMN_IMAGE_ID};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_POSTER_PATH + " TEXT," +
                    COLUMN_PUBLISHED_AT + " TEXT," +
                    COLUMN_ETAG + " TEXT," +
                    COLUMN_CHANNEL_TITLE + " TEXT" +
                    COLUMN_IMAGE_ID + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
