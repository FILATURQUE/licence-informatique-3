def mirror(str):
    return str[::-1]

def entrelacement(l1, l2):
    resultat = []
    n = min(len(l1), len(l2))  # longueur à alterner

    # Ajouter les éléments alternés
    for i in range(n):
        resultat.append(l1[i])
        resultat.append(l2[i])

    # Ajouter le reste de la liste la plus longue
    resultat += l1[n:]
    resultat += l2[n:]

    return resultat

# print(entrelacement([1,2,3],[4,5,6,7,8]))

class FileVide(Exception):
    """File vide impossible de retirer un element"""
    pass

class File:
    def __init__(self):
        self.file = []
    
    def add(self,x):
        self.file.append(x)
    
    def remove(self):
        if len(self.file) == 0:
            raise FileVide("File vide impossible de retirer un element")
        else:
            premier = self.file[0]
            del self.file[0]
            return premier

def vider(file):
    fSize = len(file.file)
    i = 0
    while i < fSize:
        print(file.remove())
        i = i + 1

f = File()
f.add(10)
f.add(20)
f.add(30)

vider(f)

class Mirror:
    def __init__(self,word):
        self.w = word
        self.i = len(self.w)

    def __iter__(self):
        return self
    
    def __next__(self):
        if self.i > len(self.w):
            raise StopIteration()
        else :
