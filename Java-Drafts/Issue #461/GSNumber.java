
public class GSNumber {

    public String gsNum;

    public String setGSNum(String gsNumber) {
        StringBuilder gsBuilder = new StringBuilder();

        while (gsBuilder.length() < (9 - gsNumber.length())) {
            gsBuilder.append('0');
        }

        for (int i = 0; i < gsNumber.length(); i++) {
            gsBuilder.append(gsNumber.charAt(i));
        }

        this.gsNum = gsBuilder.toString();
        return this.gsNum;
    }

    public static void main(String[] args) {
        GSNumber gsTest = new GSNumber();

        gsTest.setGSNum("1993");
    }
}
