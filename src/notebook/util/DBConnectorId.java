package notebook.util;

import java.io.File;

public class DBConnectorId {
    public static final String DBID_PATH = "dbId.txt";
    public static void createDBId() {
        try {
            File dbId = new File(DBID_PATH);
            if (dbId.createNewFile()) {
                System.out.println("DBID created");
            }
            else {
                System.out.println("DBID already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
