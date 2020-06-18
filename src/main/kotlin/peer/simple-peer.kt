package com.bitbreeds.p2p.peer

import kotlin.random.Random

/*
 * Copyright (c) Jonas Waage 09/06/2020
 */

@JsModule("simple-peer")
@JsNonModule
external class Peer(configuration: Configuration = definedExternally) {

    fun on(event : String,handle : (data :dynamic) -> Unit)

    fun send(data : String)

    fun signal(signal : dynamic)
}

const val HEX_LETTERS = "0123456789ABCDEF";

fun randomStringOfLength(lgt : Int) : String {
    if(lgt < 1) {
        throw IllegalArgumentException("lgt must be above 1")
    }
    return (0 until lgt)
            .map{ getRandomChar() }
            .joinToString("")
}

fun getRandomChar() :Char {
    return HEX_LETTERS[Random.nextInt(HEX_LETTERS.length)]
}

data class IceEntry(val urls : String)

data class Config(val iceServers: Array<IceEntry> = emptyArray())

data class Configuration(
        val initiator : Boolean = false,
        val channelName : String = randomStringOfLength(8),
        val channelConfig : dynamic = null,
        val config : Config = Config(),
        val offerOptions : dynamic = null,
        val answerOptions : dynamic = null,
        val sdpTransform : (sdp:String) -> String = {sdp->sdp},
        val stream : Boolean = false,
        val streams : Array<String> = emptyArray(),
        val trickle : Boolean = true,
        val allowHalfTrickle : Boolean = false,
        val wrtc : dynamic = null,
        val objectMode : Boolean = false
)

