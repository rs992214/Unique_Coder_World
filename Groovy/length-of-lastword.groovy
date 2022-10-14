def lengthOfLastWord(str){

    if (str == null || str.isEmpty()){

        return 0
    }

    return str.tokenize(' ').last().length()
}


def string = System.console().readLine 'Length of last word. Your sentence?: '
println(sprintf("Length of word: %s", lengthOfLastWord(string)))