package at.porscheinformatik.tapestry.csrfprotection.tests.auto;

import java.util.HashMap;
import java.util.Map;

import at.porscheinformatik.tapestry.csrfprotection.util.PageTesterUtils;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Simulated CSRF attack that should be detected.
 */
public class FormAttackTest extends Assert
{
    @Test
    public void testFormAttack()
    {
        PageTester tester = PageTesterUtils.autoModePageTester();

        org.apache.tapestry5.dom.Document doc = tester.renderPage("FormAttack");
        Element form = doc.getElementById("messageForm");
        Map<String, String> test = new HashMap<String, String>();
        test.put("message", "updatedMessage");
        doc = tester.submitForm(form, test);
        assertTrue(doc.toString().contains("CSRF Attack detected"));
    }
}
