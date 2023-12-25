text=input("Type in your text")

newText=""

alph=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
alph2= list(reversed(alph))

for i in text:
    if i.isspace():
        newText = newText + " "
    for j in range(0,26):


        if i == alph[j]:
            newText= newText + alph2[j]





        else:
            continue



print(newText)
