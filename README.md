# ITMO-prog-intro-course

## Домашнее задание 1. Запусти меня!
1. Установите [JDK 11+](https://adoptopenjdk.net/?variant=openjdk14&jvmVariant=hotspot)  
2. Скопируйте один из вариантов `HelloWorld`, рассмотренных на лекции.  
3. Откомпилируйте `HelloWorld.java` и получите `HelloWorld.class`.  
4. Запустите `HelloWorld` и проверьте его работоспособность.  
5. Создайте скрипт, компилирующий и запускающий `HelloWorld` из командной строки.  

## Домашнее задание 2. Сумма чисел
1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.  
2. Примеры запуска программы:  
    `java Sum 1 2 3`  
         Результат: 6  
    `java Sum 1 2 -3`  
         Результат: 0  
    `java Sum "1 2 3"`  
         Результат: 6  
    `java Sum "1 2" " 3"`  
         Результат: 6  
    `java Sum " "`  
         Результат: 0  
  
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
1. Разработайте класс `Reverse`, читающий числа из [стандартного ввода](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#in), и выводящий их на [стандартный вывод](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#out) в обратном порядке.  
2. В каждой строке входа содержится некоторое количество целых чисел (может быть 0). Числа разделены пробелами. Каждое число помещается в тип int.  
3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке так же должен быть обратным к порядку чисел во входе.  
4. Вход содержит не более 10^6 чисел и строк.  
5. Для чтения чисел используйте класс [Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html).  

Откомпилированные тесты: [ReverseTest.jar](/hw03-Reverse/ReverseTest.jar)
Модификация:
 * *Avg* (для 36-39)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите среднее из чисел в его столбце и строке
    * Класс должен иметь имя `ReverseAvg`
    * [Откомпилированные тесты](/hw03-Reverse/ReverseAvgTest.jar)

## Домашнее задание 4. Статистика слов
1. Разработайте класс `WordStat`, который будет подсчитывать статистику встречаемости слов во входном файле.  
2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category [Punctuation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION), [Dash](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION). Для подсчета статистики, слова приводятся к нижнему регистру.  
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входной файл.  
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.  

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
1. Разработайте класс `WordStatIndex`, который будет подсчитывать статистику встречаемости слов во входном файле.  
2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.  
3.Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.  
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.  
5. Программа должна работать за линейное от размера входного файла время.  
6. Для реализации программы используйте Collections Framework.  
7. _Сложный вариант_. Реализуйте и примените класс IntList, компактно хранящий список целых чисел.  

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
1. Решите как можно больше задач Чемпионата северо-запада России по программированию 2019.  
2. Материалы соревнования:
    * [Условия задач](https://nerc.itmo.ru/archive/2019/northern/nwrrc-2019-statements.pdf)
    * [Разбор задач](https://nerc.itmo.ru/archive/2019/northern/nwrrc-2019-tutorials.pdf)
3. Рекомендуемое время выполнения задания: 3 часа  

## Домашнее задание 9. Игра m,n,k
1. Реализуйте [игру m,n,k](https://en.wikipedia.org/wiki/M,n,k-game).
2. Добавьте обработку ошибок ввода пользователя.
3. _Простая версия_. Проверку выигрыша можно производить за O(nmk).
4. _Сложная версия_.
    * Проверку выигрыша нужно производить за O(k).
    * Предотвратите жульничество: у игрока не должно быть возможности достать *Board* из *Position*.

## Домашнее задание 10. Выражения
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
