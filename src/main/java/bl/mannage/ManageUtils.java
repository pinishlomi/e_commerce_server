package bl.mannage;

import bl.general.Category;

/**
 * Created by Pini Shlomi At 10/07/2024
 */
public class ManageUtils {
    public static Category getCategory(String category){
        for (Category c: Category.values()){
            if (c.name().equals(category.toUpperCase())){
                return c;
            }
        }
        return null;
    }

    public static Category getCategoryByIndex(int categoryNum){
        Category[] categories = Category.values();
        if (categoryNum < 0 || categoryNum >= categories.length){
            return null;
        }
        return categories[categoryNum];
    }

    public static String getAllCategories() {
        StringBuilder sb = new StringBuilder("All Categories:\n");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++){
            sb.append(i+1).append(") ").append(categories[i]).append("\n");
        }
        return sb.toString();
    }
}
