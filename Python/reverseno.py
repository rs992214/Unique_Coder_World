# Get the number from user manually 
num = int(input("Enter your favourite number: "))
 
# Initiate value to null
test_num = 0
 
# Check using while loop
 
while(num>0):
  #Logic
  remainder = num % 10
  test_num = (test_num * 10) + remainder
  num = num//10
 
# Display the result
print("The reverse number is : {}".format(test_num))
