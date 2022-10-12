import csv

# with open("customer.csv") as customers:
#     content = csv.reader(customers)
#     for row in content:
#         print(row)

with open("customer.csv", "a") as customers:
    content = csv.writer(customers)
    content.writerow([6, "georges", 10000000])

with open("customer.csv") as customers:
    content = csv.reader(customers)
    tmp = []
    for row in content:
        tmp.append(row)
print(tmp)
filtered = list(filter(lambda x: x, tmp))
print(filtered)

