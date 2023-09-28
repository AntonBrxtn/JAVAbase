package JAVAbase;
/* 
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class program {
  public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        addContacts(phonebook, "Sergey", "331245");
        addContacts(phonebook, "Vyacheslav", "465412");
        addContacts(phonebook, "Ekaterina", "885643");
        addContacts(phonebook, "Maria", "982654");
        addContacts(phonebook, "Ekaterina", "986654");
        addContacts(phonebook, "Vyacheslav", "909846");
        addContacts(phonebook, "Ekaterina", "365497");
        print(phonebook);
    }

    public static void addContacts(HashMap<String, String> book, String contact, String phone) {
        book.merge(contact, phone, (ph1, ph2) -> ph1 + ", " + ph2);
    }

    public static void print(HashMap<String, String> book) {
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(book.entrySet());
        list.sort((o1, o2) -> o2.getValue().length() - o1.getValue().length());
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}