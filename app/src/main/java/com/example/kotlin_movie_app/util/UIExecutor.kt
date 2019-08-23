package com.example.kotlin_movie_app.util

import android.os.Handler
import java.util.concurrent.Executor

class UIExecutor : Executor {

    private var handler : Handler

    constructor(handler: Handler) {
        this.handler = handler
    }

    override fun execute(command: Runnable) {
        handler.post(command)
    }


}