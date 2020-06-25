package com.bitbreeds.p2p.peer

import kotlin.random.Random

/*
 * Copyright (c) Jonas Waage 09/06/2020
 *
 * Kotlin definitions and extension for https://github.com/feross/simple-peer
 */

@JsModule("simple-peer")
@JsNonModule
/**
 * WebRTC peer
 * @param configuration peer configuration
 */
external class Peer(configuration: Configuration = definedExternally) {

    /**
     * Attach handlers to named events
     * @param event the event
     * @param handle callback on event
     */
    fun on(event : String,handle : (data :dynamic) -> Unit)

    /**
     * @param data data to send
     */
    fun send(data : String)

    /**
     * @param signal received signal
     */
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

/**
 * @param urls stun or turn urls
 */
data class IceEntry(val urls : String)

/**
 * @param iceServers stun and turn servers
 */
data class Config(val iceServers: Array<IceEntry> = emptyArray())

/**
 * Peer configuration
 *
 * @param initiator whether this peer initiates the connection
 * @param channelName name of channel
 * @param channelConfig data channel config (unordered/ordered) and so o
 * @param offerOptions ?
 * @param answerOptions ?
 * @param sdpTransform munging
 * @param streams ?
 * @param trickle use trickle ice
 * @param allowHalfTrickle ?
 * @param wrtc ?
 * @param objectMode ?
 */
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

