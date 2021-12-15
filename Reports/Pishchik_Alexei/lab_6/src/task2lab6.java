public class task2lab6 {
    public static void main(String[] args) {
        DigitalClock clock = new DialToDigital(new DialWatch(300, 180));
        clock.showTime();
    }
}

interface DigitalClock {
    void showTime();
}

class DigitalWatch implements DigitalClock {
    private Integer hours;
    private Integer minutes;

    DigitalWatch(Integer hours, Integer minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public void showTime() {
        if (minutes >= 10)
            System.out.println(hours.toString() + ":" + minutes.toString());
        else
            System.out.println(hours.toString() + ":0" + minutes.toString());
    }
}

class DialWatch {
    private Integer hoursDegrees;
    private Integer minutesDegrees;

    DialWatch(Integer hoursDegrees, Integer minutesDegrees) {
        this.hoursDegrees = hoursDegrees;
        this.minutesDegrees = minutesDegrees;
    }

    public Integer getHoursDegrees() {
        return hoursDegrees;
    }

    public Integer getMinutesDegrees() {
        return minutesDegrees;
    }
}

class DialToDigital implements DigitalClock {
    private DialWatch dialWatch;

    DialToDigital(DialWatch dialWatch) {
        this.dialWatch = dialWatch;
    }

    @Override
    public void showTime() {
        if (dialWatch.getHoursDegrees() >= 30 && dialWatch.getMinutesDegrees() != 360) {
            DigitalClock digitalWatch = new DigitalWatch(dialWatch.getHoursDegrees() / 30, dialWatch.getMinutesDegrees() / 6);
            digitalWatch.showTime();
        } else if (dialWatch.getMinutesDegrees() == 360) {
            DigitalClock digitalWatch = new DigitalWatch(dialWatch.getHoursDegrees() / 30 + 1, 0);
            digitalWatch.showTime();
        } else {
            DigitalClock digitalWatch = new DigitalWatch(12, dialWatch.getMinutesDegrees() / 6);
            digitalWatch.showTime();
        }
    }
}



