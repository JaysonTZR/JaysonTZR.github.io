#TAN ZHI RONG
#TP068223

def Main_Page(): #Main Page for every user before login to their specific user interface
    print("\n*********************************************")
    print("\tWelcome to OCEAN Sdn Bhd OPMS")
    print("*********************************************")
    main_choice = int(input("Please select your user.\n" #User function selection
                                "1. Admin\n"
                                "2. New Customer\n"
                                "3. Registered Customer\n"
                                "4. Exit\n"
                                "Please enter your choice here: "))
    if(main_choice == 1):
        Admin_Login_Page()
    elif(main_choice == 2):
        New_Customer_Page()
    elif(main_choice == 3):
        Registered_Customer_Login_Page()
    elif(main_choice == 4):
        Exit_Page()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Admin_Login_Page(): #Admin Login Page for only admins
    print("\n***************************")
    print("\tAdmin Login")
    print("***************************")
    admin_login = open("admin_login.txt", "r") #Read admin_login file
    username_admin_0 = input("Enter your username: ")
    password_admin_0 = input("Enter your password: ")

    if not len(username_admin_0 or password_admin_0) < 1: #If length of username/password < 1
        username_admin_store = [] #List to store admin username
        password_admin_store = [] #List to store admin password
        for i in admin_login: #Use for loop to split and strip text in the file
            username_admin,password_admin = i.split(", ") #Split the username and password with ", "
            password_admin = password_admin.strip() #Let the password to stand alone without any spaces beside
            username_admin_store.append(username_admin) #To append admin username in the list
            password_admin_store.append(password_admin) #To append admin password in the list
        data_admin = dict(zip(username_admin_store, password_admin_store)) #Zip the data from dictionary

        try:
            if(data_admin[username_admin_0]): #Check if the data contains the username
                try:
                    if(password_admin_0 == data_admin[username_admin_0]): #Check if password matches username
                        print("Login successful.")
                        Admin_Page()
                    else:
                        print("Password or Username is incorrect.")
                        Admin_Login_Page()
                except:
                    print("Password or Username incorrect.")
                    Admin_Login_Page()
            else:
                print("Username doesn't exists.")
                Admin_Login_Page()
        except:
            print("Login error.")
            Main_Page()
    pass

def Admin_Page(): #Admin Page for only admins, no other users allowed
    print("\n******************************")
    print("\tWelcome Admins")
    print("******************************")
    admin_choice = int(input("Please select the function.\n" #Admin function selection
                                "1. Upload Medicine Details in System\n"
                                "2. View All Uploaded Medicines\n"
                                "3. Update/Modify Medicine Information\n"
                                "4. Delete Medicine Information\n"
                                "5. Search Specific Medicine Detail\n"
                                "6. View All Orders of Customers\n"
                                "7. Search Order of Specific Customer\n"
                                "8. Exit\n"
                                "Please enter your choice here: "))
    if(admin_choice == 1):
        Upload_Medicine()
    elif(admin_choice == 2):
        View_Medicine()
    elif(admin_choice == 3):
        Update_Medicine()
    elif(admin_choice == 4):
        Delete_Medicine()
    elif(admin_choice == 5):
        Search_Medicine()
    elif(admin_choice == 6):
        View_Customer_Order()
    elif(admin_choice == 7):
        Search_Customer_Order()
    elif(admin_choice == 8):
        Main_Page()
    else:
        print("Invalid option.")
        Admin_Page()
    pass

def New_Customer_Page(): #New Customer Page for customers who haven't register their accounts
    print("\n*************************************")
    print("\tWelcome New Customers")
    print("*************************************")
    new_customer_user_choice = int(input("Please select the function.\n" #New customer function selection
                                            "1. Register New Profile\n"
                                            "2. View All Medicine Details\n"
                                            "3. Exit\n"
                                            "Please enter your choice here: "))
    if(new_customer_user_choice == 1):
        New_Customer_Registration()
    elif(new_customer_user_choice == 2):
        View_Medicine()
    elif(new_customer_user_choice == 3):
        Main_Page()
    else:
        print("Invalid option.")
        New_Customer_Page()
    pass

