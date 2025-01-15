import csv

with open('contactos.txt', 'r') as txtfile, open('contactos.csv', 'w') as csvfile:
    reader = csv.reader(txtfile, delimiter='\t')
    writer = csv.writer(csvfile, delimiter=',')
    for row in reader:
        name = row[0].strip()
        phone = row[1].strip()
        email = row[2].strip()
        writer.writerow([name, phone, email])