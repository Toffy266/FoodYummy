package com.swu.foodyummy

class MenuFood(
    var name: String,
    var how: String,
    var igd: String,
    var yt: String,
    var rname: String,
    var lat: Double,
    var lng: Double
) {

    init {
        this.name = name
        this.how = how
        this.igd = igd
        this.yt = yt
        this.rname = rname
        this.lat = lat
        this.lng = lng
    }

    @JvmName("getRname1")
    fun getRname(): String? {
        return rname
    }

    fun getLat(): Double? {
        return lat
    }

    fun getLng(): Double? {
        return lng
    }

    @JvmName("getName1")
    fun getName(): String? {
        return "― $name ―"
    }

    @JvmName("getHow1")
    fun getHow(): String? {
        return how
    }

    @JvmName("getIgd1")
    fun getIgd(): String? {
        return igd
    }

    @JvmName("getYt1")
    fun getYt(): String? {
        return yt
    }

}