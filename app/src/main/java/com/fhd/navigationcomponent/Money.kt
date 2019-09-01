package com.fhd.navigationcomponent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


/*
* Parcelable : If you want to send custom objects from one activity
* to another.Passing primitive datatypes between activities is straight froward,
* you can use intent.putExtra() and put anything like boolean,strings and integers etc.
*  However you can’t pass custom objects  between activities in this way.
* To pass custom objects between activities/services, we  must implement
*  parcelable or serializable interface to custom class. However parcelable
* is specifically designed for android and is advised for best performance.
* The most basic use case for using Parcelable is when we need to pass a
* model from one activity to another.
* Bundle :
*
* */
@Parcelize
data class Money(val amount: BigDecimal) : Parcelable {

}