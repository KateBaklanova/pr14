import java.util.regex.*;



public class stroka {


    void method1()
    {
        Pattern p3 = Pattern.compile("\\d+\\s?");
        String[] words = p3.split("java5tiger 77 java6mustang");
        for (String word : words) {
            System.out.println(word);
        }
    }

    void method2()
    {
        String regexp = "abcdefghijklmnopqrstuv18340";
        String s1 = "abcdefghijklmnopqrstuv18340";

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(s1);
        if(matcher.matches())
        {
            System.out.println("yes");

        }
        else
        {
            System.out.println("no");
        }
    }

    void method3(String s)
    {
        // поиск и выбор подстроки, заданной шаблоном
        String regex = "(((\\d)+([.])+(\\d)+)+\sUSD|\\d*[.]?\\d*\sRUS)";
        Pattern p2 = Pattern. compile (regex);
        Matcher m2 = p2.matcher(s);
        while (m2.find()) {
            System.out.println(m2.group());
        }
    }

    void method6(String s)
    {
        String regex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*" ;
        // String s = "адреса эл.почты: mymail@tut.by и rom@bsu.by";
        Pattern p2 = Pattern. compile (regex);
        Matcher m2 = p2.matcher(s);
        boolean flag=true;
        while (m2.find()) {
            System.out.println("e-mail: " + m2.group());
            flag = false;
        }
        if (flag)
        {
            System.out.println("e-mail не соответствует требованиям");
        }
    }

    void method5(String s)
    {
        Pattern p5 = Pattern.compile("^(0[1-9]|[12]\\d|3[01])/([0][1-9]|1[0-2])/((?:1[6-9]|[2-9]\\d)\\d{2})$");
        Matcher m5 = p5.matcher(s);
        if (m5.matches()) {
            int day = Integer.parseInt(m5.group(1));
            int month = Integer.parseInt(m5.group(2));
            int year = Integer.parseInt(m5.group(3));
            if (month==2 && year%4==0 && day<=29) {
                System.out.println("right");
            }
            else if(month==2 && year%4!=0 && day>=29) {

                System.out.println("wrong");
            }
            else if(month==2 && year%4!=0 && day<29) {

                System.out.println("right");
            }
            else if(month==4||month==6||month==9||month==11)
            {
                if (day<31)
                {
                    System.out.println("right");
                }
                else
                {
                    System.out.println("wrong");
                }
            }
            else
            {
                if (day<32)
                {
                    System.out.println("right");
                }
                else
                {
                    System.out.println("wrong");
                }
            }
        }
        else
        {

            System.out.println("wrong");
        }
    }

    public static void main(String[] args) {
// проверка на соответствие строки шаблону
            stroka s = new stroka();
            s.method2();
            s.method1();
        String s1 = "Цены 30.06 USD 50.30 RUS 60.12 11,23 USD" ;
        s.method3(s1);
        s.method5(("29/02/2000"));
        s.method5(("30/04/2003"));
        s.method5(("01/01/2003"));
        s.method5(("29/02/2001"));
        s.method5(("30-04-2003"));
        s.method5(("1/1/1899"));

        s.method6("user@example.com, root@localhost");

        s.method6("myhost@@@com.ru");

        s.method6("@my.ru");

        s.method6("Julia String");
        }
    }
