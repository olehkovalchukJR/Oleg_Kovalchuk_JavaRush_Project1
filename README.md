# Oleg_Kovalchuk_JavaRush_Project1

# Криптоанализатор
## Краткое описание:
Программа способна зашифровать текстовый файл на русском язике, шифром Цезаря
с помощью ключа (сдвиг символов алфавита на указаное расстояние). Расшифровать
этот текст по такому же принципу (с помощью ключа) и расшифровать текст методом brute force (перебор всех вариантов).

## Краткое описание классов:

### Пакет files:
##### FileToEncrypt - принимает текстовый файл который надо зашифровать
##### EncryptedFile - запись зашифрованого текста в новый текстовый файл
##### encryptedFile.txt - текстовый файл для хранения зашифрованного текста
##### firstLineForBruteForce.txt - текстовый файл для хранения первой строки текстового файла на входе

### Пакет project1:
#### Key - ключ для шифрования и дешифрования
#### Alphabet - символы русского алфавита и знаки пунктуации
#### Encryption - шифрование файла и запись зашифрованного текста в новый файл
#### Decryption - расшифровка тексат по заданному ключу и методом brute force
#### Main - вывод меню и вызов всех остальных классов

### Пакет Exceptions:
InvalidKeyException - если ключ находится вне диапазона (от 1 до 99);