import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParametrizedLionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private String sex;
    private boolean expextedHasMane;

    @Mock
    Feline feline;

    public ParametrizedLionTest(String sex, boolean expextedHasMane) {
        this.sex = sex;
        this.expextedHasMane = expextedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeParametrizedTest() throws Exception{
        Lion lion = new Lion(sex, feline);
        assertEquals(expextedHasMane, lion.doesHaveMane());
    }

}
