1. [EncryptionDecryption](#encryption)
2. [Contacts](#contacts)


## Encryption-Decryption <a name="encryption"></a>
Gradually get familiar with Java, paying special attention to working with files and the command line.

The program parse three arguments: -mode, -key and -data. 
The first argument determine the program’s mode (enc -- encryption, dec -- decryption). 
The second argument is an integer key to modify the message, and the third argument is a text or ciphertext to encrypt or decrypt.

### Examples

#### Example 1

``java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode``

This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

#### Example 2

Input:

``java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode``

Output:

``\jqhtrj%yt%m~ujwxpnqq&``

#### Example 3

Input:

``java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec``

Output:

``Welcome to hyperskill!``

#### Example 4:

Input:

``java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc``

Output:

``Bjqhtrj yt mdujwxpnqq!``

#### Example 5:

Input:

``java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec``

Output:

``Welcome to hyperskill!``

## Contacts <a name="contacts"></a>
Creating contacts and searching for people or organizations by name. Essential basics of object-oriented programming: encapsulation, inheritance and polymorphism.

### Description
One record contains a name, a surname, and a phone number. You can type them from the keyboard.

### Output example
Below is an example of how your output might look. The symbol > represents the user input.
```
open phonebook.db
 
[menu] Enter action (add, list, search, count, exit): > count
The Phone Book has 6 records.
 
[menu] Enter action (add, list, search, count, exit): > search
Enter search query: > cent
Found 3 results:
1. Central Bank
2. Centurion Adams
3. Decent Pizza Shop
 
[search] Enter action ([number], back, again): > again
Enter search query: > shop
Found 2 results:
1. Decent Pizza Shop
2. Car shop
 
[search] Enter action ([number], back, again): > 2
Organization name: Car shop
Address: Wall St. 3
Number: +0 (123) 456-789-9999
Time created: 2018-01-01T00:03
Time last edit: 2018-04-29T11:34
 
[record] Enter action (edit, delete, menu): > edit
Select a field (name, address, number): > name
Enter name: > New Car Shop
Saved
Organization name: New Car Shop
Address: Wall St. 3
Number: +0 (123) 456-789-9999
Time created: 2018-01-01T00:03
Time last edit: 2018-11-20T11:04
 
[record] Enter action (edit, delete, menu): > menu
 
[menu] Enter action (add, list, search, count, exit): > search
Enter search query: > new
Found 1 result:
1. New Car Shop
 
[search] Enter action ([number], back, again): > back
 
[menu] Enter action (add, list, search, count, exit): > list
1. New Car Shop
2. Decent Pizza Shop
3. Central Bank
4. Centurion Adams
5. John Smith
6. Alice Wonderlanded
 
[list] Enter action ([number], back): > 6
Name: Alice
Surname: Wonderlanded
Birth date: [no data]
Gender: F
Number: +123123 (123) 12-23-34-45
Time created: 2018-03-12T11:21
Time last edit: 2018-03-12T11:21
 
[record] Enter action (edit, delete, menu): > edit
Select a field (name, surname, birth, gender, number): > number
Enter number: > +23 (321) 12-12 12 12
Saved
Name: Alice
Surname: Wonderlanded
Birth date: [no data]
Gender: F
Number: +23 (321) 12-12 12 12
Time created: 2018-03-12T11:21
Time last edit: 2018-11-20T11:07
 
[record] Enter action (edit, delete, menu): > menu
 
[menu] Enter action (add, list, search, count, exit): > exit
```
