# Лабораторна робота 5
## Обробка виняткових ситуацій в Java
**Мета:**
- Зрозуміти базові принципи обробки виняткових ситуацій в Java.
- Створити спеціалізовані класи винятків для обробки конкретних помилкових сценаріїв.
- Використовувати пропагацію винятків.
**Опис:**
У цій лабораторній роботі вам потрібно реалізувати надійну і стійку до помилок програму, яка імітує спрощену банківську систему. Ця система буде включати створення рахунків, фінансові операції і функції зведення рахунків. Ваше завдання полягає в тому, щоб переконатися, що програма може елегантно обробляти різні типи помилок, не ламаючись. Реалізуйте спеціалізовані класи винятків для обробки спеціалізованих сценаріїв помилок.

**Етапи:**
- Реалізуйте клас BankAccount з членами класу accountNumber, accountName і balance.
- Реалізуйте методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary().
- Створіть спеціалізовані класи винятків:
- InsufficientFundsException
- NegativeAmountException
- AccountNotFoundException
- Реалізуйте клас Bank, який зберігає колекцію об'єктів BankAccount.<br>
**У класі Bank, реалізуйте методи:**
- createAccount(String accountName, double initialDeposit)
- findAccount(int accountNumber)
- transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
- Обробляйте винятки відповідно в кожному методі.
- Створіть тестові класи, де ви моделюєте різні сценарії для тестування обробки виняткових ситуацій.
## Опис роботи
**Чому було створено цю програму?**
- Ця програма була створена з метою моделювання спрощенної банківської системи, і вона має ряд методів для реалізації основних операцій, які можна виконувати в банківській системі.
<br>**Чому потрібна банківська система?**
- Потрібна для зберігання грошей, фінансові транзакції.
<br>**Чому програма має методи для створення акаунту, пошуку акаунту , переказ грошей, зняти готівку, депозит, підсумок рахунку, баланс?**
- Програма має ці методи для надання базового функціоналу банківської системи
<br>**Чому було використано ООП?**
- ООП дозволяє структурувати програму навколо об'єктів.
<br>**Чому в програмі використовується тестування JUnit?**
- Воно дозволяє перевіряти, чи працює програма правильно.
## Зроблена робота
Було створенно класи  BankAccount, Bank, були створенні спеціалізовані класи винятків: InsufficientFundsException,
NegativeAmountException, AccountNotFoundException.
Оглянемо клас Bank. 
- Поле "accounts" - це список банківськх рахунків.
- Конструктор "Bank" - ініціалізує поле
- Метод "createAccount" (accountName, initialDeposit) - створенний для створення акаунту у банківській системі.
- Метод "findAccount" (accountNumber) - пошук банківських рахунків
- Метод transferMoney( fromAccountNumber, toAccountNumber, amount) - транзакція грошей. Викликає методи findAccount, withdraw, deposit.
Оглянемо клас BankAccount.
- Поля "accountNumber" , "accountNumber" . "balance".
- Конструктор "BankAccount" - створення нового об'єкту.
- Методи deposit(double amount) , withdraw(double amount).
- deposit викидає виняток NegativeAmountException, якщо внесена сума від'ємна, та виняток InsufficientFundsException, якщо немає достатньо коштів для внесення.
- withdraw викидає виняток NegativeAmountException, якщо сума зняття від'ємна, та виняток InsufficientFundsException, якщо немає достатньо коштів для зняття.
  <br>*Методи для отримання інформації:*
 getAccountNumber: повертає номер банківського рахунку.
- getAccountName: повертає ім'я власника рахунку.
- getBalance: повертає поточний баланс рахунку.
- getAccountSummary: повертає рядок, що містить номер рахунку, ім'я власника та баланс.
<br>**Спеціалізовані класи винятків мали повідомлення під конкретну ситуацію**
<br>**Останнім, що було зроблено - це написані Junit тести до кожного методу для перевірки правельності виконання коду**

