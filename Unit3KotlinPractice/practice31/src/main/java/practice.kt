// Task 2: Создать enum class Daypart со значениями MORNING, AFTERNOON, EVENING
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

// Task 1 & 2: Создать data class Event с полями title, description (null по умолчанию), daypart типа Daypart и durationInMinutes
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// Task 7: Добавить свойство-расширение durationOfEvent для Event, возвращающее "short" (< 60 мин) или "long"
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    // Task 1: Создать экземпляр Event и вывести его в консоль
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15
    )
    println(event)

    // Task 3: Объединить все события в один список events типа MutableList<Event>
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

    // Task 4: Отфильтровать события короче 60 минут и вывести строку с их количеством
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    // Task 5: Сгруппировать события по времени суток (daypart) и вывести количество событий для каждого периода
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, eventsList) ->
        println("$daypart: ${eventsList.size} events")
    }

    // Task 6: Получить и вывести название последнего события дня с помощью функции last()
    println("Last event of the day: ${events.last().title}")

    // Task 7: Вывести продолжительность первого события дня через вызов durationOfEvent
    println("Duration of first event of the day: ${events[0].durationOfEvent}")}
