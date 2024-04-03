import java.io.*;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    // Constructor
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        // Serialize the object
        Product product = new Product(101, "Laptop", "Electronics", 1500.00);
        serializeObject(product);

        // Deserialize the object
        Product deserializedProduct = deserializeObject();
        System.out.println("Deserialized Product Details:");
        System.out.println("ID: " + deserializedProduct.getId());
        System.out.println("Name: " + deserializedProduct.getName());
        System.out.println("Category: " + deserializedProduct.getCategory());
        System.out.println("Price: " + deserializedProduct.getPrice());
    }

    public static void serializeObject(Product product) {
        try {
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in product.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Product deserializeObject() {
        Product product = null;
        try {
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            product = (Product) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
