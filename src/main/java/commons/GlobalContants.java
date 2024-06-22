package commons;

import java.io.File;
import java.time.Duration;

public class GlobalContants {
    public static final String END_USER_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";

    public static final String EMAIL_ADDRESS_ADMIN = "admin@yourstore.com";
    public static final String PASSWORD_ADMIN = "admin";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FILE_IMAGE_PATH = PROJECT_PATH + File.separator + "image" + File.separator;

    public static final long LONG_TIME = 20;
    public static final long SHORT_TIME = 5;
    
    public static final String JAVA_VERSION = System.getProperty("java.version");
    
}
