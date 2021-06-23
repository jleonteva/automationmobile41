import org.junit.Assert;
import org.junit.Test;
import java.lang.String;

public class MainClassTest extends MainClass
{

    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber(14);
        if (a == 14) {
            System.out.println("Ура! Вернул число"+ ' '+ a);
        } else {
            System.out.println("Ошибка! Не вернул число 14");
        }

    }
    @Test
    public void testGetClassNumber()
    {
        int b = getClassNumber(45);
        if (b > 45) {
            System.out.println("Проверка удачная");
        } else {
            System.out.println("Ошибка! Тест провален.Вернул значение" + b);
        }
    }
    @Test
    public void testGetClassString()
    {
        String subStr1 = "hello";
        String subStr2 = "Hello";
        String str = getClassString();
        if (str.contains(subStr1)) {
            System.out.println("Строка" + str + "содержит подстроку" + subStr1);
        } else if (str.contains(subStr2)) {
            System.out.println("Строка" + str + "содержит подстроку" + subStr2);
        } else {
            Assert.fail("Строка" + str + "не содержит подстроку" + subStr1 + subStr2);
        }

    }
}
