import hmac
import base64
import hashlib
f=open("public.pem")
key=f.read()
str="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbiI6ImFkbWluIn0"
sig=base64.urlsafe_b64encode(hmac.new(bytes(key, encoding='utf-8'),str.encode('utf-8'),hashlib.sha256).digest()).decode('UTF-8').rstrip("=")
print(str+"."+sig)