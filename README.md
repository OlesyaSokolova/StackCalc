Факультет Информационных Технологий,  2-й курс, IV семестр  
Курс: Объектно-ориентированное программирование  

Программа реализована в соответствии с заданием:
# Стековый калькулятор

Шаблон проектирования «фабричный метод», журналирование (logging), модульное тестирование (unit testing).


   1. Часть 1.
Написать стековый калькулятор, который принимает в качестве аргумента командой строки имя файла, содержащего команды. Если аргумента нет, то использовать стандартный поток ввода для чтения команд. Использовать вещественные числа.
Реализовать следующий набор команд:
* # - строка с комментарием.
* POP, PUSH — снять/положить число со/на стек(а).
* + , - , * , /, SQRT – арифметические операции. Используют один или два верхних элемента стека, изымают их из стека, помещая результат назад
* PRINT — печать верхнего элемента стека (без удаления).
* DEFINE — задать значение параметра. В дальнейшем везде использовать вместо параметра это значение. 


Пример (должно вывести 2): 
DEFINE a 4
PUSH a
SQRT 
PRINT

Часть 2.
1. Реализовать набор модульных тестов, покрывающих функционал калькулятора.
      1. Методические указания:
* Создание команд рекомендуется реализовать посредством шаблона проектирования «фабричный метод» (http://ru.wikipedia.org/wiki/Фабричный_метод_(шаблон_проектирования)).
* Аргументы команде (тем у которых есть аргументы) на исполнение можно передавать в виде массива либо списка объектов, команда сама должна уметь интерпретировать свои аргументы
* Содержимое стека и список (лучше ассоциативный контейнер Map<String, Double>) определенных именованных параметров передавать команде в виде специального объекта — контекста исполнения 
* Разработать иерархию исключений, которые будут выбрасывать команды при исполнении. В случае возникновения исключения — выводить информацию об ошибке и продолжать исполнение программы (из файла или команд вводимых с консоли)
* Для реализации модульных тестов используется JUnit (http://www.junit.org/).
