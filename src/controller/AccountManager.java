package controller;

import io.ReadWriteFile;
import model.Account;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    Scanner scanner = new Scanner(System.in);

    public static File fileAccount = new File("Account.txt");
    public static ReadWriteFile readWriteFile = new ReadWriteFile();
    public static ArrayList<Account> accounts = readWriteFile.read(fileAccount);

    public static int indexUser;

    //tạo một quản trị viên cố định
    final Account Admin = new Account("Admin", "Quan tri vien", 8, "1");

    public AccountManager() {
        Account account1 = new Account("Admin", "Admin", 15, "1");
    }

    public void CreateAccount() {
        String username;
        String name;
        String password;
        int age = 0;
        do {
            do {
                System.out.println("nhap username");
                username = scanner.nextLine();
            } while (username.equals("Admin"));
            System.out.println("nhap ten hien thi");
            name = scanner.nextLine();
            System.out.println("nhap PassWord");
            password = scanner.nextLine();
            System.out.println("nhap tuoi");
            while (true) {
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    break;

                } catch (NumberFormatException e2) {
                    System.out.println("tuoi la so");
                }
            }
        } while (username.equals("") || name.equals("") || password.equals("") || age > 120 || age < 0);
        Account account = new Account(username, name, age, password);
        accounts.add(account);
    }
    public int login(String username, String password) {
        int check = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (username.equals(accounts.get(i).getUsername())) {
                if (password.equals(accounts.get(i).getPassword())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean checkLogin(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (account.getUsername().equals(accounts.get(i).getUsername()) && account.getPassword().equals(accounts.get(i).getPassword()))
                return true;
        }
        return false;
    }

}
