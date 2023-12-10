package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.*;

public class Shopmanagement {
    public static List<Categories> listCategories = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shopmanagement shopmanagement = new Shopmanagement();
        int choice;
        do {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("Vui lòng nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shopmanagement.categoryManagementMenu(scanner,shopmanagement);
                    break;
                case 2:
                    shopmanagement.productManagementMenu(scanner,shopmanagement);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }


    private static void categoryManagementMenu(Scanner scanner, Shopmanagement shopmanagement) {
        int choice;
        boolean isExit = true;

        do {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.println("Vui lòng nhập lựa chọn của bạn");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Mời bạn nhập số lượng danh mục: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Categories categories = new Categories();
                        categories.inputData(scanner);
                        listCategories.add(categories);
                    }
                    break;
                case 2:
                    // Hiển thị thông tin các danh mục
                    System.out.println("- Thông tin danh mục: ");
                    for (int i = 0; i < listCategories.size(); i++) {
                        Categories categories = new Categories();
                        categories.displayData();
                        System.out.println("\n----------------------------------");
                    }
                    break;
                case 3:
                    // Cập nhật thông tin danh mục
                    System.out.println("Mời bạn nhập mã danh mục cần cập nhật: ");
                    int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < listCategories.size(); i++) {
                        Categories categories = new Categories();
                        if (categories.getCatalogId() == catalogIdUpdate) {
                            categories.inputCatalogName(scanner, Shopmanagement.listCategories);
                            System.out.println("Tên danh mục danh mục đã được cập nhật");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
                    }
                    break;
                case 4:
                    // Xóa danh mục
                    System.out.println("Mời bạn nhập mã danh mục cần xóa: ");
                    int cataIdDelete = Integer.parseInt(scanner.nextLine());
                    Iterator<Categories> iterator = listCategories.iterator();
                    while (iterator.hasNext()) {
                        Categories categories = new Categories();
                        if (categories.getCatalogId() == cataIdDelete) {
                            iterator.remove();
                            System.out.println("Thông tin danh mục đã xóa");
                        }
                    }
                    System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");

                    break;

                case 5:
                    isExit = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        } while (isExit);
    }


    private static void productManagementMenu(Scanner scanner,Shopmanagement shopmanagement) {
        int choice;
        boolean isExit = true;

        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
            System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("9. Thoát");
            System.out.println("Vui lòng nhập lựa chọn của bạn! ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng sản phẩm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Product product = new Product();
                        product.inputData(scanner);
                        listProduct.add(product);
                    }
                case 2:
                    // Hiển thị thông tin các sản phẩm
                    for (int i = 0; i < listProduct.size(); i++) {
                        Product product = new Product();
                        product.displayData();
                        System.out.println("\n-----------------------------------");
                    }
                case 3:
                    System.out.println("Mời bạn nhập mã sản phẩm cần cập nhật: ");
                    int productIdUpdate = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < listProduct.size(); i++) {
                        Product product = new Product();
                        if (product.getProductId().equals(productIdUpdate)) {
                            product.inputPrice(scanner);
                            System.out.println("Gía sản phẩm đã được cập nhật");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
                    }
                    break;
                case 4:
                    System.out.println("Mời bạn nhập mã danh mục cần xóa: ");
                    int productIdDelete = Integer.parseInt(scanner.nextLine());
                    Iterator<Product> iterator = listProduct.iterator();
                    while (iterator.hasNext()) {
                        Product product = new Product();
                        if (product.getProductId().equals(productIdDelete)) {
                            iterator.remove();
                            System.out.println("Thông tin danh mục đã xóa");
                        }
                    }
                    System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
                    break;

                case 5:
                    Collections.sort(listProduct, Comparator.comparing(Product::getPrice));
                    break;
                case 6:
                    Collections.sort(listProduct, Comparator.comparing(Product::getProductName));
                    break;
                case 7:
                    // Tìm kiếm sản phẩm trong khoảng giá a - b
                    Map<String, Integer> statistical = new HashMap<>();
                    for (int i = 0; i < listProduct.size(); i++) {
                        Product product = listProduct.get(i);
                        String catalogId = String.valueOf(product.getCatalogId()); // Lấy danh mục từ sản phẩm
                        statistical.put(catalogId, statistical.getOrDefault(catalogId, 0) + 1);
                    }
                    // In ra thống kê
                    for (String catalogId : statistical.keySet()) {
                        System.out.println("Danh mục: " + catalogId + ", Số lượng: " + statistical.get(catalogId));
                    }
                    break;
                case 8:
                    System.out.println("Mời bạn nhập tên sản phẩm: ");
                    String searchProductName = scanner.nextLine();
                    boolean found1 = false;
                    for (int i = 0; i < listProduct.size(); i++) {
                        Product product = listProduct.get(i);
                        if (product.getProductName().equalsIgnoreCase(searchProductName)) {//Không phân biệt chữ hoa với chữ thường
                            System.out.println(product);
                        }
                    }
                    if (!found1) {
                        System.err.println("Không tìm thấy tên sản phẩm, vui lòng nhập lại!");
                    }
                    break;
                case 9:
                    isExit = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (isExit);

    }
}

