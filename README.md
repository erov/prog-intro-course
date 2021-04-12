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

Модификация:
 * *BigIntegerSpace*
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
6. Примеры работы программы:  
+-------+-------+
|Ввод   |Вывод  |
+-------+-------+
|1 2    |3      |
|3      |2 1    |
+-------+-------+
|3      |1 2    |
|2 1    |3      |
+-------+-------+
|1      |-3 2   |
|       |       |
|2 -3   |1      |
+-------+-------+
1     2 |4 3    |
3     4 |2 1    |
+-------+-------+

