interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>(
        questionText = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        questionText = "The sky is green. True or false",
        answer = false,
        difficulty = Difficulty.EASY
    )
    val question3 = Question<Int>(
        questionText = "How many days are there between full moons?",
        answer = 28,
        difficulty = Difficulty.HARD
    )

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    // Новый метод с использованием scope-функции let
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}