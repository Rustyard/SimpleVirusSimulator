public class Student {
    //是否携带病毒
    private boolean virusCarried;

    //是否带口罩
    private boolean maskWore;

    //是否发病
    private boolean ill;

    //是否被隔离
    private boolean quarantine;

    //若携带了病毒，多少天后会发病
    private int daysBeforeIll;

    //天数计数器
    private int days;

    //口罩能够降低的感染率
    private double maskPower;

    //病毒
    Virus virus = new Virus();

    /**
     * 初始化一个学生
     */
    public Student() {
        virusCarried = false;
        maskWore = false;
        ill = false;
        quarantine = false;
        days = 0;
        daysBeforeIll = Integer.MAX_VALUE;
        maskPower = 0.3;
    }

    //get&set方法

    /**
     * 是否发病
     * @return 发病状态
     */
    public boolean isIll() {
        return ill;
    }

    /**
     * 是否戴着口罩
     * @return 戴口罩状态
     */
    public boolean isMaskWore() {
        return maskWore;
    }

    /**
     * 是否被隔离
     * @return 隔离状态
     */
    public boolean isQuarantine() {
        return quarantine;
    }

    /**
     * 是否携带病毒
     * @return 携带病毒状态
     */
    public boolean isVirusCarried() {
        return virusCarried;
    }

    /**
     * 获取潜伏期
     * @return 潜伏期
     */
    public int getDaysBeforeIll() {
        return daysBeforeIll;
    }

    /**
     * 返回天数计数器的计数，若感染病毒则为感染以来经过的天数
     * @return 天数计数
     */
    public int getDays() {
        return days;
    }

    /**
     * 设定发病状态
     * @param ill 是否发病
     */
    public void setIll(boolean ill) {
        this.ill = ill;
    }

    /**
     * 设定口罩是否穿戴
     * @param maskWore 是否戴口罩
     */
    public void setMaskWore(boolean maskWore) {
        this.maskWore = maskWore;
    }

    /**
     * 设定隔离状态
     * @param quarantine 是否被隔离
     */
    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    /**
     * 设定潜伏期
     * @param daysBeforeIll 潜伏期
     */
    public void setDaysBeforeIll(int daysBeforeIll) {
        this.daysBeforeIll = daysBeforeIll;
    }

    /**
     * 设置天数计数器
     * @param days 天数
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * 获取口罩强度
     * @return 口罩强度
     */
    public double getMaskPower() {
        return maskPower;
    }

    /**
     * 设置口罩强度
     * @param maskPower 口罩强度
     */
    public void setMaskPower(double maskPower) {
        this.maskPower = maskPower;
    }

    /**
     * 设定病毒携带情况，若将要携带病毒，再随机设定发病前天数。
     * @param virusCarried 是否携带病毒
     */
    public void setVirusCarried(boolean virusCarried) {
        this.virusCarried = virusCarried;
        if (virusCarried) {
            setDaysBeforeIll((int) (Math.random() * (virus.getMaxDaysBeforeIll() - virus.getMinDaysBeforeIll() + 1) + virus.getMinDaysBeforeIll()));
            setDays(0);
        }
    }

    /**
     * 模拟此学生与其他学生接触，由隔离情况，是否携带病毒，是否发病，是否戴口罩决定传播概率。
     * @param other 其他学生
     */
    public void touchWith(Student other) {
        if (!this.quarantine && !other.quarantine) {
            if (!this.virusCarried && !other.virusCarried) {
                //Nothing will happen.
            } else if (this.virusCarried && other.virusCarried) {
                //Nothing will happen as well.
            } else if (!this.virusCarried) {
                //This student get virus by chance.
                if (other.ill) {
                    if (this.isMaskWore() && other.isMaskWore()) {
                        if (Math.random() < maskPower * maskPower * virus.getTouchSpreadProbabilityWhenIll()) {
                            setVirusCarried(true);
                        }
                    }
                    else if (this.isMaskWore() || other.isMaskWore()) {
                        if (Math.random() < maskPower * virus.getTouchSpreadProbabilityWhenIll()) {
                            setVirusCarried(true);
                        }
                    }
                    else {
                        if (Math.random() < virus.getTouchSpreadProbabilityWhenIll()) {
                            setVirusCarried(true);
                        }
                    }
                }
                else {
                    if (this.isMaskWore() && other.isMaskWore()) {
                        if (Math.random() < maskPower * maskPower * virus.getTouchSpreadProbabilityWhenNotIll()) {
                            setVirusCarried(true);
                        }
                    }
                    else if (this.isMaskWore() || other.isMaskWore()) {
                        if (Math.random() < maskPower * virus.getTouchSpreadProbabilityWhenNotIll()) {
                            setVirusCarried(true);
                        }
                    }
                    else {
                        if (Math.random() < virus.getTouchSpreadProbabilityWhenNotIll()) {
                            setVirusCarried(true);
                        }
                    }
                }
            } else {
                //Other student get virus by chance.
                if (this.ill) {
                    if (this.isMaskWore() && other.isMaskWore()) {
                        if (Math.random() < maskPower * maskPower * virus.getTouchSpreadProbabilityWhenIll()) {
                            other.setVirusCarried(true);
                        }
                    }
                    else if (this.isMaskWore() || other.isMaskWore()) {
                        if (Math.random() < maskPower * virus.getTouchSpreadProbabilityWhenIll()) {
                            other.setVirusCarried(true);
                        }
                    }
                    else {
                        if (Math.random() < virus.getTouchSpreadProbabilityWhenIll()) {
                            other.setVirusCarried(true);
                        }
                    }
                }
                else {
                    if (this.isMaskWore() && other.isMaskWore()) {
                        if (Math.random() < maskPower * maskPower * virus.getTouchSpreadProbabilityWhenNotIll()) {
                            other.setVirusCarried(true);
                        }
                    } else if (this.isMaskWore() || other.isMaskWore()) {
                        if (Math.random() < maskPower * virus.getTouchSpreadProbabilityWhenNotIll()) {
                            other.setVirusCarried(true);
                        }
                    } else {
                        if (Math.random() < virus.getTouchSpreadProbabilityWhenNotIll()) {
                            other.setVirusCarried(true);
                        }
                    }
                }
            }
        }
    }
}
