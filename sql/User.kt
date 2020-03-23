object User {
    operator fun invoke(query: String): User {
        this.query += query
        return this
    }
    private var query = ""
    val age: User
        get() = this.where("age")

    val name: User
        get() = this.where("name")

    private fun where(field: String): User {
        query+= " WHERE $field"
        return this
    }

    infix fun eq(age: Int) {
        println("$query = $age")
    }

    inline infix fun select(block: User.() -> Unit) {
        User("SELECT * FROM users").block()
    }
}