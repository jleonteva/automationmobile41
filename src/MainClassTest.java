import org.junit.Test;

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
}
