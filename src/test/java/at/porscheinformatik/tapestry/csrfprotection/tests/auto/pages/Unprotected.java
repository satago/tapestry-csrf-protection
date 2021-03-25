package at.porscheinformatik.tapestry.csrfprotection.tests.auto.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.EventLink;
import at.porscheinformatik.tapestry.csrfprotection.NotCsrfProtected;
import at.porscheinformatik.tapestry.csrfprotection.util.TestBean;

/**
 * Unprotected page, containing an ActionLink and EventLink component.
 */
@NotCsrfProtected
public class Unprotected
{
    @Property
    @Persist
    private TestBean testBean;

    @Component(parameters = {"event=event"})
    private EventLink eventlink1, eventlink2;

    void onAction()
    {
        testBean.setTestProperty("onAction!");
    }

    void onEvent()
    {
        testBean.setTestProperty("onEvent!");
    }

    void onActivate()
    {
        if (testBean == null)
        {
            testBean = new TestBean();
        }
    }
}
