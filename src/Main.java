import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int command = -1;
        int day = 0;
        School school = new School();

        while (true) {
            System.out.println("简易瘟疫模拟器，要做什么？");
            System.out.println("1: 运行学校一天");
            System.out.println("2: 运行学校10天");
            System.out.println("3: 将病毒放在随机学生身上");
            System.out.println("4: 查看全部学生状况");
            System.out.println("5: 要求所有学生戴口罩");
            System.out.println("6: 禁止学生戴口罩");
            System.out.println("7: 用神的力量治好所有人并消毒");
            System.out.println("8: 重设天数");
            System.out.println("9: 设置发病后几天隔离");
            System.out.println("10: 设置病毒参数");
            System.out.println("11: 更改口罩强度");
            System.out.println("12: 退出");
            System.out.print("输入指令:");

            while (true) {
                try {
                    command = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("指令错误，再输入一次:");
                    input.nextLine();
                }
            }

            switch (command) {
                case 1:
                    school.runADay();
                    day++;
                    System.out.println("当前天数：" + day);
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        school.runADay();
                        day++;
                        System.out.println("当前天数：" + day);
                        System.out.println();
                        try { Thread.sleep(200); } catch (Exception e) {}
                    }
                    break;
                case 3:
                    school.setVirusRandomly();
                    System.out.println("放置成功！");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 4:
                    school.printCarrierCount();
                    school.printIllCount();
                    school.printQuarantineCount();
                    System.out.println();
                    try { Thread.sleep(2000); } catch (Exception e) {}
                    break;
                case 5:
                    school.setMasks();
                    System.out.println("添加口罩成功！");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 6:
                    school.removeMasks();
                    System.out.println("移除口罩成功！");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 7:
                    school.cureAll();
                    System.out.println("治愈成功！");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 8:
                    day = 0;
                    System.out.println("重设天数成功！");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 9:
                    System.out.println("当前为发病后" + school.getDaysBeforeQuarantine() + "天隔离。");
                    System.out.print("请设置一个新天数：");
                    while (true) {
                        try {
                            school.setDaysBeforeQuarantine(input.nextInt());
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.print("输入数据类型错误，再试一次：");
                            input.nextLine();
                        }
                    }
                    System.out.println("设置成功！当前为发病后" + school.getDaysBeforeQuarantine() + "天隔离。");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 10:
                    System.out.println("当前病毒参数如下：\n潜伏期单次接触传播率：" + Virus.getTouchSpreadProbabilityWhenNotIll());
                    System.out.println("发病期单次接触传播率：" + Virus.getTouchSpreadProbabilityWhenIll());
                    System.out.println("最小潜伏期（天）：" + Virus.getMinDaysBeforeIll());
                    System.out.println("最大潜伏期（天）：" + Virus.getMaxDaysBeforeIll());
                    System.out.print("请按以上顺序输入新参数：");
                    while (true) {
                        try {
                            Virus.setTouchSpreadProbabilityWhenNotIll(input.nextDouble());
                            Virus.setTouchSpreadProbabilityWhenIll(input.nextDouble());
                            Virus.setMinDaysBeforeIll(input.nextInt());
                            Virus.setMaxDaysBeforeIll(input.nextInt());
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.print("输入数据类型错误，再试一次：");
                            input.nextLine();
                        }
                    }
                    System.out.println("新的病毒参数如下：\n潜伏期单次接触传播率：" + Virus.getTouchSpreadProbabilityWhenNotIll());
                    System.out.println("发病期单次接触传播率：" + Virus.getTouchSpreadProbabilityWhenIll());
                    System.out.println("最小潜伏期（天）：" + Virus.getMinDaysBeforeIll());
                    System.out.println("最大潜伏期（天）：" + Virus.getMaxDaysBeforeIll());
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 11:
                    System.out.println("当前口罩能以" + school.getMaskPower() + "的强度降低传染率。");
                    System.out.print("请设置一个新强度：");
                    while (true) {
                        try {
                            school.setMaskPower(input.nextDouble());
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.print("输入数据类型错误，再试一次：");
                            input.nextLine();
                        }
                    }
                    System.out.println("设置成功！当前口罩能以" + school.getMaskPower() + "的强度降低传染率。");
                    System.out.println();
                    try { Thread.sleep(1000); } catch (Exception e) {}
                    break;
                case 12:
                    System.out.println("再见");
                    System.exit(0);
            }
        }
    }
}
