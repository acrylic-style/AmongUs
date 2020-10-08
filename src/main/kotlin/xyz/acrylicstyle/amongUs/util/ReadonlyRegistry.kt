package xyz.acrylicstyle.amongUs.util

abstract class ReadonlyRegistry<K, V> : Registry<K, V> {
    abstract fun delegate(): Registry<K, V>

    override fun register(key: K, value: V) = throw UnsupportedOperationException("${this::class.java.simpleName} (delegating ${delegate()::class.java.simpleName}) is read-only")

    override fun unregister(key: K) = throw UnsupportedOperationException("${this::class.java.simpleName} (delegating ${delegate()::class.java.simpleName}) is read-only")

    override fun getOrThrow(key: K): V = delegate().getOrThrow(key)

    override fun get(key: K): V? = delegate().get(key)

    override fun copy(): Registry<K, V> {
        val delegate = delegate()
        return if (delegate is WritableRegistry) {
            SimpleReadonlyRegistry(delegate.copy())
        } else {
            SimpleReadonlyRegistry(delegate)
        }
    }
}
