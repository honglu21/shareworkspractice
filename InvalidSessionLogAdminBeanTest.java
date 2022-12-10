package com.solium.common.account.ejb;

import com.solium.common.accesslog.ejb.AccessLogSessionPK;
import com.solium.common.ejb.admin.uniqueid.UniqueIDAdminLocal;
import com.solium.lib.core.date.Instant;
import com.solium.lib.sql.sqlrunner.SqlRunner;
import com.solium.test.helpers.ObjectMother;
import com.solium.test.lib.SoliumTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

public class InvalidSessionLogAdminBeanTest extends SoliumTestCase {
    private static final Instant NOW = Instant.ofEpochSecond(1611083246);

    private static long _invalidSessionId = ObjectMother.generateUniqueID();
    private static final InvalidSessionLogPK INVALID_SESSION_LOG_PK = InvalidSessionLogPK.of(_invalidSessionId);
    private static final AccessLogSessionPK SESSION_PK = AccessLogSessionPK.of(2L);
    private static final AccountPK ACCOUNT_PK = AccountPK.of(3L);

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

    @Mock
    private UniqueIDAdminLocal _uniqueIDAdmin;

    private InvalidSessionLogAdminBean _invalidSessionLogAdminBean;

    @Before
    public void setUp() throws Exception {
	_invalidSessionLogAdminBean = getInvalidSessionLogAdminBean();
	_invalidSessionLogAdminBean._mockSqlRunnerForTesting = mock(SqlRunner.class);
	doReturn(_invalidSessionId)
		.when(_invalidSessionLogAdminBean.getUniqueIDAdmin())
		.createUniqueId();
    }

    private InvalidSessionLogAdminBean getInvalidSessionLogAdminBean() {
	return new InvalidSessionLogAdminBean() {
	    @Override
	    public UniqueIDAdminLocal getUniqueIDAdmin() {
		return _uniqueIDAdmin;
	    }
	};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertInvalidSession_withValidParameters_ShouldInvokeInsert() throws Exception {
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sql(anyString())).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sqlParam(INVALID_SESSION_LOG_PK)).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sqlParam(SESSION_PK)).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sqlParam(ACCOUNT_PK)).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sqlParam(any(Instant.class))).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);

	_invalidSessionLogAdminBean.insertInvalidSession(SESSION_PK, ACCOUNT_PK);
	verify(_invalidSessionLogAdminBean._mockSqlRunnerForTesting, times(10)).sql(anyString());
	verify(_invalidSessionLogAdminBean._mockSqlRunnerForTesting, times(1)).sqlParam(any(InvalidSessionLogPK.class));
	verify(_invalidSessionLogAdminBean._mockSqlRunnerForTesting, times(1)).sqlParam(any(AccessLogSessionPK.class));
	verify(_invalidSessionLogAdminBean._mockSqlRunnerForTesting, times(1)).sqlParam(any(AccountPK.class));
	verify(_invalidSessionLogAdminBean._mockSqlRunnerForTesting, times(1)).sqlParam(any(Instant.class));
    }

    @Test
    public void isSessionInvalid_withInvalidSessionId_ShouldReturnTrue() {
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sql(anyString())).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.quickSelectOneBoolean()).thenReturn(Boolean.TRUE);
	assertEquals(true, _invalidSessionLogAdminBean.isSessionInvalid(SESSION_PK));
    }

    @Test
    public void isSessionInvalid_withInvalidSessionId_ShouldReturnFalse() {
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.sql(anyString())).thenReturn(_invalidSessionLogAdminBean._mockSqlRunnerForTesting);
	when(_invalidSessionLogAdminBean._mockSqlRunnerForTesting.quickSelectOneBoolean()).thenReturn(Boolean.FALSE);
	assertEquals(false, _invalidSessionLogAdminBean.isSessionInvalid(SESSION_PK));
    }
}