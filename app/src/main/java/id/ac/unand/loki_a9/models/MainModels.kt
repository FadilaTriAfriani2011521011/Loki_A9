package id.ac.unand.loki_a9.models

import android.os.Parcel
import android.os.Parcelable

data class MainModels(var image_vw : Int) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image_vw)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainModels> {
        override fun createFromParcel(parcel: Parcel): MainModels {
            return MainModels(parcel)
        }

        override fun newArray(size: Int): Array<MainModels?> {
            return arrayOfNulls(size)
        }
    }
}
