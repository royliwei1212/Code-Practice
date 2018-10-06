package tech.saltyegg.dp.template;

/**
 * Description:
 *
 * @author hzhou
 */
public class CarTwo extends AbsCarModel {

    @Override
    protected void start() {
        System.out.println("car 2 starts ...");
    }

    @Override
    protected void stop() {
        System.out.println("car 2 stops ...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("car 2 engine booms ...");
    }

    @Override
    protected void alarm() {
        System.out.println("car 2 alarms ...");
    }

    @Override
    protected boolean isAlarm() {
        return false;
    }
}