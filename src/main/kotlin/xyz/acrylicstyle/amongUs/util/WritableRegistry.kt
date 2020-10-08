package xyz.acrylicstyle.amongUs.util

open class WritableRegistry<K, V> : Registry<K, V> {
    constructor(): this(HashMap())
    constructor(map: MutableMap<K, V>) { this.map = map }

    protected val map: MutableMap<K, V>

    override fun register(key: K, value: V) {
        if (map.containsKey(key)) throw IllegalArgumentException("Key $key in ${this::class.java.simpleName} is already registered")
        map[key] = value
    }
    override fun unregister(key: K) { map.remove(key) }
    override fun getOrThrow(key: K): V = map[key] ?: throw NullPointerException("Key $key in ${this::class.java.simpleName} is not registered")
    override fun get(key: K): V? = map[key]
    override fun copy(): Registry<K, V> = WritableRegistry(map)
}
