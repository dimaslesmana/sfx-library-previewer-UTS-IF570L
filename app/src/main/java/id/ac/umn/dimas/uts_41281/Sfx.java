package id.ac.umn.dimas.uts_41281;

import android.os.Parcel;
import android.os.Parcelable;

public class Sfx implements Parcelable {
    private String name;
    private String category;
    private int source;

    public static final Creator<Sfx> CREATOR = new Creator<Sfx>() {
        @Override
        public Sfx createFromParcel(Parcel in) {
            return new Sfx(in);
        }

        @Override
        public Sfx[] newArray(int size) {
            return new Sfx[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.category);
        dest.writeInt(this.source);
    }

    public Sfx(Parcel parcel) {
        this.name = parcel.readString();
        this.category = parcel.readString();
        this.source = parcel.readInt();
    }

    public Sfx(String name, String category, int source) {
        this.name = name;
        this.category = category;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
