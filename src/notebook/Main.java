package notebook;

import notebook.controller.UserController;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;

import static notebook.util.DBConnectorId.DBID_PATH;
import static notebook.util.DBConnectorId.createDBId;

public class Main {
    public static void main(String[] args) {
        createDB();
        createDBId();

        GBRepository repository = new UserRepository(DB_PATH, DBID_PATH);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();

    }
}
