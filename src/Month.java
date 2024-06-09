public class Month {
    private String nameOfMonth;
    private int lenthOfMonth = 31;

    public void SetLenthOfMonth(int len){
        this.lenthOfMonth = len;
    }
    public int GetlenthOfMonth(){
        return lenthOfMonth;
    }

    private Day[] days = new Day[lenthOfMonth];

    public void SetNameOfMonth(String name){
        this.nameOfMonth = name;
    }
    public String GetNameOfMonth(){
        return nameOfMonth;
    }
    public void SetDays(Day[] days){
        this.days = days.clone();
    }
    public Day[] GetDays(){
        return days;
    }
}
