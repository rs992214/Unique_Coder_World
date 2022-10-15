import requests
import re
 
url = input("Enter the URL: ")
 
html = requests.get(url).text
 
links = re.findall('"(https?://.*?)"', html)
 
for link in links:
    print(link)
