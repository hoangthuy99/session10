package ra.entity;

import ra.IShop;
import ra.run.Shopmanagement;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {

    private int catalogId;
    private String catalogName;
    private Boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, Boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }



    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    @Override
    public void inputData(Scanner scanner) {
        this.catalogId = generateIdentityValue(Shopmanagement.listCategories);
        this.catalogName = inputCatalogName(scanner, Shopmanagement.listCategories);
        this.status = inputCatalogStatus(scanner);
    }


    @Override
    public void displayData() {

    }


    @Override
    public String toString() {
        return "Categories{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", status=" + status +
                '}';
    }

    public int generateIdentityValue(List<Categories> listcategories ){
        try {
            if (listcategories.size() == 0) {
                return 1;
            } else {
                int max = listcategories.get(0).getCatalogId();
                for (int i = 0; i < listcategories.size(); i++) {
                    if (listcategories.get(i).getCatalogId() > max) {
                        max = listcategories.get(i).getCatalogId();
                    }
                }
                return max + 1;
            }
        } catch (Exception e) {
            System.err.println("Có lỗi: " + e);
        }
        return 1;

    }
    public String inputCatalogName(Scanner scanner, List<Categories> listCategories) {
        System.out.println("Nhập tên danh mục: ");
        do {
            String catalogName = scanner.nextLine();
            boolean isExit = false;
            for (int i = 0; i < listCategories.size(); i++) {
                if (listCategories.get(0).getCatalogName().equals(catalogName)) {
                    isExit = true; //bị trùng
                    break;
                }
            }
            if (isExit) {
                System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
            } else {
                return catalogName;
            }
        } while (true);
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Nhập trạng thái danh mục: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận true/false, vui lòng nhập lại!");
            }
        } while (true);
    }
}
