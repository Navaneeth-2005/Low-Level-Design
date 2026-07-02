import java.util.ArrayList;
import java.util.List;

interface CartItem{
    double getPrice();
    void displayItem();
}

class Product implements CartItem{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public void displayItem(){
        System.out.println("Product: " + name + ", Price: " + price);
    }
}

class ProductBundle implements CartItem{
    private String bundleName;
    private ArrayList<CartItem> items;

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item){
        items.add(item);
    }

    @Override
    public double getPrice(){
        double totalPrice = 0;
        for(CartItem item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void displayItem(){
        System.out.println("Product Bundle: " + bundleName);
        for(CartItem item : items){
            item.displayItem();
        }
    }
}

public class composite {
    public static void main(String[] args){
          // Individual Products
        CartItem book = new Product("Atomic Habits", 499);
        CartItem phone = new Product("iPhone 15", 79999);
        CartItem earbuds = new Product("AirPods", 15999);
        CartItem charger = new Product("20W Charger", 1999);

        // Combo Deal
        ProductBundle iphoneCombo = new ProductBundle("iPhone Essentials Combo");
        iphoneCombo.addItem(phone);
        iphoneCombo.addItem(earbuds);
        iphoneCombo.addItem(charger);

        // Back to School Kit
        ProductBundle schoolKit = new ProductBundle("Back to School Kit");
        schoolKit.addItem(new Product("Notebook Pack", 249));
        schoolKit.addItem(new Product("Pen Set", 99));
        schoolKit.addItem(new Product("Highlighter", 149));

        // Add everything to cart
        List<CartItem> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphoneCombo);
        cart.add(schoolKit);

        // Display cart
        System.out.println("Your Amazon Cart:");
        double total = 0;
        for (CartItem item : cart) {
            item.displayItem();
            total += item.getPrice();
        }

        System.out.println("\nTotal: ₹" + total);

    }
    
}
