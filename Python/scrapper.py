from bs4 import BeautifulSoup
import requests

source = requests.get('https://en.wikipedia.org/wiki/J.A.R.V.I.S.').text
soup = BeautifulSoup(source, "lxml")

welcome = soup.find('div', class_="welcome")
print(soup.prettify())