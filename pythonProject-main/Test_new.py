from unittest.mock import Mock

import pytest
from Tasks import Tasks

# Задание 1
def test_average ():
    numbers = [10, 20, 30, 40, 50]
    assert Tasks.find_average(numbers) == 30

def test_average_null ():
    assert Tasks.find_average([]) == 0


# Задание 2
def test_average_not_list ():
    string_list = ["10", "20", "30", "40", "50"]
    with pytest.raises(TypeError):
        Tasks.find_average(string_list)

# Задание 3

def test_check_receive_money():
    person = Tasks.Person(200)
    bank = Tasks.Bank()

    person.transfer_money(100, bank)
    assert person.balance == 100
    assert bank.balance == 100

def test_check_receive_money_fall():
    person = Tasks.Person(200)
    bank = Tasks.Bank()
    with pytest.raises(ValueError):
        person.transfer_money(250, bank)

def test_check_receive_money_mock():
    bank = Mock()
    person = Tasks.Person(200)
    person.transfer_money(100, bank)

    bank.receive_money.assert_called_with(100)

# Задание 5
def test_division_zero():
    with pytest.raises(ZeroDivisionError):
        Tasks.divide(10, 0)



# Задание 6
@pytest.mark.parametrize("a, b, expected", [
    (10, 0, 0), (2, 3, 6), (-2, 10, -20)])
def test_mult(a, b, expected):
    assert Tasks.multiply(a, b) == expected

    # @staticmethod
    # def multiply(a, b):
    #     return a * b

# Задание 7
def test_len_string():
    assert len("Geek") == 4  # Строка из 6 символов
    assert len("") == 0  # Пустая строка
    assert len(" ") == 1  # Строка из одного пробельного символа
    assert len("Hello, World!") == 13  # Строка с пробелами и знаками препинания


# Задание 9
@pytest.mark.parametrize("test_input,expected", [
    (2, True), (11, True), (6, False)])
def test_is_prime_positive(test_input, expected):
    assert Tasks.is_prime(test_input) == expected



    # def is_prime(n):
    #     """Проверяет, является ли число простым."""
    #     if n < 2:
    #         return False
    #     for i in range(2, int(n ** 0.5) + 1):
    #         if n % i == 0:
    #             return False
    #     return True