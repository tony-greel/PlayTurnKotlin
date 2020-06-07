package com.diabin.festec.playturnkotlin.bean


data class CarouselBean(
    val data: List<Data>,
    val errorCode: Int,
    val errorMsg: String

) {
    override fun toString(): String {
        return "CarouselBean(data=$data, errorCode=$errorCode, errorMsg='$errorMsg')"
    }
}

data class Data(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String


) {
    override fun toString(): String {
        return "Data(desc='$desc', id=$id, imagePath='$imagePath', isVisible=$isVisible, order=$order, title='$title', type=$type, url='$url')"
    }
}