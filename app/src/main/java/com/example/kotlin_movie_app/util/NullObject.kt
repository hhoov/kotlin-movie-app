package com.example.kotlin_movie_app.util

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object NullObject {

    private class NullInvocationHandler : InvocationHandler {

        @Throws(Throwable::class)
        override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
            val returnType = method.returnType
            if (returnType == java.lang.Byte.TYPE || returnType == java.lang.Short.TYPE || returnType == Integer.TYPE ||
                returnType == java.lang.Long.TYPE || returnType == java.lang.Float.TYPE || returnType == java.lang.Double.TYPE ||
                returnType == Character.TYPE) {
                return 0
            } else if (returnType == java.lang.Boolean.TYPE) {
                return false
            } else {
                return null
            }
        }
    }

    fun <T> create(nullObjClazz: Class<T>): T {
        val proxy = Proxy.newProxyInstance(nullObjClazz.classLoader, arrayOf<Class<*>>(nullObjClazz), NullInvocationHandler())
        return nullObjClazz.cast(proxy)
    }

}