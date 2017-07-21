package com.helionlabs.kfang.rail.models

import com.google.gson.annotations.SerializedName

data class StopItem(

	@field:SerializedName("sch_dep_dt")
	val schDepDt: String? = null,

	@field:SerializedName("stop_sequence")
	val stopSequence: String? = null,

	@field:SerializedName("sch_arr_dt")
	val schArrDt: String? = null,

	@field:SerializedName("stop_id")
	val stopId: String? = null,

	@field:SerializedName("stop_name")
	val stopName: String? = null
)