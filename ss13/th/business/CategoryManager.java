package th.business;

import th.model.Category;
import th.myInterface.IManager;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager implements IManager<Category> {
    List<Category> categories= new ArrayList<>();
    @Override
    public void add(Category category) {
        categories.add(category);
        System.out.println("Them moi danh muc thanh cong");
    }

    @Override
    public void delete(int id) {
        boolean isDelete=false;
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.remove(i);
                isDelete=true;
                break;
            }
        }
        if(isDelete){
            System.out.println("Xoa thanh cong");
        }else{
            System.out.println("Khong tim thay danh muc cos id "+id);
        }

    }

    @Override
    public void update(Category item) {
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==item.getId()){
                categories.set(i,item);
                System.out.println("Cap nhat thanh cong");
                break;
            }
        }
    }

    @Override
    public void displayAll() {
        for(int i=0;i<categories.size();i++){
            categories.get(i).displayInfo();
        }
    }
}
