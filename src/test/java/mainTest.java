import com.sun.tools.javac.Main;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class mainTest {
@Test
@Timeout(value = 22, unit = TimeUnit.SECONDS)
    public void mainTest() throws Exception {
    Main.main(null);
}
}
