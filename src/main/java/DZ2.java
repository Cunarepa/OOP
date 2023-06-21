import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DZ2 {
    public static void main(String[] args) {

        String requestStart = "select * from students";
        String jsonStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String emptyValue = "null";
        boolean whereStrUsed = false;
        StringBuilder sqlString = new StringBuilder(requestStart);
        jsonStr = jsonStr.trim().replaceAll("^\\{|}$", "");
        for (String element : jsonStr.split(",")) {
            Pattern regexpPat = Pattern.compile("\"(.*)\":\"(.*)\"");
            Matcher items = regexpPat.matcher(element.trim());
            if (items.matches()) {
                String key = items.group(1);
                String val = items.group(2);
                if (!val.equals(emptyValue)) {
                    if (whereStrUsed) {
                        sqlString.append(String.format(" and %s='%s'", key, val));
                    } else {
                        sqlString.append(" where");
                        whereStrUsed = true;
                        sqlString.append(String.format(" %s='%s'", key, val));
                    }
                }
            }
        }
        System.out.println(sqlString);
    }
}