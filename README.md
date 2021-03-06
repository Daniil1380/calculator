### Строчный калькулятор

Сервис предоставляет собой rest-controler для расчета строчных выражений. Сервис поддерживает все основные символы математических операторов, а также несколько специальных:

Например:

```
5+4/2-4*3=-5
5*pi=15,7079...
```

#### Запуск

Для старта приложения необходимо выполнить команду 

```
docker build . -t <app-name>
```

После чего вызвать

```
docker run -p 8080:8080 <app-name>
```

#### Работа с калькулятором

После запуска для получения ответа необходимо обратиться к endpoint:

```
api/calculator
```

C указанием параметра запроса exp

```
?exp=<expression>
```

Например, если мы хотим посчитать 2*e-4, то финальный вариант будет

```
api/calculator?exp=2*e-4
```

Ответ представляет из себя число вещественного типа. В данном случает ответ будет

```
1.4365636569180902
```

#### Поддержка доп. символов

Калькулятор поддерживает операции сложения, вычитания, умножения, деления, расставления скобок, а также операторы pi и e. Количество поддерживаемых символов будет увеличиваться.

#### Поддержка продукта

Любой участник сообщества в праве предлагать свои идеи, а также их реализацию. have a fun :)

#### CI/CD - https://circleci.com/ 

develop branch: [![CircleCI](https://circleci.com/gh/Daniil1380/calculator/tree/develop.svg?style=svg)](https://circleci.com/gh/Daniil1380/calculator/tree/develop)

master branch: [![CircleCI](https://circleci.com/gh/Daniil1380/calculator/tree/develop.svg?style=svg)](https://circleci.com/gh/Daniil1380/calculator/tree/master)

