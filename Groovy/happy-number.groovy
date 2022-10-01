def isHappy(n){

    ans = n
    str_n = n.toString()
    
    
    if (ans == 1 || ans == 7){
        return true
    }

    len_str = str_n.length()-1
    
    while (ans > 9){
        ans = 0
        for (idx in 0..len_str){
            ans += (Integer.parseInt(str_n[idx]) ** 2)
        }
        str_n = ans.toString()
    }

    // check if in range 2 < 9
    if (ans == 7 || ans == 1){
        return true
    }

    return false
}

def number = System.console().readLine 'Is the number is happy?. What is your number: '
println isHappy(Integer.parseInt(number))