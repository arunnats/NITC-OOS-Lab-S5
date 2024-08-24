import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Inventory<Product> inventory = new Inventory<>();

        Electronics ipad = new Electronics("Ipad", 12);
        Clothing shirt = new Clothing("Shirt", "L");

        inventory.addProduct(ipad);
        inventory.addProduct(shirt);

        inventory.listProducts();

        inventory.removeProduct(ipad);

        inventory.listProducts();
    }
}

class Inventory<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("List of products:");
            for (T product : products) {
                System.out.println(product);
            }
        }
    }
}

class Product {
  private String name;

  public Product(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  @Override
  public String toString() {
      return "Product: " + name;
  }
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(String name, int warrantyPeriod) {
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics: " + this.getName() + ", Warranty Period: " + this.getWarrantyPeriod() + " months";
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothing: " + this.getName() + ", Size: " + this.getSize();
    }
}
