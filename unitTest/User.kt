package br.com.roquebuarque.dsl.unittest


data class User(val name:String, var balance: Double) {

    fun withDraw(value: Double){
        this.balance -= value
    }
}



