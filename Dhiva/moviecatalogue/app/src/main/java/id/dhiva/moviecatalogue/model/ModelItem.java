package id.dhiva.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelItem implements Parcelable {

    private int poster;
    private String title;
    private String rating;
    private String desc;
    private String genre;
    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public ModelItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.rating);
        dest.writeString(this.desc);
        dest.writeString(this.genre);
        dest.writeString(this.date);
    }

    private ModelItem(Parcel in) {
        this.poster = in.readInt();
        this.title = in.readString();
        this.rating = in.readString();
        this.desc = in.readString();
        this.genre = in.readString();
        this.date = in.readString();
    }

    public static final Creator<ModelItem> CREATOR = new Creator<ModelItem>() {
        @Override
        public ModelItem createFromParcel(Parcel source) {
            return new ModelItem(source);
        }

        @Override
        public ModelItem[] newArray(int size) {
            return new ModelItem[size];
        }
    };
}
