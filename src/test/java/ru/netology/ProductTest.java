package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {


    //тест на добавление
    @Test
    public void testAddAllBooks() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");
        Book book2 = new Book(2, "Stalker2", 650, "Strugatsky");
        Book book3 = new Book(3, "Metro 2033", 850, "Gluhovsky");
        Book book4 = new Book(4, "Metro 2035", 300, "Gluhovsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //тест на добавление нескольких товаров
    @Test
    public void testAddOneBookOneSmartphone() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");
        Book book2 = new Book(2, "Stalker2", 650, "Strugatsky");
        Book book3 = new Book(3, "Metro 2033", 850, "Gluhovsky");
        Book book4 = new Book(4, "Metro 2035", 300, "Gluhovsky");
        Smartphone phone1 = new Smartphone(5, "iphone 10", "Apple", 2_000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s9", "Samsung", 2_100);

        manager.add(book1);
        manager.add(phone2);

        Product[] expected = {book1, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //тест на поиск по названию
    @Test
    public void testSearch() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");
        Book book2 = new Book(2, "Stalker2", 650, "Strugatsky");
        Book book3 = new Book(3, "Metro 2033", 850, "Gluhovsky");
        Book book4 = new Book(4, "Metro 2035", 300, "Gluhovsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Stalker");

        Assertions.assertArrayEquals(expected, actual);
    }

    //тест на удаление нескольких товаров
    @Test
    public void testRemoveBookAndSmartphoneRepo() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");
        Book book2 = new Book(2, "Stalker2", 650, "Strugatsky");
        Book book3 = new Book(3, "Metro 2033", 850, "Gluhovsky");
        Book book4 = new Book(4, "Metro 2035", 300, "Gluhovsky");
        Smartphone phone1 = new Smartphone(5, "iphone 10", "Apple", 2_000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s9", "Samsung", 2_100);


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);

        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(5);


        Product[] expected = {book3, book4, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //тест на добаление и удаление нескольких товаров
    @Test
    public void testRemoveBookAndSmartphoneManager() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");
        Book book2 = new Book(2, "Stalker2", 650, "Strugatsky");
        Book book3 = new Book(3, "Metro 2033", 850, "Gluhovsky");
        Book book4 = new Book(4, "Metro 2035", 300, "Gluhovsky");
        Smartphone phone1 = new Smartphone(5, "iphone 10", "Apple", 2_000);
        Smartphone phone2 = new Smartphone(6, "Galaxy s9", "Samsung", 2_100);


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        manager.add(phone2);

        manager.removeById(1);
        manager.removeById(3);
        manager.removeById(5);


        Product[] expected = {book2, book4, phone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //тест на поиск одного товара
    @Test
    public void TestOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Stalker", 150, "Strugatsky");

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    //тест на поиск без товара
    @Test
    public void testNullProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
