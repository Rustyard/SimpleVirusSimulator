public class Virus {
    //潜伏期单次接触传播率
    private static double touchSpreadProbabilityWhenNotIll;

    //发病期单次接触传播率
    private static double touchSpreadProbabilityWhenIll;

    //最小潜伏期
    private static int minDaysBeforeIll;

    //最大潜伏期
    private static int maxDaysBeforeIll;


    /**
     * 初始化病毒对象（使用缺省值）
     */
    public Virus() {
        touchSpreadProbabilityWhenIll = 0.8;
        touchSpreadProbabilityWhenNotIll = 0.2;
        minDaysBeforeIll = 2;
        maxDaysBeforeIll = 15;
    }

    /**
     * 初始化病毒对象
     * @param touchWhenIll 发病期单次接触传播率
     * @param touchWhenNotIll 潜伏期单次接触传播率
     * @param minDays 最小潜伏期
     * @param maxDays 最大潜伏期
     */
    public Virus(double touchWhenIll, double touchWhenNotIll, int minDays, int maxDays) {
        touchSpreadProbabilityWhenIll = touchWhenIll;
        touchSpreadProbabilityWhenNotIll = touchWhenNotIll;
        minDaysBeforeIll = minDays;
        maxDaysBeforeIll = maxDays;
    }


    /**
     * 获取发病期单次接触传播率
     * @return 发病期单次接触传播率
     */
    public static double getTouchSpreadProbabilityWhenIll() {
        return touchSpreadProbabilityWhenIll;
    }

    /**
     * 获取潜伏期单次接触传播率
     * @return 潜伏期单次接触传播率
     */
    public static double getTouchSpreadProbabilityWhenNotIll() {
        return touchSpreadProbabilityWhenNotIll;
    }

    /**
     * 获取最大潜伏期
     * @return 最大潜伏期
     */
    public static int getMaxDaysBeforeIll() {
        return maxDaysBeforeIll;
    }

    /**
     * 获取最小潜伏期
     * @return 最小潜伏期
     */
    public static int getMinDaysBeforeIll() {
        return minDaysBeforeIll;
    }

    /**
     * 修改最大潜伏期
     * @param max 最大潜伏期
     */
    public static void setMaxDaysBeforeIll(int max) {
        maxDaysBeforeIll = max;
    }

    /**
     * 修改最小潜伏期
     * @param min 最小潜伏期
     */
    public static void setMinDaysBeforeIll(int min) {
        minDaysBeforeIll = min;
    }

    /**
     * 修改发病期单次接触传播率
     * @param touchWhenIll 发病期单次接触传播率
     */
    public static void setTouchSpreadProbabilityWhenIll(double touchWhenIll) {
        touchSpreadProbabilityWhenIll = touchWhenIll;
    }

    /**
     * 修改潜伏期单次接触传播率
     * @param touchWhenNotIll 潜伏期单次接触传播率
     */
    public static void setTouchSpreadProbabilityWhenNotIll(double touchWhenNotIll) {
        touchSpreadProbabilityWhenNotIll = touchWhenNotIll;
    }
}
