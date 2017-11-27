package com.chandan.android.xiaphiastask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawneshwer on 9/9/17.
 * This class will parse data from youtube API.
 */

public final class YoutubeResponse implements Parcelable {
    private String kind, etag, nextPageToken;
    private PageInfo pageInfo;
    private List<Item> items = new ArrayList<>();

    protected YoutubeResponse(Parcel in) {
        kind = in.readString();
        etag = in.readString();
        nextPageToken = in.readString();
    }

    public static final Creator<YoutubeResponse> CREATOR = new Creator<YoutubeResponse>() {
        @Override
        public YoutubeResponse createFromParcel(Parcel in) {
            return new YoutubeResponse(in);
        }

        @Override
        public YoutubeResponse[] newArray(int size) {
            return new YoutubeResponse[size];
        }
    };

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kind);
        parcel.writeString(etag);
        parcel.writeString(nextPageToken);
    }

    public static class PageInfo {
        private int totalResults, resultsPerPage;

        public int getTotalResults() {
            return totalResults;
        }

        public int getResultsPerPage() {
            return resultsPerPage;
        }
    }

    public static class Item {
        private String kind, etag;
        private Snippet snippet;

        public String getKind() {
            return kind;
        }

        public String getEtag() {
            return etag;
        }

        public Snippet getSnippet() {
            return snippet;
        }

        public static class Snippet {
            private String publishedAt, channelId, title, description, channelTitle, categoryId, liveBroadcastContent;
            private Thumbnails thumbnails;
            private List<String> tags = new ArrayList<>();

            public String getPublishedAt() {
                return publishedAt;
            }

            public String getChannelId() {
                return channelId;
            }

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

            public String getChannelTitle() {
                return channelTitle;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public String getLiveBroadcastContent() {
                return liveBroadcastContent;
            }

            public Thumbnails getThumbnails() {
                return thumbnails;
            }

            public List<String> getTags() {
                return tags;
            }

            public static class Thumbnails {
                @SerializedName("default")
                private Default _default;

                public Default getDefault() {
                    return _default;
                }

                public static final class Default {
                    private String url;
                    private int width, height;

                    public String getUrl() {
                        return url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public int getHeight() {
                        return height;
                    }
                }
            }
        }
    }


}
