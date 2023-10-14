import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Seasons seasons = Seasons.ВЕСНА;
        String input;
        while(true){
            System.out.println("Угадайте");
            input = scan.nextLine();
            if (input.equals(seasons.getName())){
                System.out.println("МОЛОДЕЦ УГАДАЛ");
                break;
            }
            if (input.equals("end")){
                System.out.println("сдался значит да?");
                break;
            }
            else System.out.println("Попробуйте угадать еще раз");
        }
        System.out.println("До свидания");
    }
}
enum Seasons{
    ЗИМА("Зима"),
    ВЕСНА("Весна"),
    ЛЕТО("Лето"),
    ОСЕНЬ("Осень");
    String name;
    Seasons(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}