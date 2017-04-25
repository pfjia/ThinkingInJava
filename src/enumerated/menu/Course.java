package enumerated.menu;

import net.mindview.util.Enums;

/**
 * Created by pfjia on 2017/4/24 0024.
 */
public enum Course {
    //每一个常量都是Course类型的，所以在Course中定义的方法每个常量都可以使用
    Appetizer(Food.Appetizer.class),

    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;


    public Food randomSelection() {
        return Enums.random(values);
    }

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
}
