package com.helionlabs.kfang.rail.models

import com.google.gson.annotations.SerializedName

data class TripItem(

	@field:SerializedName("trip_id")
	val tripId: String? = null,

	@field:SerializedName("stop")
	val stop: List<StopItem?>? = null,

	@field:SerializedName("trip_name")
	val tripName: String? = null
)