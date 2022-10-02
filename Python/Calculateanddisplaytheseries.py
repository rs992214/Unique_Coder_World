#Program to find sum of series 1 + 1/2 + 1/3 + 1/4 + .. + 1/n

def sum(n):
    i = 1
    s = 0.0
    for i in range(1, n+1):
        s = s + 1/i;
    return s;
 
# Driver Code
n = 5
print("Sum is", round(sum(n), 6))