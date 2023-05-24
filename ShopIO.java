package ShopDemo;

import ShopDemo.Sort.CompPriceUp;
import ShopDemo.Sort.ComparatorPrice;

import java.util.*;

public class ShopIO {
    private Shop shop;
    private AppUtil appUtil;


    public ShopIO() {
        this.shop = new Shop();
        this.appUtil = new AppUtil();
    }


    public void startApp() {
        try {
            showMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showMenu() {
        try {
            appUtil.appWrite(ShopMessages.MENU_MESSAGES);
            String userInput = appUtil.appRead(); // то что вводит пользователь
            while (userProductSorted(userInput)) {
                appUtil.appWrite(ShopMessages.MENU_MESSAGES);
                userInput = appUtil.appRead();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showMenu();
        }
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    public boolean userProductSorted(String userInput) throws Exception {

        switch (userInput) {
            case "1":
                getAllProducts();
                break;
            case "2":
                addProductWithUser();
                break;
            case "3":
                deleteProductWithUser();
                break;
            case "4":
                setProductChoiceWithUser();
                break;
            case "0":
                return false; // признак окончания работы
            default:
                appUtil.appWrite(ShopMessages.WRONG_INPUT);
        }
        return true;
    }


    public void getAllProducts() throws Exception {
        boolean repeatGetProducts = true;
        while (repeatGetProducts) {
            appUtil.appWrite(ShopMessages.PRODUCT_GETTING);
            if (shop.getProducts().size() == 0) {
                appUtil.appWrite(ShopMessages.PRODUCT_NOT_FOUND);
                return;
            }
            appUtil.appWrite(ShopMessages.MENU_CHOICE_SORT);
            int userInput = appUtil.readInt();
            Set<Product> productSet;
            switch (userInput) {
                case 1:
                    productSet = new TreeSet<>(new CompPriceUp());
                    fillTreeSet(productSet, shop.getProducts());
                    showAllproducts(productSet);
                    repeatGetProducts = false;
                    break;
                case 2:
                    productSet = new TreeSet<>(new ComparatorPrice());
                    fillTreeSet(productSet, shop.getProducts());
                    showAllproducts(productSet);
                    repeatGetProducts = false;
                case 3:
                    showAllproducts(shop.getProducts());
                    break;
                case 0:
                    repeatGetProducts = false;
                default:
                    appUtil.appWrite(ShopMessages.WRONG_INPUT);
            }
        }
    }

    private void showAllproducts(Set<Product> products) {
        for (Product p : products) {
            appUtil.appWrite(String.valueOf(p));
        }

    }

    private void fillTreeSet(Set<Product> fillTreeSet, Set<Product> products) {
        fillTreeSet.addAll(products);
    }

    public void addProductWithUser() throws Exception {
        appUtil.appWrite(ShopMessages.PRODUCT_ADDING);
        Product product = getUserData();
        if (!shop.addProduct(product)) {
            appUtil.appWrite(ShopMessages.CANNOT_SAVE_OR_UPDATE);
        }
    }

    private Product getUserData() throws Exception {
        appUtil.appWrite(ShopMessages.GET_ID);
        int id = appUtil.readInt();
        appUtil.appWrite(ShopMessages.GET_NAME);
        String name = appUtil.appRead();
        appUtil.appWrite(ShopMessages.GET_PRICE);
        int price = appUtil.readInt();
        return new Product(id, name, price);
    }


    public void deleteProductWithUser() throws Exception {
        appUtil.appWrite(ShopMessages.PRODUCT_REMOVING);
        appUtil.appWrite(ShopMessages.GET_ID);
        int id = appUtil.readInt();
        if (!shop.removeProduct(id)) {
            appUtil.appWrite(ShopMessages.CANNOT_REMOVE);
        }

    }

    public void setProductChoiceWithUser() throws Exception {
        appUtil.appWrite(ShopMessages.PRODUCT_GHANGING);
        Product product = getUserData();
        if (!shop.changeProduct(product)) {
            appUtil.appWrite(ShopMessages.CANNOT_SAVE_OR_UPDATE);
        }


    }
}


