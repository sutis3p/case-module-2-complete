package controller;

import java.io.Serializable;

public class PurchasingManager implements Serializable {
    AccountManager accountManager = new AccountManager();
    public void purchase(int id) {
        try {
            accountManager.accounts.get(AccountManager.indexUser).getCart().add(ProductManager.products.get(id));
        }catch (Exception e){
            System.out.println("ko co san pham");
        }
    }
}
