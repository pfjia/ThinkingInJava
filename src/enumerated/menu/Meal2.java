package enumerated.menu;

import net.mindview.util.Enums;

/**
 * Created by pfjia on 2017/4/24 0024.
 */
public enum Meal2 {
    Appetizer(enumerated.menu.Food.Appetizer.class),

    MAINCOURSE(enumerated.menu.Food.MainCourse.class),

    DESSERT(enumerated.menu.Food.Dessert.class),

    COFFEE(enumerated.menu.Food.Coffee.class);

    private enumerated.menu.Food[] values;


    public enumerated.menu.Food randomSelection() {
        return Enums.random(values);
    }

    Meal2(Class<? extends enumerated.menu.Food> kind) {
        values = kind.getEnumConstants();
    }

    public interface Food {
        enum Appetizer implements enumerated.menu.Food {
            SALAD, SOUP, SPRING_ROLLS
        }

        enum MainCourse implements enumerated.menu.Food {
            LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
        }

        enum Dessert implements enumerated.menu.Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements enumerated.menu.Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HEWRB_TEA;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                enumerated.menu.Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
