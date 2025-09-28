fun main() {
    // Ввод текста
    println("Введите ваш код (для завершения ввода введите пустую строку):")
    val code = StringBuilder()
    while (true) {
        val line = readLine()
        if (line.isNullOrEmpty()) break
        code.append(line).append('\n')
    }

    // Запрос подстроки для поиска
    print("Введите подстроку для поиска: ")
    val searchQuery = readLine()?.trim() ?: ""

    // Поиск и вывод результатов
    if (searchQuery.isEmpty()) {
        println("Ошибка: пустая строка поиска")
        return
    }

    val lines = code.toString().lines()
    var found = false

    lines.forEachIndexed { index, line ->
        var startIndex = 0
        while (line.indexOf(searchQuery, startIndex).also { startIndex = it } != -1) {
            println("Найдено в строке ${index + 1}, позиция ${startIndex + 1}")
            startIndex += searchQuery.length
            found = true
        }
    }

    if (!found) {
        println("Вхождений не найдено")
    }
}