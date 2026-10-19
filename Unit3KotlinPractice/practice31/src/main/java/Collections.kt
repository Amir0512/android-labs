fun main() {
    // =============================================================
    // 1. ARRAYS (МАССИВЫ)
    // =============================================================
    println("=== 1. ARRAYS ===")
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystemArray = rockPlanets + gasPlanets

    println(solarSystemArray[0])
    println(solarSystemArray[1])
    println(solarSystemArray[2])
    println(solarSystemArray[3])
    println(solarSystemArray[4])
    println(solarSystemArray[5])
    println(solarSystemArray[6])
    println(solarSystemArray[7])

    solarSystemArray[3] = "Little Earth"
    println(solarSystemArray[3])

    val newSolarSystemArray = arrayOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"
    )
    println(newSolarSystemArray[8])


    // =============================================================
    // 2. LISTS (СПИСКИ)
    // =============================================================
    println("\n=== 2. LISTS ===")
    val solarSystemList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemList.size)
    println(solarSystemList[2])
    println(solarSystemList.get(3))
    println(solarSystemList.indexOf("Earth"))
    println(solarSystemList.indexOf("Pluto"))

    for (planet in solarSystemList) {
        println(planet)
    }

    val mutableSolarList = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    mutableSolarList.add("Pluto")
    mutableSolarList.add(3, "Theia")

    mutableSolarList[3] = "Future Moon"
    println(mutableSolarList[3])
    println(mutableSolarList[9])

    mutableSolarList.removeAt(9)
    mutableSolarList.remove("Future Moon")

    println(mutableSolarList.contains("Pluto"))
    println("Future Moon" in mutableSolarList)


    // =============================================================
    // 3. SETS (МНОЖЕСТВА)
    // =============================================================
    println("\n=== 3. SETS ===")
    val solarSystemSet = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemSet.size)

    solarSystemSet.add("Pluto")
    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))

    // Дубликат игнорируется
    solarSystemSet.add("Pluto")
    println(solarSystemSet.size)

    solarSystemSet.remove("Pluto")
    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))


    // =============================================================
    // 4. MAPS (СЛОВАРИ)
    // =============================================================
    println("\n=== 4. MAPS ===")
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size)

    solarSystem["Pluto"] = 5
    println(solarSystem.size)

    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))

    solarSystem.remove("Pluto")
    println(solarSystem.size)

    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}