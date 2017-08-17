package wordchain.algorithm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Ja on 2017-08-14.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        WordListReaderTest.class,
        GraphBuilderTest.class,
        MetricsCalculatorTest.class,
        BFSProcessorTest.class,
        WordConnectorE2ETest.class})
public class TestSuite {}