# Python program to check validation of password
# Module of regular expression is used with search()
import re
password_split = input("\nEnter Password: \n")    
password = password_split.split(",")
print()
print("Correct passwords: ")
for passw in password:
    flag = 0

    if (len(passw)<12 or len(passw) >25):
        flag = -1
    elif not re.search("[^\s]+@gmail.com", passw):
        flag = -1
    elif not re.search("[a-z]", passw):
        flag = -1
    elif not re.search("[A-Z]", passw):
        flag = -1
    elif not re.search("[0-9]", passw):
        flag = -1
    else:
        flag = 0
  
    if flag ==0:
        print(passw)
