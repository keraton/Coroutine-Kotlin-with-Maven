package samples

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main2() = runBlocking {
    val deferred: Deferred<Int> = async(Dispatchers.Default) {
        loadData()
    }
    log("waiting...")
    log(deferred.await())
}


fun main() = runBlocking {
    repeat(10) { // launch a lot of coroutines
        thread {
            sleep(5000L)
            print(".")
        }
    }
}

suspend fun loadData() : Int {
    log("loading...")
    // Coroutine
    val job = GlobalScope.async{
        delay(60_000)
    }
    job.cancel()

    // Coroutine
    GlobalScope.launch{

    }
    // Coroutine
    GlobalScope.launch{

    }


    delay(1000L)
    log("loaded!")
    return 42
}