package com.bitbreeds.p2p.wrapper

import com.bitbreeds.p2p.wrapper.*
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.WebSocket
import kotlin.browser.document

/*
 * Copyright (c) Jonas Waage 10/06/2020
 */

/*
const val wsUrl = "wss://135.ip-145-239-77.eu:50004/lobby"

fun main() {
    var gameId = "12345"
    var myPeer : Peer? = null;
    var myId : String? = null;
    var initiator = false;
    var externalId : String? = null;

    val create = document.createElement("button") as HTMLButtonElement
    create.textContent = "Create"

    val join = document.createElement("button") as HTMLButtonElement
    join.textContent = "Join"

    val ws = WebSocket(wsUrl);
    ws.onopen = {
        console.log("Open!")
    }

    ws.onmessage = { wsMessage ->
        val msg = wsMessage.data as String;
        console.log("RECEIVED WS $msg")
        val dt: WsProtocol = JSON.parse(msg);

        when {
            dt.joinEvent != null -> {
                myPeer = Peer(Configuration(initiator = initiator))

                if(!initiator) {
                    myId = dt.joinEvent.clientId
                }
                else {
                    externalId = dt.joinEvent.clientId
                }

                myPeer!!.on("signal") { signal ->
                    val signaling = JSON.stringify(signal)
                    val passOnRequest = PassOnRequest(myId!!, externalId!!, signaling)
                    val toSend = JSON.stringify(WsProtocol(gameId = gameId, passOn = passOnRequest));
                    console.log("SENDING $toSend")
                    ws.send(toSend)
                }

                myPeer!!.on("data") { data ->
                    console.log(data)
                }

                myPeer!!.on("connect") {
                    console.log("Connect")
                    myPeer!!.send("weee")
                }

            }
            dt.registerEvent != null -> {
                myId = dt.registerEvent.clientId
            }
            dt.passOn != null -> {
                if(initiator) {
                    myPeer!!.signal(dt.passOn.data)
                }
                else {
                    externalId = dt.passOn.senderId
                    myPeer!!.signal(dt.passOn.data)
                }
            }
            dt.pong != null -> {

            }
        }
        Any()
    }

    create.onclick = {
        initiator = true
        val prot = WsProtocol(gameId = gameId, registerRequest = RegisterRequest("Creator"))
        val toSend = JSON.stringify(prot);
        console.log("SENDING $toSend")
        ws.send(toSend)
    }

    join.onclick = {
        val prot = WsProtocol(gameId = gameId, joinRequest = JoinRequest("Joiner"))
        val toSend = JSON.stringify(prot)
        console.log("SENDING $toSend")
        ws.send(toSend)
    }

    document.body!!.appendChild(create)
    document.body!!.appendChild(join)
}
*/