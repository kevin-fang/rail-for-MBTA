package com.helionlabs.kfang.rail.models

import com.google.gson.annotations.SerializedName

data class DirectionItem(

	@field:SerializedName("direction_id")
	val directionId: String? = null,

	@field:SerializedName("trip")
	val trip: List<TripItem?>? = null,

	@field:SerializedName("direction_name")
	val directionName: String? = null
)