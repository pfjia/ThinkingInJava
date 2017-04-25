package enumerated;


import java.text.DateFormat;
import java.util.Date;

/**
 * Created by pfjia on 2017/4/25 0025.
 */
public enum ConstantSpecificMethod {
    DATA_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm :
            values()) {
            System.out.println(csm.getInfo());
        }
    }

}
