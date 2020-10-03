package xyz.acrylicstyle.amongUs.util

open class SimpleRegistry<K, V> : Registry<K, V> {
    protected val map = HashMap<K, V>()

    override fun register(key: K, value: V) {
        if (map.containsKey(key)) throw IllegalArgumentException("Key $key in ${this::class.java.simpleName} is already registered")
        map[key] = value
    }

    override fun unregister(key: K) { map.remove(key) }

    override fun getOrThrow(key: K): V = map[key] ?: throw NullPointerException("Key $key in ${this::class.java.simpleName} is not registered")

    override fun get(key: K): V? = map[key]
}
