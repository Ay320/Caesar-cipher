# Caesar Cipher Encryption and Decryption
This project consists of two Java programs: **Caesar** and **Brutus**. 
The **Caesar** class provides methods for encrypting messages using the Caesar Cipher, while the **Brutus** class attempts to decrypt Caesar cipher-encrypted messages using statistical frequency analysis.
## Caeser : Encryption
The **Caesar** class allows users to encrypt a message by shifting each letter by a specified number of positions in the alphabet.
### Usage
- To use the Caesar encryption program, you need to provide two arguments:
  1. **Shift value** (an integer): Specifies how many positions each letter will be shifted (positive or negative).
  2. **Message** (a string): The message to be encrypted.
#### Example
java Caesar 3 "hello world"
Output : khoor zruog
# Brutus : Decryption
The **Brutus** class attempts to decrypt a Caesar cipher-encrypted message by using letter frequency analysis to find the best possible shift.
The program compares the frequencies of letters in the ciphertext to the known frequencies of letters in the English language using the chi-squared method to find the most likely shift value.
## Usage
To use the Brutus decryption program, you only need to provide the ciphertext as an argument.
### Example
java Brutus "khoor zruog"
Output : hello world
