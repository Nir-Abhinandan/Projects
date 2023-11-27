start= input("Do you want to start:")
if start == ("Yes"):
  def print_arithmetic_progression(a, b, c):
    starting_number = a

    for i in range(0, c):
        print(starting_number)
        starting_number = starting_number + b
else start == ("No"):
  print("wrong choice")

a = int(input('What number do you want to start on: '))
b = int(input('What number do you want your sequence to change by: '))
c = int(input('what are the total amount of outputs you want: '))
print_arithmetic_progression(a, b, c)
