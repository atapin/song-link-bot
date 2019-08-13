package com
package andreyatapin
package slb

import zio.RIO

trait SonglinkApi extends Serializable {
    val api: SonglinkApi.Service[Any]
}

object SonglinkApi {
    trait Service[R] {
        def get(songUrl: String): RIO[R, Song]
    }
}