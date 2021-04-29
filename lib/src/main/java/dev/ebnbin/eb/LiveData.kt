package dev.ebnbin.eb

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

fun <T> LiveData<T>.get(): T {
    @Suppress("UNCHECKED_CAST")
    return value as T
}

fun <T> MutableLiveData<T>.set(value: T, diff: Boolean = true) {
    if (!diff || this.value != value) {
        this.value = value
    }
}

fun <T> LiveData<T>.observe(
    owner: LifecycleOwner,
    valueGetter: () -> T,
    valueSetter: (value: T) -> Unit,
    diff: Boolean = true,
) {
    observe(owner) {
        if (!diff || valueGetter() != it) {
            valueSetter(it)
        }
    }
}

fun <T, S1> mapLiveData(
    source1: LiveData<S1>,
    init: Boolean = true,
    diff: Boolean = true,
    transform: (S1) -> T,
): LiveData<T> {
    return mapLiveData(
        sources = arrayOf(
            source1,
        ),
        init,
        diff,
    ) {
        @Suppress("UNCHECKED_CAST")
        transform(
            it[0] as S1,
        )
    }
}

fun <T, S1, S2> mapLiveData(
    source1: LiveData<S1>,
    source2: LiveData<S2>,
    init: Boolean = true,
    diff: Boolean = true,
    transform: (S1, S2) -> T,
): LiveData<T> {
    return mapLiveData(
        sources = arrayOf(
            source1,
            source2,
        ),
        init,
        diff,
    ) {
        @Suppress("UNCHECKED_CAST")
        transform(
            it[0] as S1,
            it[1] as S2,
        )
    }
}

fun <T, S1, S2, S3> mapLiveData(
    source1: LiveData<S1>,
    source2: LiveData<S2>,
    source3: LiveData<S3>,
    init: Boolean = true,
    diff: Boolean = true,
    transform: (S1, S2, S3) -> T,
): LiveData<T> {
    return mapLiveData(
        sources = arrayOf(
            source1,
            source2,
            source3,
        ),
        init,
        diff,
    ) {
        @Suppress("UNCHECKED_CAST")
        transform(
            it[0] as S1,
            it[1] as S2,
            it[2] as S3,
        )
    }
}

fun <T> mapLiveData(
    sources: Array<out LiveData<*>>,
    init: Boolean = true,
    diff: Boolean = true,
    transform: (Array<*>) -> T,
): LiveData<T> {
    fun onChanged(result: MediatorLiveData<T>, values: Array<*>) {
        result.set(transform(values), diff)
    }

    val result = MediatorLiveData<T>()
    sources.forEach {
        result.addSource(it) { value ->
            val values = sources.map { source ->
                if (it === source) {
                    value
                } else {
                    source.value
                }
            }.toTypedArray()
            onChanged(result, values)
        }
    }
    if (init) {
        val values = sources
            .map { it.value }
            .toTypedArray()
        onChanged(result, values)
    }
    return result
}
