s=input("Enter a string to check for valid parenthesis: ")
l=[]
flag = True
if(len(s)==1):
    return False
else:
    for i in range(0,len(s)):
        if(s[i]=="(" or s[i]=="{" or s[i]=="["):
            l.append(s[i])
        else:
            if(len(l)!=0 and l[len(l)-1]=="(" and s[i]==")"):
                l.pop()
            elif(len(l)!=0 and l[len(l)-1]=="{" and s[i]=="}"):
                l.pop()
            elif(len(l)!=0 and l[len(l)-1]=="[" and s[i]=="]"):
                l.pop()
            else:
                return False
if(len(l)==0):
    return True
