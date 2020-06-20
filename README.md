simple-peer-kt-ext
-------------------------
Kotlin definitions and extension for the awesome [simple-peer](https://github.com/feross/simple-peer)
Meant to be used in kotlin javascript projects.

## Gradle use
Add to build.gradle.kts
```
dependencies {
    implementation("com.bitbreeds.p2p","simple-peer-kt-ext","1.0-SNAPSHOT")
    implementation(npm("simple-peer","9.7.2"))
}
```

## Use
For use of simple peer, see [https://github.com/feross/simple-peer](https://github.com/feross/simple-peer).
The first example there can be implemented like this using kotlin.

In a real case, peers need to be in different browsers, and
share signals over some other communication (typically websocket).
```
fun main() {
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
```