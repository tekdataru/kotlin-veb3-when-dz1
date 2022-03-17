

fun main(){
    val userWasSecondsAgo = 1*60*60
    argToText(userWasSecondsAgo)

}

fun argToText(userWasSecondsAgo:Int) {
    val txt = when {
        (userWasSecondsAgo <= 60) -> "только что"
        (userWasSecondsAgo < (60 * 60)) -> "${userWasSecondsAgo / 60} ${minutesToText(userWasSecondsAgo / 60)} назад"
        (userWasSecondsAgo <= (60 * 60 * 24)) -> "${userWasSecondsAgo / 60 / 60} ${minutesToText(userWasSecondsAgo / 60 /60, true)} назад"
        (userWasSecondsAgo <= (60 * 60 * 24) * 2) -> "сегодня"
        (userWasSecondsAgo <= (60 * 60 * 24) * 3) -> "вчера"
        else -> "давно"
    }

    println(txt)
}

fun minutesToText(minutes:Int, inHours:Boolean = false):String{
    val temp = minutes % 10

    return when {
        (temp == 1) -> if (inHours) {"час"} else {"минуту"}
        (temp < 5 && temp > 0) -> if (inHours) {"часа"} else {"минуты"}
        else -> if (inHours) {"часов"} else {"минут"}
    }
}