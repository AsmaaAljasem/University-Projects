import re

str_password_list = input("Enter the list of passwords separated by comma: ")
password_list = str_password_list.split(",")
count = 0
print("OUTPUT:")
for password in password_list:
    if len(password)>=12 and len(password) <=25 :
        low = re.search(r"[a-z]", password)
        up = re.search(r"[A-Z]", password)
        num = re.search(r"[0-9]", password)
        suffix = re.search('@gmail.com$', password)
        has_all = all((low, up, num, suffix))

        if has_all:
            
            if count == 0:
                print(password, end='')
            else:
                print(","+password, end='')

            count = count+1

print("\n")
