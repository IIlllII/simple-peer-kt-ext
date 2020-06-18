package com.bitbreeds.p2p.wrapper

/*
 * Copyright (c) Jonas Waage 10/06/2020
 */

data class PassOnRequest(val senderId : String,val clientId : String, val data: String)

data class JoinRequest(val name : String)

data class JoinEvent(val name: String, val clientId : String);

data class RegisterRequest(val name: String);

data class RegisterEvent(val name: String, val clientId : String);

data class Ping(val time : String)

data class Pong(val time : String)

data class WsProtocol(
        val gameId : String,
        val passOn : PassOnRequest? = null,
        val joinRequest: JoinRequest? = null,
        val joinEvent : JoinEvent? = null,
        val registerRequest: RegisterRequest? = null,
        val registerEvent: RegisterEvent? = null,
        val ping : Ping? = null,
        val pong : Pong? = null) {

    init {
        var count = 0;
        passOn ?: count++
        joinRequest ?: count++
        joinEvent ?: count++
        registerRequest ?: count++
        registerEvent ?: count++
        ping ?: count++
        pong ?: count++
        check(count == 6) { "WsProtocol should have 1 entry only was ${7-count} with data $this" }
    }
}