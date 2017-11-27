package com.chandan.android.xiaphiastask.database;

import android.provider.BaseColumns;

/**
 * Created by delaroy on 5/27/17.
 */
public class FavoriteContract {

    public static final class FavoriteEntry implements BaseColumns {

        public static final String TABLE_NAME = "rcb_data";
        public static final String COLUMN_ETAG = "etag";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_POSTER_PATH = "thumbnail";
        public static final String COLUMN_PUBLISHED_AT = "publishedAt";
    }
}
