package ra;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public interface IShop {
    void inputData(Scanner scanner);
    void displayData();

    int compareTo(Product otherProduct);
}
