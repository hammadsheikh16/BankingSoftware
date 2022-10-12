import mysql.connector
tmp = []
banklog_path = "C:\\Users\hamma\OneDrive\Desktop\BANKGUI\src\BankguiLogbook"
log_book = open(banklog_path, "r")
for line in log_book:
    tmp.append(line)

tmp = list(filter(lambda x: x, tmp))
print(tmp)