def New_Customer_Registration(): #New Customer Registration for new customers to register their accounts
    print("\n*****************************************")
    print("\tNew Customer Registration")
    print("*****************************************")
    customer_login = open("customer_login.txt", "r") #Read customer_login file
    username_customer_0 = input("Enter your username: ")
    password_customer_0 = input("Enter your password: ")
    password1_customer_0 = input("Confirm your password: ")
    customer_info = open("customer_info.txt", "a") #Read customer_info file
    name_customer_0 = input("Enter your name: ")
    address_customer_0 = input("Enter your address: ")
    email_customer_0 = input("Enter your Email ID: ")
    contactno_customer_0 = input("Enter your contact number: ")
    gender_customer_0 = input("Enter your gender: ")
    dob_customer_0 = input("Enter your date of birth: ")
    username_customer_store = [] #List to store customer username
    password_customer_store = [] #List to store customer password
    for i in customer_login: #Use for loop to split and strip text in the file
        username_customer,password_customer = i.split(", ") #Split the username and password with ", "
        password_customer = password_customer.strip() #Let the password to stand alone without any spaces beside
        username_customer_store.append(username_customer) #To append customer username in the list
        password_customer_store.append(password_customer) #To append customer password in the list

    if(password_customer_0 != password1_customer_0): #Check if entered password and comfirmed password is same or not
        print("Password doesn't match, try again.")
        New_Customer_Registration()
    else:
        if(len(password_customer_0) <= 6): #Password length must be over 6
            print("Password too short, try again.")
            New_Customer_Registration()
        elif(username_customer_0 in username_customer_store): #Check if username existed in the username vault
            print("Username exists, try again.")
            New_Customer_Registration()
        else:
            customer_login = open("customer_login.txt", "a") #Append customer_login file
            customer_login.write(username_customer_0+", "+password_customer_0+"\n") #Write the entered data
            customer_login.close()
            customer_info.write("Username: "+username_customer_0+"\n")
            customer_info.write("Password: "+password_customer_0+"\n")
            customer_info.write("Name: "+name_customer_0+"\n")
            customer_info.write("Address: "+address_customer_0+"\n")
            customer_info.write("Email ID: "+email_customer_0+"\n")
            customer_info.write("Contact no.: "+contactno_customer_0+"\n")
            customer_info.write("Gender: "+gender_customer_0+"\n")
            customer_info.write("Date of Birth: "+dob_customer_0+"\n\n")
            customer_info.close()
            print("Account created successfully.")
            Registered_Customer_Login_Page()
    pass

def Registered_Customer_Login_Page(): #Registered Customer Login Page for customers to login their accounts
    print("\n******************************")
    print("\tCustomer Login")
    print("******************************")
    customer_login = open("customer_login.txt", "r") #Read customer_login file
    username_customer_0 = input("Enter your username: ")
    password_customer_0 = input("Enter your password: ")

    if not len(username_customer_0 or password_customer_0) < 1: #If length of username/password < 1
        username_customer_store = [] #List to store customer username
        password_customer_store = [] #List to store customer password
        for j in customer_login: #Use for loop to split and strip text in the file
            username_customer,password_customer = j.split(", ") #Split the username and password with ", "
            password_customer = password_customer.strip() #Let the password to stand alone without any spaces beside
            username_customer_store.append(username_customer) #To append customer username in the list
            password_customer_store.append(password_customer) #To append customer password in the list
        data_customer = dict(zip(username_customer_store, password_customer_store))

        try:
            if(data_customer[username_customer_0]): #Check if the data contains the username
                try:
                    if(password_customer_0 == data_customer[username_customer_0]): #Check if password matches username
                        print("Login successful.")
                        Registered_Customer_Page()
                    else:
                        print("Password or Username is incorrect.")
                        Registered_Customer_Login_Page()
                except:
                    print("Password or Username incorrect.")
                    Registered_Customer_Login_Page()
            else:
                print("Username doesn't exists.")
                Registered_Customer_Login_Page()
        except:
            print("Login error.")
            Main_Page()
    pass

