text=input("Type in your text")
num=int(input("How many letter should be skipped"))
newText=""

alph=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]

for i in text:
    if not i.isalpha():
        newText = newText + i
    for j in range(0,25):


        if i == alph[j]:
            newText= newText + alph[j+num]



        else:
            continue



print(newText)
