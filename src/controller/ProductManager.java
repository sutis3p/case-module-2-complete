package controller;

import io.ReadWriteFile;
import model.BodyMist;
import model.Product;
import model.ShowerGel;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager implements Serializable {
    Scanner scanner = new Scanner(System.in);
    AccountManager accountManager = new AccountManager();
    public static ReadWriteFile readWriteFile = new ReadWriteFile();
    public static File fileProduct = new File("Product.txt");
    public static ArrayList<Product> products = readWriteFile.read(fileProduct);

    public static void showListProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void add(Product product) {
        products.add(product);
        readWriteFile.write(fileProduct, products);
    }

    int id = 0;

    public Product create() {
        int b = 0;
        while (true) {
            System.out.println("Nhập 1 để chọn BodyMist");
            System.out.println("Nhập 2 để chọn ShowerGel");
            try {
                b = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        }

        if (b == 1) {
            id++;
            System.out.println("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.println("Nhập thể tích sản phẩm : ");
            int volume = 0;
            while (true) {
                try {
                    volume = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("phai nhap so");
                }

            }
            System.out.println("Nhập nhập số lượng sản phẩm : ");
            int amount = 0;
            while (true) {
                try {
                    amount = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("phải nhập số");
                }
            }
            System.out.println("Nhập giá cho sản phẩm : ");
            double price = 0;
            while (true) {
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("phải nhập số");
                }
            }
            BodyMist bodyMist = new BodyMist(id, name, volume, amount, price);
            readWriteFile.write(fileProduct, products);
            return bodyMist;
        } else {
            id++;
            System.out.println("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.println("Nhập thể tích sản phẩm : ");
            int volume = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập nhập số lượng sản phẩm : ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập giá cho sản phẩm : ");
            double price = Double.parseDouble(scanner.nextLine());
            ShowerGel showerGel = new ShowerGel(id, name, volume, amount, price);
            readWriteFile.write(fileProduct, products);
            return showerGel;
        }
    }

    public void show() {
        System.out.printf("%-15s%-15s%-15s%-15s%-6s\n","Price", "Product", "Name", "Volume", "Amount");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public int findIdByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
    public void Delete ( int index){
        try {
            products.remove(index);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("ko tim thay ten nay");
        }
    }
    public void edit (int index, Product product){
        products.set(index, product);
        products.get(index).setName(product.getName());
        products.get(index).setVolume(product.getVolume());
        products.get(index).setAmount(product.getAmount());
        products.get(index).setPrice(product.getPrice());
        readWriteFile.write(fileProduct,products);
    }
    public void search () {
        System.out.println("nhap ten muon tim");
        String name = scanner.nextLine();
        System.out.printf("%-15s%-15s%-15s%-15s%-6s\n","Price", "Product", "Name", "Volume", "Amount");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                System.out.println(products.get(i).toString());
            }
        }
    }
    public static void sortPrice () {
        List<Product> sortedListAnimals = products.stream().sorted(Comparator.comparing(o -> o.getPrice()))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedListAnimals.size(); i++) {
            System.out.println(sortedListAnimals.get(i));

        }
    }
}
