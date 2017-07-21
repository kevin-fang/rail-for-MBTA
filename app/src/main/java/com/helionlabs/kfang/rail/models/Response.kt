package com.helionlabs.kfang.rail.models

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("route_id")
	val routeId: String? = null,

	@field:SerializedName("route_name")
	val routeName: String? = null,

	@field:SerializedName("direction")
	val direction: List<DirectionItem?>? = null
)