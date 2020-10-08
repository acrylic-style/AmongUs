package xyz.acrylicstyle.amongUs.util

class SimpleReadonlyRegistry<K, V>(private val delegate: Registry<K, V>) : ReadonlyRegistry<K, V>() {
    override fun delegate(): Registry<K, V> = delegate
    override fun copy(): Registry<K, V> = SimpleReadonlyRegistry(delegate.copy())
}
