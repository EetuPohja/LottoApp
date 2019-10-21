# LottoApp

Console application that asks user for lotto numbers and checks how many years it takes to win the lotto with them.
Already after few tries, you might reconsider your chances to win the real Lotto!

Your computer needs to have JRE (Java Runtime) or JDK (Java Development Kit) installed for this software to work.

-HOW TO RUN-

-Open a console (for example command prompt).

-Inside console, go to directory holding LottoUI.java file.

-Type: "javac LottoUI.java"

-Type: "java LottoUI"

 or if you want to give numbers immediately when running the program, 
 
 you can instead type for example: "java LottoUI 1 2 3 4 5 6 7",
 
 which runs the program with numbers 1, 2, 3, 4, 5, 6 and 7.
 
-If you want to stop the program, press:  Ctrl + C

-WHAT THE PROGRAM DOES-

The program asks user for numbers, then randomly selects 
same amount of numbers out of numberspool and checks how 
long it takes for user numbers to match the randomly selected 
numbers if the randomly selected numbers are reselected every week. 
If the matching takes longer than 120 years, the program tries again.

-WANT TO GO DEEPER?-

If you open the code, you can change how many numbers the lotto has (default 7) and 
the size of the numberspool via changing the variables int min and int max.

In the code, variables:

int amountOfLottoNums = 7; 	(controls the amount of numbers the lotto has)

int min = 1;			(controls the number where the numberspool starts)

int max = 40;			(controls the number where the numberspool ends)

int lottoNumbersPoolSize = max - min + 1;  (controls the size of the numberspool (should always be the size of: max - min + 1))

GOOD LUCK AND HAVE FUN!
