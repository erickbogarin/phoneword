[![Build Status](https://travis-ci.org/erickbogarin/phoneword.svg?branch=master)](https://travis-ci.org/erickbogarin/phoneword)

# Phoneword

![Phoneword](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/250px-Telephone-keypad2.svg.png)

This project was born from the need to deal with entries of telephone numbers containing letters and numbers together, it was therefore required to extract only the telephone number.

## Usage

```java
String phoneNumber = "55ABCDE";

String clean = new PhoneWord().clear(phoneNumber);
System.out.println(clean) // prints 5522233
```
The string is evaluated based on the following two patterns:

#### Formatted pattern
```js
// the letter D represents only digits [0-9]
D-DDD-xxxxx // minimum five x characters
D-DDD-xxxxxx // maximum six x characters
```
#### Unformatted pattern
```js
// the letter D represents only digits [0-9]
DDxxxxx // minimum five x characters
DDxxxxxx // maximum six x characters
```

**Examples:**
```java
String formatted = "1-800-ABCDE";
String unformatted = "55ZAFGTR";

String invalid = "FGTEASV" // throws an exception
```

## Contributing
* Fork it!
* Create your feature branch: git checkout -b my-new-feature
* Commit your changes: git commit -m 'Add some feature'
* Push to the branch: git push origin my-new-feature
* Submit a pull request :D

## License 
[MIT License](LICENSE) © Erick Bogarin
