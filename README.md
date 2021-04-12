# ITMO-prog-intro-course
my homeworks for prog-intro-2020 course 

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
