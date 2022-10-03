
/* так як нам необхідно просто згрупувати характеристики окремої машини і не визначати додаткові методи, замість
* class використовуємо record. тоді конструктори, гетери, методи equals() і toString() генеруються компілятором автоматично,
* а кількість коду в рази зменшується. */

public record Car(int id,
                  String mark,
                  String model,
                  Integer releaseYear,
                  String color,
                  Double price,
                  String registrationNumber) {

    /* хоч метод toString() (для виведення даних об'єкта в консоль) генерується автоматично, ми його трошки перевизначаємо
    (для красивішого виводу)
     */

    public String toString() {
        return String.format("""
            Car %d: %s %s, %d, %s, %f $, rn: %s
            """, id, mark, model, releaseYear, color, price, registrationNumber );
    }
}
