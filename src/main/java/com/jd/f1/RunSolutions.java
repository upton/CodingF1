package com.jd.f1;

/**
 * 运行solution的类
 * 
 * @author chenzehong
 * 
 */
public class RunSolutions {
    private int runNum = 10;
    private int runTimes = 1;
    private String title;

    private final static String ERR_STRING = "***Author:[%s] Solution:[%s], run incorrect with input[%s] expect[%s] but result[%s]";
    private final static String TIME_TITLE = "|------Author----|----------------Solution---------|--------Output-|------nanosecond-|--microsecond-|--millisecond-|";
    private final static String TIME_STRIN = "|%15s |%32s |%14s |%16s |%13s |%13s |";
    private final static String TIME_BUTTO = "|----------------|---------------------------------|---------------|-----------------|--------------|--------------|";

    public RunSolutions(String title) {
        this.title = title;
    }

    public RunSolutions(String title, int runNum) {
        this.title = title;
        this.runNum = runNum;
    }

    public RunSolutions(String title, int runNum, int runTimes) {
        this.title = title;
        this.runNum = runNum;
        this.runTimes = runTimes;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void runAllSolutions(String[] classess, Object[] checkCorrectInputs, Object[] checkCorrectExpects, Object runTimInput) {
        System.out
                .println("********************************************************************************************************************");
        System.out.println("*********************************************** The " + String.format("%4s", title)
                + " Coding F1 *************************************************");
        System.out.println("*********************************************** INPUT[" + (String.format("%11s", runTimInput))
                + "] *************************************************");
        System.out
                .println("********************************************************************************************************************");
        System.out.println(TIME_TITLE);

        for (String clazzStr : classess) {
            try {
                Class clazz = Class.forName(clazzStr);
                Solution s = (Solution) clazz.newInstance();
                boolean checkResult = true;
                for (int i = 0; i < checkCorrectInputs.length; i++) {
                    try {
                        Object result = s.run(checkCorrectInputs[i]);
                        if (!checkCorrectExpects[i].equals(result)) {
                            System.out.println(String.format(ERR_STRING, s.getAuthor(), clazzStr, checkCorrectInputs[i],
                                    checkCorrectExpects[i], result));
                            checkResult = false;
                            break;
                        }
                    } catch (Exception ex) {
                        Exception e = new Exception("checkCorrectInput=" + checkCorrectInputs[i], ex);
                        e.printStackTrace();
                    }
                }

                if (checkResult) {
                    long allNanoTime = 0L;
                    Result result = null;
                    for (int n = 0; n < runNum; n++) {
                        result = runTime(s, runTimInput);
                        allNanoTime += result.time;
                    }

                    long nanosecond = allNanoTime / runNum;
                    long microsecond = nanosecond / 1000L;
                    long millisecond = microsecond / 1000L;

                    System.out.println(String.format(TIME_STRIN, s.getAuthor(), clazzStr, result.res, String.valueOf(nanosecond),
                            String.valueOf(microsecond), String.valueOf(millisecond)));
                    System.out.println(TIME_BUTTO);
                }

                // reset to next solution
                checkResult = true;
            } catch (Exception ex) {
                Exception e = new Exception("runTimInput=" + runTimInput, ex);
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Result runTime(Solution solution, Object input) {
        long start = System.nanoTime();
        
        Object res = null;
        for (int i = 0; i < runTimes; i++) {
            res = solution.run(input);
        }
        
        long end = System.nanoTime();

        Result r = new Result();
        r.time = end - start;
        r.res = res.toString();
        return r;
    }
}

class Result {
    public long time = 0L;
    public String res = "";
}