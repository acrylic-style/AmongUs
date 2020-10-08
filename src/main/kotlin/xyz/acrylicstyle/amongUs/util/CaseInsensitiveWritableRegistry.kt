package xyz.acrylicstyle.amongUs.util

class CaseInsensitiveWritableRegistry<V>(map: MutableMap<String, V>): WritableRegistry<String, V>(map) {
    constructor(): this(HashMap())

    override fun get(key: String): V? = super.get(key.toLowerCase())
    override fun register(key: String, value: V) = super.register(key.toLowerCase(), value)
    override fun unregister(key: String) = super.unregister(key.toLowerCase())
    override fun getOrThrow(key: String): V = super.getOrThrow(key.toLowerCase())
    override fun copy(): Registry<String, V> = CaseInsensitiveWritableRegistry(HashMap(map))
}
