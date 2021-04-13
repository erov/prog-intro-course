# ITMO-prog-intro-course

Модификации реализованы для групп 38-39, в заданиях с разделением на легкую/сложную версию реализованна сложная версия.  

## Домашнее задание 1. Запусти меня!

> Реализация: [HelloWorld.java](hw01-HelloWorld/HelloWorld.java), [HelloWorldBat.bat](https://github.com/iamerove/ITMO-prog-intro-course/blob/main/hw01-HelloWorld/HelloWorldBat.bat)

1. Установите [JDK 11+](https://adoptopenjdk.net/?variant=openjdk14&jvmVariant=hotspot)  
2. Скопируйте один из вариантов `HelloWorld`, рассмотренных на лекции.  
3. Откомпилируйте `HelloWorld.java` и получите `HelloWorld.class`.  
4. Запустите `HelloWorld` и проверьте его работоспособность.  
5. Создайте скрипт, компилирующий и запускающий `HelloWorld` из командной строки.  

## Домашнее задание 2. Сумма чисел

> Реализация: [SumBigIntegerSpace.java](/hw02-Sum/SumBigIntegerSpace.java)

1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.  
2. Примеры запуска программы:  
    
    |строка| результат|
    |-|-|
    | `java Sum 1 2 3` | Результат: 6 |
    | `java Sum 1 2 -3` | Результат: 0 | 
    | `java Sum "1 2 3"` | Результат: 6 |  
    | `java Sum "1 2" " 3"` | Результат: 6 | 
    | `java Sum " "` | Результат: 0 | 
  
    Аргументы могут содержать:  
      * цифры;  
      * знаки + и -;  
      * произвольные [пробельные символы](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#isWhitespace(char)).  
3. При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип int.  
4. Перед выполнением задания ознакомьтесь с документацией к классам [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) и [Integer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html).  
5. Для отладочного вывода используйте [System.err](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#err), тогда он будет игнорироваться проверяющей программой.  

Откомпилированные тесты: [SumTest.jar](/hw02-Sum/SumTest.jar)  
Модификация:
 * *BigIntegerSpace* (для 38, 39)
    * Входные данные помещаются в тип [BigInteger](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html)
    * Класс должен иметь имя `SumBigIntegerSpace`
    * Числа разделяются [пробелами-разделителями](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#SPACE_SEPARATOR)
    * [Откомпилированные тесты](/hw02-Sum/SumBigIntegerSpaceTest.jar)

## Домашнее задание 3. Реверс  

> Реализация: [ReverseAvg.java](/hw03-Reverse/ReverseAvg.java)

1. Разработайте класс `Reverse`, читающий числа из [стандартного ввода](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#in), и выводящий их на [стандартный вывод](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#out) в обратном порядке.  
2. В каждой строке входа содержится некоторое количество целых чисел (может быть 0). Числа разделены пробелами. Каждое число помещается в тип int.  
3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке так же должен быть обратным к порядку чисел во входе.  
4. Вход содержит не более 10^6 чисел и строк.  
5. Для чтения чисел используйте класс [Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html).  
6. Примеры работы программы:  

    | Ввод               | Вывод         |
    |--------------------|---------------|
    | 1 2<br>3           | 3<br>2 1      |
    | 3<br>2 1           | 1 2<br>3      |
    | 1<br><br>2 -3      | -3 2<br><br>1 |
    | 1     2<br>3     4 | 4 3<br>2 1    |

Откомпилированные тесты: [ReverseTest.jar](/hw03-Reverse/ReverseTest.jar)  
Модификация:
 * *Avg* (для 36-39)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите среднее из чисел в его столбце и строке
    * Класс должен иметь имя `ReverseAvg`
    * [Откомпилированные тесты](/hw03-Reverse/ReverseAvgTest.jar)

## Домашнее задание 4. Статистика слов

> Реализация: [WordStatCountShingles.java](/hw04-WordStat/WordStatCountShingles.java)

1. Разработайте класс `WordStat`, который будет подсчитывать статистику встречаемости слов во входном файле.  
2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category [Punctuation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION), [Dash](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION). Для подсчета статистики, слова приводятся к нижнему регистру.  
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входной файл.  
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.  
5. Пример работы программы:  

    | Входной файл                                                          | Выходной файл                                                                                 |
    |-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
    | To be, or not to be, that is the question:                            | to 2<br>be 2<br>or 1<br>not 1<br>that 1<br>is 1<br>the 1<br>question 1                        |
    | Monday's child is fair of face.<br>Tuesday's child is full of grace.  | monday's 1<br>child 2<br>is 2<br>fair 1<br>of 2<br>face 1<br>tuesday's 1<br>full 1<br>grace 1 |
    | Шалтай-Болтай<br>Сидел на стене.<br>Шалтай-Болтай<br>Свалился во сне. | шалтай-болтай 2<br>сидел 1<br>на 1<br>стене 1<br>свалился 1<br>во 1<br>сне 1                  |

Откомпилированные тесты: [WordStatInputTest.jar](/hw04-WordStat/WordStatInputTest.jar)  
Модификация:
 * *CountShingles* (для 38, 39)
    * Выходной файл должен содержать все различные подстроки длины 3
      слов встречающихся во входном файле, упорядоченые по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Класс должен иметь имя `WordStatCountShingles`
    * [Откомпилированные тесты](/hw04-WordStat/WordStatCountShinglesTest.jar)

## Домашнее задание 5. Свой сканер

> Реализация: [MyScanner.java](/hw05-Scanner/MyScanner.java)

1. Реализуйте свой аналог класса `Scanner` на основе `Reader`.  
2. Примените разработанный `Scanner` для решения задания «Реверс».  
3. Примените разработанный `Scanner` для решения задания «Статистика слов».  
4. Код, управляющий чтением должен быть общим.  
5. _Сложный вариант_. Код, выделяющий числа и слова должен быть общим.  
6. При реализации блочного чтения обратите внимание на слова/числа, пересекающие границы блоков, особенно — больше одного раза.  

Откомпилированные тесты: [FastReverseTest.jar](/hw05-Scanner/FastReverseTest.jar)  
Модификаця:
 * *HexAbc* (38, 39)
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Десятеричные числа могут быть записаны буквами
    * Класс должен иметь имя `ReverseHexAbc`
    * [Откомпилированные тесты](/hw05-Scanner/FastReverseHexAbcTest.jar)

## Домашнее задание 6. Статистика слов++

> Реализация: [WordStatCountFirstIndex.java](/hw06-WordStat%2B%2B/WordStatCountFirstIndex.java)

1. Разработайте класс `WordStatIndex`, который будет подсчитывать статистику встречаемости слов во входном файле.  
2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.  
3.Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.  
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.  
5. Программа должна работать за линейное от размера входного файла время.  
6. Для реализации программы используйте Collections Framework.  
7. _Сложный вариант_. Реализуйте и примените класс IntList, компактно хранящий список целых чисел.  
8. Пример работы программы:

    | Входной файл                                                          | Выходной файл                                                                                                            |
    |-----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
    | To be, or not to be, that is the question:                            | to 2 1 5<br>be 2 2 6<br>or 1 3<br>not 1 4<br>that 1 7<br>is 1 8<br>the 1 9<br>question 1 10                              |
    | Monday's child is fair of face.<br>Tuesday's child is full of grace.  | monday's 1 1<br>child 2 2 8<br>is 2 3 9<br>fair 1 4<br>of 2 5 11<br>face 1 6<br>tuesday's 1 7<br>full 1 10<br>grace 1 12 |
    | Шалтай-Болтай<br>Сидел на стене.<br>Шалтай-Болтай<br>Свалился во сне. | шалтай-болтай 2 1 5<br>сидел 1 2<br>на 1 3<br>стене 1 4<br>свалился 1 6<br>во 1 7<br>сне 1 8                             |

Модификация:
 * *CountFirstIndex* (38, 39)
    * В выходном файле слова должны быть упорядочены по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Вместо номеров вхождений во всем файле надо указывать
      только первое вхождение в каждой строке
    * Класс должен иметь имя `WordStatCountFirstIndex`
    * [Откомпилированные тесты](/hw06-WordStat%2B%2B/WordStatCountFirstIndexTest.jar)

## Домашнее задание 7. Разметка

> Реализация: [markup/](/hw07-Markup/src/markup)

1. Разработайте набор классов для текстовой разметки.
2. Класс `Paragraph` может содержать произвольное число других элементов разметки и текстовых элементов.
3. Класс `Text` – текстовый элемент.
4. Классы разметки `Emphasis`, `Strong`, `Strikeout` – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.
5. Все классы должны реализовывать метод toMarkdown([StringBuilder](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html)), которой должен генерировать [Markdown](https://ru.wikipedia.org/wiki/Markdown)-разметку по следующим правилам:
    * текстовые элементы выводятся как есть;
    * выделенный текст окружается символами '*';
    * сильно выделенный текст окружается символами '__';
    * зачеркнутый текст окружается символами '~'.
6. Следующий код должен успешно компилироваться:
    ```
        Paragraph paragraph = new Paragraph(List.of(  
        new Strong(List.of(
            new Text("1"),
            new Strikeout(List.of(
                new Text("2"),
                new Emphasis(List.of(
                    new Text("3"),
                    new Text("4")
                )),
                new Text("5")
            )),
            new Text("6")
        ))
    ));
7. Вызов `paragraph.toMakdown(new StringBuilder())` должен заполнять переданный `StringBuilder` следующим содержимым: `__1~2*34*5~6__`
8. Разработанные классы должны находиться в пакете `markup`.

Исходный код тестов:

 * [MarkdownTest.java](hw07-Markup/src/markup/MarkdownTest.java)
 * [AbstractTest.java](hw07-Markup/src/markup/AbstractTest.java)

Модификации:
 * *BBCode* (34, 35)
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
      * выделеный текст окружается тегом `i`;
      * сильно выделеный текст окружается тегом `b`;
      * зачеркнутый текст окружается тегом `s`.
 * *BBCodeList*
    * Сделайте модификацию *BBCode*
    * Добавьте поддержку:
      * Нумерованных списков (класс `OrderedList`, тег `list=1`): последовательность элементов
      * Ненумерованных списков (класс `UnorderedList`, тег `list`): последовательность элементов
      * Элементов списка (класс `ListItem`, открывающий тег `*`): последовательность абзацев и списков
    * Для новых классов поддержка Markdown не требуется
    * [Исходный код тестов](hw07-Markup/src/markup/BBCodeListTest.java)

## Домашнее задание 8. Чемпионат


> Реализация: [championship/](hw08-Championship/src)

1. Решите как можно больше задач Чемпионата северо-запада России по программированию 2019.  
2. Материалы соревнования:
    * [Условия задач](https://nerc.itmo.ru/archive/2019/northern/nwrrc-2019-statements.pdf)
    * [Разбор задач](https://nerc.itmo.ru/archive/2019/northern/nwrrc-2019-tutorials.pdf)
3. Задачи для решения  

    | Задача |	Тема |	Сложность |
    |-|-|-|
    | A. Accurate Movement | Формула | 5 |
    | B. Bad Treap | Циклы | 10 |
    | C. Cross-Stitch | Графы | 40 |
    | D. Double Palindrome | Массивы | 40 |
    | E. Equidistant | Деревья | 30 |
    | H. High Load Database | Массивы | 20 |
    | I. Ideal Pyramid | Циклы | 15 |
    | J. Just the Last Digit | Матрицы | 20 |
    | K. King’s Children | Массивы | 40 |
    | M. Managing Difficulties | Коллекции | 10 |

4. Рекомендуемое время выполнения задания: 3 часа  

## Домашнее задание 9. Игра m,n,k

> Реализация: [Main.java](/hw09-MNK-Game/src/game/Main.java)

1. Реализуйте [игру m,n,k](https://en.wikipedia.org/wiki/M,n,k-game).
2. Добавьте обработку ошибок ввода пользователя.
3. _Простая версия_. Проверку выигрыша можно производить за O(nmk).
4. _Сложная версия_.
    * Проверку выигрыша нужно производить за O(k).
    * Предотвратите жульничество: у игрока не должно быть возможности достать *Board* из *Position*.

## Домашнее задание 10. Выражения

> Реализация: [expression/](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression)

1. Разработайте классы `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` для вычисления выражений с одной переменной в типе `int`.  
2. Классы должны позволять составлять выражения вида  
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).evaluate(5)
```
При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу `evaluate` (на данном этапе имена переменных игнорируются). Таким образом, результатом вычисления приведенного примера должно стать число 7.  
3. Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например  
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toString()
```            
должен выдавать ((2 * x) - 3).  
4. _Сложный вариант_. Метод `toMiniString` должен выдавать выражение с минимальным числом скобок. Например  
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toMiniString()
```
должен выдавать 2 * x - 3.  
5. Реализуйте метод `equals`, проверяющий, что два выражения совпадают. Например,  
```
new Multiply(new Const(2), new Variable("x"))
    .equals(new Multiply(new Const(2), new Variable("x")))
```            
должно выдавать true, а  
```
new Multiply(new Const(2), new Variable("x"))
    .equals(new Multiply(new Variable("x"), new Const(2)))
```            
должно выдавать false.  
6. Для тестирования программы должен быть создан класс `Main`, который вычисляет значение выражения x^2−2x+1, для x, заданного в командной строке.  
7. При выполнении задания следует обратить внимание на:  
    * Выделение общего интерфейса создаваемых классов.
    * Выделение абстрактного базового класса для бинарных операций.

Модификации:
 * *Базовая*
    * Реализуйте интерфейс [Expression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/Expression.java)
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/ExpressionTest.java)
        * Запускать c аргументом `easy` или `hard`
 * *Triple* (32-35)
    * Дополнительно реализуйте интерфейс [TripleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/TripleExpression.java)
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/TripleExpressionTest.java)
 * *Double* (36, 37)
    * Дополнительно реализуйте интерфейс [DoubleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/DoubleExpression.java)
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/DoubleExpressionTest.java)
 * *DoubleTriple* (38, 39)
    * Дополнительно реализуйте интерфейсы 
      [DoubleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/DoubleExpression.java) и
      [TripleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/TripleExpression.java)
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/DoubleTripleExpressionTest.java)

## Домашнее задание 11. Разбор выражений

> Реализация: [expression/parser/](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/parser)

1. Доработайте предыдущее домашнее задание, так что бы выражение строилось по записи вида `x * (x - 2)*x + 1`  
2. В записи выражения могут встречаться: умножение `*`, деление `/`, сложение `+`, вычитание `-`, унарный минус `-`, целочисленные константы (в десятичной системе счисления, которые помещаются в 32-битный знаковый целочисленный тип), круглые скобки, переменные (x) и произвольное число пробельных символов в любом месте (но не внутри констант).  
3. Приоритет операторов, начиная с наивысшего
    * унарный минус;
    * умножение и деление;
    * сложение и вычитание.
4. Разбор выражений рекомендуется производить [методом рекурсивного спуска](https://ru.wikibooks.org/wiki/Реализации_алгоритмов/Метод_рекурсивного_спуска). Алгоритм должен работать за линейное время.

Модификации:
 * *Базовая*
    * Класс `ExpressionParser` должен реализовывать интерфейс
        [Parser](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/parser/Parser.java)
    * Результат разбора должен реализовывать интерфейс
        [TripleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/TripleExpression.java)
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/parser/ParserTest.java)
 * *Bitwise* (32-35)
    * Дополнительно реализуйте бинарные операции:
        * `&` – побитное И, приоритет меньше чем у `+` (`6 & 1 + 2` равно `6 & (1 + 2)` равно 2);
        * `^` – побитный XOR, приоритет меньше чем у `&` (`6 ^ 1 + 2` равно `6 ^ (1 + 2)` равно 5);
        * `|` – побитное ИЛИ, приоритет меньше чем у `^` (`6 | 1 + 2` равно `6 | (1 + 2)` равно 7);
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/parser/ParserBitwiseTest.java)
 * *FlipLow* (38, 39)
    * Реализуйте операции из модификации *Bitwise*.
    * Дополнительно реализуйте унарные операции (приоритет как у унарного минуса):
        * `flip` – число с переставленными двоичными цифрами, `flip 12345` равно 9987, 
                   `flip -12345` равно `-470548481`;
        * `low` – минимальный установленный бит
                 (как в [lowestOneBit](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html#lowestOneBit%28int%29)),
                 `low 123456` равно 64.
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/parser/ParserFlipLowTest.java)

## Домашнее задание 12. Обработка ошибок

> Реализация: [expression/exceptions/](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/exceptions)

1. Добавьте в программу вычисляющую выражения обработку ошибок, в том числе:
    * ошибки разбора выражений;
    * ошибки вычисления выражений.
2. Для выражения 1000000*x*x*x*x*x/(x-1) вывод программы должен иметь следующий вид:
```
x       f
0       0
1       division by zero
2       32000000
3       121500000
4       341333333
5       overflow
6       overflow
7       overflow
8       overflow
9       overflow
10      overflow
```
Результат `division by zero (overflow)` означает, что в процессе вычисления произошло деление на ноль (переполнение).
3. При выполнении задания следует обратить внимание на дизайн и обработку исключений.
4. Человеко-читаемые сообщения об ошибках должны выводится на консоль.
5. Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными).

Модификации:
 * *Базовая*
    * Класс `ExpressionParser` должен реализовывать интерфейс
        [Parser](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/exceptions/Parser.java)
    * Классы `CheckedAdd`, `CheckedSubtract`, `CheckedMultiply`,
        `CheckedDivide` и `CheckedNegate` должны реализовывать интерфейс
        [TripleExpression](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/TripleExpression.java)
    * Нельзя использовать типы `long` и `double`
    * Нельзя использовать методы классов `Math` и `StrictMath`
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/exceptions/ExceptionsTest.java)
 * *AbsSqrt* (32-35)
    * Дополнительно реализуйте унарные операции:
        * `abs` – модуль числа, `abs -5` равно 5;
        * `sqrt` – квадратный корень, `sqrt 24` равно 4.
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/exceptions/ExceptionsAbsSqrtTest.java)
 * *GcdLcm* (38, 39)
    * Реализуйте операции модификации *AbsSqrt*.
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `gcd` – НОД, `2 gcd -3` равно 1;
        * `lcm` – НОК, `2 lcm -3` равно -6.
    * [Исходный код тестов](/hw10%2B11%2B12-Expression%2BParser%2BExceptions/src/expression/exceptions/ExceptionsGcdLcmTest.java)

## Зачет

> Реализация: [Main.java](/exam/src/Main.java)

Напишите аналог утилиты `grep`.
* Поддерживаемые возможности:
    * Поиск нескольких подстрок, разделенных `|`
    * `--ignore-case`
* Данные, в которых осуществляется поиск могут не поместиться в памяти.
* Ввод данных должен осуществляться с консоли или входного файла по выбору пользователя
