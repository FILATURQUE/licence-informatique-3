from bs4 import BeautifulSoup
import requests 

kl = open("King's_Landing.html",'r')
klsoup = BeautifulSoup(kl,'html.parser')

def titre(soup):
    print(soup.title.string)

titre(klsoup)

def afficher_h2(soup):
    for h2 in soup.find_all('h2'):
        print(h2.string)

afficher_h2(klsoup)

def nb_par_avec_lien(soup):
    nb_lien = 0
    for p in soup.find_all('p'):
        if p.find('a'):
            nb_lien+=1

    return nb_lien

print(nb_par_avec_lien(klsoup))

#question 4 <div class="mw-content-ltr mw-parser-output" lang="en" dir="ltr"

def liens(link):
    s = set()
    nb = 0
    web = requests.get(link).text
    soup = BeautifulSoup(web, 'html.parser')
    body = soup.find(id="content")
    #print(body) 
    for link in body.find_all('a'):
        if '/wiki' in link.get('href'):
            nb+=1
            s.add("https://iceandfire.fandom.com"+link.get('href'))
    return s

liens("https://iceandfire.fandom.com/wiki/Petyr_Baelish")


def liens_distance_rec(link, d, s):
    if d == 0:
        return s
    lien = ""
    web = requests.get(link).text
    soup = BeautifulSoup(web,'html.parser')
    body = soup.find(id="content")
    for link in body.find_all('a'):
        if '/wiki' in link.get('href'):
            lien = "https://iceandfire.fandom.com"+link.get('href')
            s.add(lien)
            liens_distance_rec(lien,d-1,s)

b = set()
liens_distance_rec("https://iceandfire.fandom.com/wiki/Petyr_Baelish",2,b)
print(len(b))