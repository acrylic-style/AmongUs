package xyz.acrylicstyle.amongUs.util

class CaseInsensitiveRegistry<V>: SimpleRegistry<String, V>() {
    override fun get(key: String): V? = super.get(key.toLowerCase())
    override fun register(key: String, value: V) = super.register(key.toLowerCase(), value)
    override fun unregister(key: String) = super.unregister(key.toLowerCase())
    override fun getOrThrow(key: String): V = super.getOrThrow(key.toLowerCase())
}
