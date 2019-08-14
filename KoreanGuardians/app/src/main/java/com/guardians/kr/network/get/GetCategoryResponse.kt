package com.guardians.kr.network.get

import android.os.Parcel
import android.os.Parcelable

data class GetCategoryResponse (
    var message : String,
    var data : ArrayList<GetCategoryResponseData>

)

class GetCategoryResponseData() : Parcelable{
    var category_idx : Int = 0
    var name : String = ""
    var item_cnt : Int = 0
    var img : String = ""
    var replace_words : ArrayList<String> = ArrayList()

    constructor(parcel: Parcel) : this() {
        category_idx = parcel.readInt()
        name = parcel.readString()
        item_cnt = parcel.readInt()
        img = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(category_idx)
        parcel.writeString(name)
        parcel.writeInt(item_cnt)
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GetCategoryResponseData> {
        override fun createFromParcel(parcel: Parcel): GetCategoryResponseData {
            return GetCategoryResponseData(parcel)
        }

        override fun newArray(size: Int): Array<GetCategoryResponseData?> {
            return arrayOfNulls(size)
        }
    }

}