def Registered_Customer_Page(): #Registered Customer Login Page for customers who logged in their accounts
    print("\n*********************************")
    print("\tWelcome Customers")
    print("*********************************")
    registered_customer_user_choice = int(input("Please select the function.\n" #Registered Customer fuction selection
                                                    "1. View All Medicine Details\n"
                                                    "2. Place Order of Medicines and Do Payment\n"
                                                    "3. View Own Order\n"
                                                    "4. View Personal Information\n"
                                                    "5. Exit\n"
                                                    "Please enter your choice here: "))
    if(registered_customer_user_choice == 1):
        View_Medicine()
    elif(registered_customer_user_choice == 2):
        Place_Order_and_Payment()
    elif(registered_customer_user_choice == 3):
        View_Own_Order()
    elif(registered_customer_user_choice == 4):
        View_Personal_Info()
    elif(registered_customer_user_choice == 5):
        Main_Page()
    else:
        print("Invalid option.")
        Registered_Customer_Page()
    pass

def Exit_Page():
    print("\nHave a nice day, goodbye!")
    pass

def Upload_Medicine(): #Upload Medicine Details in System (Admin)
    print("\n*******************************************")
    print("\tUpload Medicine Information")
    print("*******************************************")
    medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
    medicine_ref_code_0 = input("Medicine's reference code: ") 
    medicine_name_0 = input("Medicine's name: ")
    medicine_exp_date_0 = input("Medicine's expiry date: ")
    medicine_price_0 = input("Medicine's price: ")
    medicine_sideeffect_0 = input("Medicine's side effect: ")
    medicine_dosage_0 = input("Medicine's dosage: ")

    medicine_info = open("medicine_info.txt", "a") #Append medicine_info file
    medicine_info.write("Medicine's reference code: "+medicine_ref_code_0+"\n"
                        "Medicine's name: "+medicine_name_0+"\n"
                        "Medicine's expiry date: "+medicine_exp_date_0+"\n"
                        "Medicine's price: "+medicine_price_0+"\n"
                        "Medicine's side effect: "+medicine_sideeffect_0+"\n"
                        "Medicine's dosage: "+medicine_dosage_0+"\n\n")
    medicine_info.close() #Close medicine_info file
    print("Medicine uploaded successfully.\n")

    return_yorn = str(input("Return to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        Upload_Medicine()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def View_Medicine(): #View All Uploaded Medicines (Admin and Customers)
    print("\n************************************")
    print("\tMedicine Information")
    print("************************************")
    medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
    print(medicine_info.read()) #Print file content
    medicine_info.close() #Close medicine_info file

    return_yorn = str(input("Return to Main Page? [y/n]: "))
    if(return_yorn == "y"):
        Main_Page()
    elif(return_yorn == "n"):
        View_Medicine()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Update_Medicine(): #Update/Modify Medicine Information (Admin)
    print("\n*******************************************")
    print("\tUpdate Medicine Information")
    print("*******************************************")
    medicine_info = open("medicine_info.txt","r") #Read medicine_info file
    print(medicine_info.read()) #Print file content
    medicine_info.close() #Close medicine_info file

    medicine_info = open("medicine_info.txt","r")
    word_to_be_replace = input("Enter the information that need to be modify: ")  
    replace_word = input("Enter the modified information: ")
    update = medicine_info.read() #Read file contents to string
    update = update.replace(word_to_be_replace, replace_word) #Replace the occurrences of the required string
    medicine_info.close() #Close file
    medicine_info = open("medicine_info.txt", "w") #Write medicine_info file
    medicine_info.write(update) #Overwrite the file with the resulting update data
    medicine_info.close() #Close medicine_info file
    print("Medicine details updated successfully.")
    
    return_yorn = str(input("Return to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        Update_Medicine()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Delete_Medicine(): #Delete Medicine Information (Admin)
    print("\n*******************************************")
    print("\tDelete Medicine Information")
    print("*******************************************")
    medicine_info = open("medicine_info.txt", "r") #Open medicine_info file
    print(medicine_info.read()) #Read and print medicine_info file content
    delete_medicine_info = input("Enter the medicine's reference code for the information to be deleted: ")
    medicine_info.close()

    medicine_info = open("medicine_info.txt", "r")
    se = set() #Store the lines in se
    for l,m in enumerate(medicine_info): #Adds a counter as the key of the lines in medicine_info
        if "Medicine's reference code: "+delete_medicine_info in m: #If specific lines in m
            se.update(range(l-0,l+7)) #Update the range of the specific lines to be deleted
    medicine_info.close() #Close medicine_info file

    medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
    delete_medicine_info_write = open("delete_medicine_info.txt", "w") #Write delete_medicine_info file
    for l,m in enumerate(medicine_info):
        if l not in se:
            delete_medicine_info_write.write(m) #Write delete_medicine_info file if l not in se
    medicine_info.close() #Close medicine_info file
    delete_medicine_info_write.close() #Close delete_medicine_info file
    print("Medicine reference code "+delete_medicine_info+" deleted successfully.\n")

    import shutil
    shutil.copyfile("delete_medicine_info.txt", "medicine_info.txt") #Transfer delete_medicine_info and rewrite medicine_info

    return_yorn = str(input("Return to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        Delete_Medicine()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Search_Medicine(): #Search Specific Medicine Detail (Admin)
    print("\n*******************************************")
    print("\tSearch Medicine Information")
    print("*******************************************")
    medicine_info = open("medicine_info.txt", "r") #Open medicine_info file
    search_medicine_ref_code = input("Enter the medicine's reference code: ")
    
    se = set() #Store the lines in se
    for n,o in enumerate(medicine_info): #Adds a counter as the key of the lines in medicine_info
        if "Medicine's reference code: "+search_medicine_ref_code in o: #If specific lines in o
            se.update(range(n-0,n+7)) #Update the range of the specific lines to be selected
    medicine_info.close() #Close medicine_info file

    medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
    search_medicine_info_write = open("search_medicine_info.txt", "w") #Write search_medicine_info file
    for n,o in enumerate(medicine_info):
        if n in se:
            search_medicine_info_write.write(o) #Write search_medicine_info file if n not in se
    medicine_info.close() #Close medicine_info file
    search_medicine_info_write.close() #Close search_medicine_info file

    search_medicine_info = open("search_medicine_info.txt", "r") #Open search_medicine_info file
    search_medicine = input("Search medicine's details: ")
    search_medicine_info_lines = search_medicine_info.readlines() #Read file content line by line
    search_medicine_info_list = []
    counter = 0
    for view_medicine_info_line in search_medicine_info_lines:
        if search_medicine in view_medicine_info_line: #If line have the input medicine details
            search_medicine_info_list.insert(counter, view_medicine_info_line) #get the counter of the line and put it into the list
            counter += 1
    search_medicine_info.close() #Close search_medicine_info file

    if (len(search_medicine_info_list) == 0): #If the length of the list is 0
        print("Invalid enter.")
    else:
        linesLen = len(search_medicine_info_list) #display the line with given medicine details
        print("\n-Results-")
        for p in range(linesLen):
            print(end = search_medicine_info_list[p]) #print the medicine details from the file
        print()

    return_yorn = str(input("Return to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        Search_Medicine()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Place_Order_and_Payment(): #Place order and pay to complete the buying process (Registered Customer)
    print("\n***************************")
    print("\tPlace Order")
    print("***************************")

    username_customer = input("Enter your username as receipt record: ")
    order_name = open("order_file.txt", "a") #Append order_name file
    order_name.write("Customer: "+username_customer+"\n") #Write customer's username into order_file
    order_name.close() #Close order_name file
    buying_dict={}

    while(True):
        medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
        order_medicine = input("Which medicine name do you want to buy: ")
        order_medicine_list = []
        order_medicine_list.append(order_medicine) #To append selected medicine in the list

        se = set() #Store the lines in se
        for t,u in enumerate(medicine_info): #Adds a counter as the key of the lines in medicine_info
            if "Medicine's name: "+order_medicine in u: #If specific line in u
                se.update(range(t-0,t+7)) #Update the range of the specific lines to be selected
        medicine_info.close() #Close medicine_info file
        medicine_info = open("medicine_info.txt", "r") #Read medicine_info file
        order_file_0_write = open("order_file_0.txt", "w") #Write order_file_0 file
        for t,u in enumerate(medicine_info):
            if t in se:
                order_file_0_write.write(u) #Write order_file_0 file if t in se
        medicine_info.close() #Close medicine_info file
        order_file_0_write.close() #Close order_file_0 file

        order_medicine_quantity = input("Quantity of the selected medicine you want to buy: ")
        order_medicine_quantity_list = []
        order_medicine_quantity_list.append(order_medicine_quantity) #To append quantity of the medicine in the list
        buying_dict[order_medicine] = order_medicine_quantity #Adding the medicine name and quantity into dictionary

        import re
        order_file_0 = open("order_file_0.txt", "r") #Read open_file_0 file
        for line in order_file_0:
            medicine_name_match = re.search(r'name: (\S+)', line) #Capture characters after the initial match
            if medicine_name_match: #If its the initial match
                order_match = medicine_name_match.group(1)
                order_file = open("order_file.txt", "a") #Append order_file file
                order_file.write(order_match+" ") #Write order_file file
                order_file.write("x"+order_medicine_quantity+"\n")
                order_file.close() #Close order_file file
        anything_else = str(input("\nAnything Else? [y/n]: "))
        print("")
        if(anything_else == "y"):
            continue #loop back to the enter medicine's name
        elif(anything_else == "n"):
            order_file = open("order_file.txt", "a") #Append order_file file
            order_file.write("End of the order list.\n\n") #Write order_file file (for view_customer_order() purpose)
            order_file.close() #Close order_file file
        else:
            pass
        break #Stop the for loop
    
    price_dict = {'Antibiotic': 20, 'Aspirin': 30, 'Lyrica': 10, 'Dupixent': 15} #The price of medicines
    def get_price(medicine, quantity): #Get total price of a selected medicine
        subtotal = price_dict[medicine]*int(quantity) #Counting subtotal with the entered quantity
        print(medicine+': RM'+str(price_dict[medicine])+' x '+str(quantity)+' = RM'+str(subtotal))
        return subtotal

    bill_price = 0
    for key, value in buying_dict.items():
        bill_price += get_price(key, value) #Get the sum of all ordered medicines

    membership = input("\nWhich rank is your membership? [gold/silver/bronze/no]: ")

    def get_discount(bill_price, membership): #Get discount according to bill price
        discount = 0
        if(bill_price >= 50):
            if(membership == 'gold'):
                bill_price = bill_price*0.75
                discount = 25
            elif(membership == 'silver'):
                bill_price = bill_price*0.85
                discount = 15
            elif(membership == 'bronze'):
                bill_price = bill_price*0.95
                discount = 5
            elif(membership == 'no'):
                bill_price = bill_price
                discount = 0
            print(str(discount)+'% off for '+membership+' membership at total price no less than RM50')
        return bill_price
    
    bill_price = get_discount(bill_price, membership) #Price of the medicines after discount
    print('The total price is RM'+str(bill_price))
    receive = float(input("\nEnter your payment amount: RM"))
    print("Payment received.")
    change = float(receive) - float(bill_price) #Change for customer who paid more
    if(change != 0):
        print("Change: RM"+str(change))
        print("Thank you for purchasing.\n")
    else:
        print("Thank you for purchasing.\n")
    
    return_yorn = str(input("Return to Registered Customer Page? [y/n]: "))
    if(return_yorn == "y"):
        Registered_Customer_Page()
    elif(return_yorn == "n"):
        Place_Order_and_Payment()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def View_Customer_Order(): #View All Orders of Customers (Admin)
    print("\n****************************")
    print("\tCustomer's Order")
    print("****************************")
    customer_order_view = open("order_file.txt", "r") #Read order_file file
    read_customer_order_view = customer_order_view.read()
    print(read_customer_order_view) #Read and print order_file file content
    customer_order_view.close() #Close order_file file

    return_yorn = str(input("Return to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        View_Customer_Order()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def Search_Customer_Order(): #Search Order of Specific Customer (Admin)
    print("\n***********************************")
    print("\tSearch Customer's Order")
    print("***********************************")
    username_customer = input("Please enter customer's username: ")
    matched_lines = search_string_in_file("order_file.txt", username_customer) #search customer's username in order_file file
    for elem in matched_lines: #if yes give elem[0] (line number)
        counter = 0
        own_order = open("order_file.txt", "r") #Read order_file file
        own_order_lines = own_order.readlines() #Read all order_file file lines
        for lines in own_order_lines:
            if("End of the order list." not in lines): #Check if "End of the order list." is in the line or not
                print(own_order_lines[elem[0]+counter], end="") #print the customer order without spaces
                counter += 1
            else:
                break #Stop the for loop

    return_yorn = str(input("\nReturn to Admin Page? [y/n]: "))
    if(return_yorn == "y"):
        Admin_Page()
    elif(return_yorn == "n"):
        Search_Customer_Order()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def View_Own_Order(): #Can View Own Order (Registered Customer)
    print("\n******************************")
    print("\tView Own Order")
    print("******************************")
    username_customer = input("Please enter your username: ")
    matched_lines = search_string_in_file("order_file.txt", username_customer) #search customer's username in order_file file
    for elem in matched_lines: #if yes give elem[0] (line number)
        counter = 0
        own_order = open("order_file.txt", "r") #Read order_file file
        own_order_lines = own_order.readlines() #Read all order_file file lines
        for lines in own_order_lines:
            if("End of the order list." not in lines): #Check if "End of the order list." is in the line or not
                print(own_order_lines[elem[0]+counter], end="") #print the customer order without spaces
                counter += 1
            else:
                break #Stop the for loop

    return_yorn = str(input("\nReturn to Registered Customer Page? [y/n]: "))
    if(return_yorn == "y"):
        Registered_Customer_Page()
    elif(return_yorn == "n"):
        View_Own_Order()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def View_Personal_Info(): #Can View Personal Information (Registered Customer)
    print("\n*****************************************")
    print("\tView Personal Information")
    print("*****************************************")
    customer_info = open("customer_info.txt", "r") #Read customer_info file
    search_username = input("Enter your username: ")
    
    se = set() #Store the lines in se
    for v,w in enumerate(customer_info): #Adds a counter as the key of the lines in customer_info
        if "Username: "+search_username in w: #If specific lines in w
            se.update(range(v-0,v+8)) #Update the range of the specific lines to be selected
    customer_info.close() #Close customer_info file

    customer_info = open("customer_info.txt", "r") #Read customer_info file
    customer_info_1_write = open("customer_info_1.txt", "w") #Write customer_info_1 file
    for v,w in enumerate(customer_info):
        if v in se:
            customer_info_1_write.write(w) #Write customer_info_1 file if v in se
    customer_info.close() #Close customer_info file
    customer_info_1_write.close() #Close customer_info_1 file
    customer_info_1 = open("customer_info_1.txt", "r") #Read customer_info_1 file
    print(customer_info_1.read()) #Read and print customer_file_1 file content

    import shutil
    shutil.copyfile("customer_info.txt", "customer_info_0.txt") #Transfer customer_info and rewrite customer_info_0

    change_pass = input("Do you want to change your password? [y/n]: ")
    if(change_pass == "y"):
        customer_info_0 = open("customer_info_0.txt", "r") #Read customer_info_0 file
        word_to_be_replace = input("Enter your password: ")  
        replace_word = input("Enter the new password: ")
        update = customer_info_0.read() #Read file contents to string
        update = update.replace(word_to_be_replace, replace_word) #Replace the occurrences of the required string
        customer_info_0.close() #Close customer_info_0 file
        customer_info_0 = open("customer_info_0.txt", "w") #Write customer_info_0 file
        customer_info_0.write(update) #Overwrite the file with the resulting update data
        customer_info_0.close() #Close customer_info_0 file

        customer_login = open("customer_login.txt", "r") #Read customer_login file
        data = customer_login.read()
        data = data.replace(word_to_be_replace, replace_word) #Replace the occurrences of the required string
        customer_login.close() #Close customer_login file
        customer_login = open("customer_login.txt", "w") #Write customer_login file
        customer_login.write(data) #Write data into customer_login file
        customer_login.close() #Close customer_login file
        print("Password changed successfully.")
    else:
        pass
    
    import shutil
    shutil.copyfile("customer_info_0.txt", "customer_info.txt") #Transfer customer_info_0 and rewrite customer_info

    return_yorn = str(input("\nReturn to Registered Customer Page? [y/n]: "))
    if(return_yorn == "y"):
        Registered_Customer_Page()
    elif(return_yorn == "n"):
        View_Personal_Info()
    else:
        print("Invalid option.")
        Main_Page()
    pass

def search_string_in_file(file_name, string_to_search):
    line_number = 0
    list_of_result = [] 
    read_obj = open(file_name, 'r') #Open the file in read only mode
    for line in read_obj: #Read all lines in the file one by one
        line_number += 1 #For each line, check if line contains the string
        if string_to_search in line: #If yes, then add the line number & line as a tuple in the list
            list_of_result.append((line_number, line.rstrip())) #Return list of tuples containing line numbers and lines where string is found
        return list_of_result
    print(list_of_result)

Main_Page() #Main Page is the first interface that all users reach inside the OPMS