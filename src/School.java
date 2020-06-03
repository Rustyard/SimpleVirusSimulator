public class School {
    private int studentCount = 500;
    private Student[] students = new Student[studentCount];
    private int daysBeforeQuarantine = 3;
    private double maskPower;

    /**
     * 初始化学校及学生
     */
    public School() {
        for (int i = 0; i < studentCount; i++) {
            students[i] = new Student();
        }
    }

    //get&set方法

    /**
     * 获取学生数
     * @return 学生数
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * 获取发病后隔离前经过的天数
     * @return 发病后隔离前经过的天数
     */
    public int getDaysBeforeQuarantine() {
        return daysBeforeQuarantine;
    }

    /**
     * 设定发病后隔离前经过的天数
     * @param daysBeforeQuarantine 发病后隔离前经过的天数
     */
    public void setDaysBeforeQuarantine(int daysBeforeQuarantine) {
        this.daysBeforeQuarantine = daysBeforeQuarantine;
    }

    /**
     * 获取口罩强度
     * @return 口罩强度
     */
    public double getMaskPower() {
        return students[0].getMaskPower();
    }

    /**
     * 修改所有学生的口罩强度。
     * @param maskPower 指定的口罩强度。
     */
    public void setMaskPower(double maskPower) {
        this.maskPower = maskPower;
        for (int i = 0; i < studentCount; i++) {
            students[i].setMaskPower(this.maskPower);
        }
    }

    /**
     * 随机放病毒在学生身上。
     */
    public void setVirusRandomly() {
        int stu = (int) (Math.random() * studentCount);
        students[stu].setVirusCarried(true);
    }

    /**
     * 治好所有学生并消毒。
     */
    public void cureAll() {
        for (int i = 0; i < studentCount; i++) {
            students[i].setQuarantine(false);
            students[i].setIll(false);
            students[i].setVirusCarried(false);
            students[i].setDays(0);
            students[i].setDaysBeforeIll(Integer.MAX_VALUE);
        }
    }

    /**
     * 让每个学生戴口罩。
     */
    public void setMasks() {
        for (int i = 0; i < studentCount; i++) {
            students[i].setMaskWore(true);
        }
    }

    /**
     * 拿掉所有学生的口罩。
     */
    public void removeMasks() {
        for (int i = 0; i < studentCount; i++) {
            students[i].setMaskWore(false);
        }
    }

    /**
     * 显示发病人数。
     */
    public void printIllCount() {
        int count = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].isIll()) {
                count++;
            }
        }
        System.out.println("发病学生数: " + count);
    }

    /**
     * 显示携带病毒人数。
     */
    public void printCarrierCount() {
        int count = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].isVirusCarried()) {
                count++;
            }
        }
        System.out.println("携带者数: " + count);
    }

    /**
     * 显示隔离人数。
     */
    public void printQuarantineCount() {
        int count = 0;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].isQuarantine()) {
                count++;
            }
        }
        System.out.println("隔离数: " + count);
    }

    /**
     * 模拟经过学校里的一天，随机接触的次数等于学生总数，发病数天后隔离，并显示学生情况。
     */
    public void runADay() {
        //Touching.
        int stu1, stu2;
        for (int i = 0; i < 100; i++) {
            stu1 = (int) (Math.random() * studentCount);
            stu2 = (int) (Math.random() * studentCount);
            while (stu1 == stu2) {
                stu2 = (int) (Math.random() * studentCount);
            }
            students[stu1].touchWith(students[stu2]);
        }

        //Set dayCounter for each student.
        for (int i = 0; i < studentCount; i++) {
            students[i].setDays(students[i].getDays() + 1);
        }

        //Set ill.
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getDays() == students[i].getDaysBeforeIll()) {
                students[i].setIll(true);
            }
        }

        //Set quarantine.
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getDays() == students[i].getDaysBeforeIll() + daysBeforeQuarantine) {
                students[i].setQuarantine(true);
            }
        }

        //Show info of students.
        printCarrierCount();
        printIllCount();
        printQuarantineCount();
    }
}
