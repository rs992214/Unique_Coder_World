def getRightArray(a):
    stack = []
    n = len(a)
    right = [-1]*n
    for i in range(n):
        while(not (len(stack) == 0)):
            peek = stack.pop()
            stack.append(peek) 
            if(a[peek] < a[i]):
                right[stack.pop()] = i
            else:
                break    
        stack.append(i)

    return right

def getLeftArray(a):
    stack = [];
    n = len(a)
    left = [-1]*n
    for i in range(n-1, 0, -1):
        while(not (len(stack) == 0)):
            peek = stack.pop()
            stack.append(peek) 
            if(a[peek] < a[i]):
                left[stack.pop()] = i
            else:
                break    
        stack.append(i)

    return left

arr = [5, 6, 4, 7, 11]
print(getLeftArray(arr))