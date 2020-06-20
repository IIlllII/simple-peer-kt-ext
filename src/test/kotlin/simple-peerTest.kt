package com.bitbreeds.p2p.wrapper

import com.bitbreeds.p2p.peer.Peer
import kotlin.test.Test

/*
 * Copyright (c) Jonas Waage 09/06/2020
 */

class SimplePeerTest {

    @Test
    fun testApi() {
        val peer1 = Peer()
        val peer2 = Peer()

        peer1.on("signal") { data ->
            print("Data")
            peer2.signal(data)
        }

        peer2.on("signal") { data ->
            print("Data")
            peer1.signal(data)
        }

        peer1.on("connect") {
            peer1.send("hey peer2, how is it going")
        }

        peer2.on("data") { data ->
            console.log("got a message from peer1: $data")
        }
    }


}