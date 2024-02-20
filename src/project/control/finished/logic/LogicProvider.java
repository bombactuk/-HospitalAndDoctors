package project.control.finished.logic;

import project.control.finished.logic.impl.HospitalLogicImpl;

public final class LogicProvider {

    private static final LogicProvider instance = new LogicProvider();

    private LogicProvider() {
    }

    private HospitalLogic logic = new HospitalLogicImpl();

    public HospitalLogic getHospitallogic() {
        return logic;
    }

    public static LogicProvider getInstance() {
        return instance;
    }

}
