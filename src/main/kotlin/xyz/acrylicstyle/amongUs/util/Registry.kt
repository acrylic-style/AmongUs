package xyz.acrylicstyle.amongUs.util

interface Registry<K, V> {
    fun register(key: K, value: V)
    fun unregister(key: K)
    fun getOrThrow(key: K): V
    fun get(key: K): V?
    fun copy(): Registry<K, V>
}
