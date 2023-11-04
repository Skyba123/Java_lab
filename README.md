# Лабораторна робота 3
## Завдання
**Мета: Основна мета цього лабораторного завдання — зрозуміти, як працює JUnit та Moskito. Вміти використовувати на практиці підходи. До кінця цієї лабораторної роботи ви повинні вміти писати розширені тестові випадки з використанням JUnit та мокати поведінку методів.**

**Завдання: Створіть базову систему електронної комерції, яка складається з сутностей Product, Cart та Order. Система повинна дозволяти користувачам:**

- Додавати продукти до кошика.

- Видаляти продукти з кошика.

- Робити замовлення з товарів у кошику.

- Перевіряти статус замовлення. 
**Після реалізації системи електронної комерції:**
**Напишіть тестові випадки JUnit для тестування всіх функцій.**
**Замокайте поведінку методів**
**Вимоги:**


1. Сутності:

- `Product`: Повинен мати атрибути, такі як `id`, `name`, `price` .

- `Cart`: Повинен зберігати список продуктів.

- `Order`: Повинен мати атрибути, такі як `orderId`, `products`, `status`.

2. Функціональність:
- Додати/видалити продукт з кошика.

- Робити замовлення з товарів у кошику.

- Отримувати статус конкретного замовлення.

3.  Тестування JUnit:
- Протестуйте, чи продукти додаються/видаляються правильно з кошика.

- Протестуйте функціональність розміщення замовлення.

- Протестуйте функціональність отримання статусу замовлення.
## Опис роботи
**Чому було створено цю програму?**
- Ця програма була створена для моделювання базової системи електронної комерції. Головна мета програми - надати можливість користувачам додавати продукти до кошика, видаляти їх з кошика, робити замовлення з продуктів у кошику та перевіряти статус замовлення.
<br>**Чому потрібна корзина продуктів у електронній комерції?**
- Вона дозволяє користувачам легко вибирати і керувати товарами, які вони планують придбати. Корзина надає зручний спосіб організації товарів перед їхнім оформленням у замовлення. Користувач може додавати та видаляти товари, поки не буде готовий оформити замовлення.
<br>**Чому програма має методи для додавання, видаляння , перевірка статусу, робити замовлення продукту?**
- Програма має методи для додавання, видалення, перевірки статусу та роблення замовлення продукту, оскільки ці операції є ключовими для функціонування електронного магазину. Додавання продукту в корзину дозволяє клієнтам збирати товари, які їх цікавлять. Видалення товарів з корзини дозволяє коригувати вибір. Робота замовлення з продуктів у корзині оформляє покупку. Перевірка статусу замовлення дає інформацію користувачам про те, на якому етапі знаходиться їхнє замовлення.
<br>**Чому було використано ООП?**
- ООП  дозволяє структурувати програму навколо об'єктів(книг, бібліотеки).
<br>**Чому в програмі використовується тестування JUnit?**<br>
- Воно дозволяє перевіряти, чи працює програма правильно.
## Опис коду 
- Було створенно 3 класи згідно вимогам.
- У класі Cart було створено методи addProduct (добавлення продуктів в корзину) removeProduct (видалення продуктів з корзини) і getProducts (вертає список продуктів).
- Order був створенний для слідкування замовлень.
- Були створені тести JUnit і Mockito 
