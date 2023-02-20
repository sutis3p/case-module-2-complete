package view;

import controller.AccountManager;
import controller.ProductManager;
import controller.PurchasingManager;
import io.ReadWriteFile;

import java.io.Serializable;
import java.util.Scanner;

public class UserMenu implements Serializable {
    Scanner scanner = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    AccountManager accountManager = new AccountManager();
    PurchasingManager purchasingManager = new PurchasingManager();
    ReadWriteFile readWriteFile = new ReadWriteFile();
    public void showMenuUser() {


        while (true) {
            System.out.println("""
                    ------------------------------------------------
                    |***************** User menu ******************|
                    ------------------------------------------------
                    | 1. Nhập 1 để xem danh sách sản phẩm          |
                    | 2. Nhập 2 để xem danh sách sản phẩm theo giá |
                    | 3. Nhâp 3 để mua hàng                        |
                    | 4. Nhập 4 để xem gỏ hàng                     |
                    | 5. Nhập 5 để thoát                           |
                    | Mời bạn nhập lựa chọn                        |
                    ------------------------------------------------
                    """);
            int a = Integer.parseInt(scanner.nextLine());
            switch (a) {
                case 1 -> {
                    productManager.show();
                }
                case 2 -> {
                    productManager.sortPrice();
                }
                case 3 -> {
                    System.out.println("nhap san pham muon mua");

                    int choice;
                    while (true) {
                        readWriteFile.write(ProductManager.fileProduct,ProductManager.products);
                        readWriteFile.write(AccountManager.fileAccount,AccountManager.accounts);
                        readWriteFile.read(AccountManager.fileAccount);
                        readWriteFile.read(ProductManager.fileProduct);
                        try {
                            choice = Integer.parseInt(scanner.nextLine());
                            break;

                        } catch (NumberFormatException e3) {
                            System.out.println("phai nhap so");
                        }
                    }
                   purchasingManager.purchase(choice);
//                    System.out.println(quanLyAccount.accounts.size() + ' ' + (QuanLyAccount.indexUser));
                    System.out.println(accountManager.accounts.get(AccountManager.indexUser));
                }
                case 4->{
                    System.out.println("giỏ hàng của : "+ accountManager.accounts.get(AccountManager.indexUser).getName());
                    System.out.println(accountManager.accounts.get(AccountManager.indexUser).getCart());
                    readWriteFile.write(ProductManager.fileProduct,ProductManager.products);
                    readWriteFile.write(AccountManager.fileAccount,AccountManager.accounts);
                    readWriteFile.read(AccountManager.fileAccount);
                    readWriteFile.read(ProductManager.fileProduct);
                }
                case 5 -> {
                    AccountManager.indexUser = -1;
                    return;
                }
            }
        }
    }
}
