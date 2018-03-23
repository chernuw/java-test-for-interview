package net.itspartner.test.n3

/**
 * Description: Application calculates sum of ages of all users and finds the eldest user
 * Task: Refactor, use Kotlin style constructions. Calculate average age of users.
 */
@SuppressWarnings("all")
fun main(args: Array<String>) {

    val users: MutableList<User> = mutableListOf(
        User("Pavel", 50),
        User("Suresh", 50),
        User("Robin", 50)
    )

    val eldest = users.maxWith(Comparator { o1, o2 -> o1.age.compareTo(o2.age) })
    val sum = users.toTypedArray().sumBy { user -> user.age }
    val avg = sum / users.size

    println("The eldest user is ${eldest?.name}")
    println("Sum of all ages is $sum")
    println("The average age of users is $avg")
}