class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    // 1. map() — форматирование меню со стоимостью
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }

    println("--------------------------------")

    // 2. filter() — фильтрация мягкого печенья
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("--------------------------------")

    // 3. groupBy() — разделение на группы в Map
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softMenuFromGroup = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies (из группы):")
    softMenuFromGroup.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies (из группы):")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("--------------------------------")

    // 4. sortedBy() — сортировка по алфавиту имени (it.name)
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}