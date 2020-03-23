package br.com.roquebuarque.dsl

import br.com.roquebuarque.dsl.unittest.User
import com.google.common.truth.Truth
import org.junit.Test

class UserTest() {

    @Test
    fun withDraw() {

        given {
            User("Roque", 200.0)
        }.test {
            withDraw(50.0)
        }.assert {
            balance isEquals 150.0
        }

        //Given
        val user = User("Roque", 200.0)

        //When
        user.withDraw(50.0)

        //Then
        Truth.assertThat(user.balance).isEqualTo(150.0)
    }
}

fun <T, R> T.given(block: (T) -> R): R {
    return block(this)
}

fun <T> T.test(block: T.() -> Unit): T {
    block()
    return this
}

fun <T> T.assert(block: T.() -> Unit) {
    this.block()
}

infix fun Double.isEquals(value: Double){
    Truth.assertThat(this).isEqualTo(value)

}


