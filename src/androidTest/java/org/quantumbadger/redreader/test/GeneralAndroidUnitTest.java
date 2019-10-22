package org.quantumbadger.redreader.test;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quantumbadger.redreader.R;
import org.quantumbadger.redreader.common.General;
import org.quantumbadger.redreader.common.RRError;
import org.quantumbadger.redreader.reddit.APIResponseHandler;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class GeneralAndroidUnitTest {

	private Context context;

	@Before
	public void getActualContext() {
		context = InstrumentationRegistry.getTargetContext();
	}

	@Test
	public void testInvalidUserError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.ALREADY_SUBMITTED);
		assertEquals(error.title, context.getString(R.string.error_already_submitted_title));
		assertEquals(error.message, context.getString(R.string.error_already_submitted_message));
	}

	@Test
	public void testBadCAPTCHAError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.BAD_CAPTCHA);
		assertEquals(error.title, context.getString(R.string.error_bad_captcha_title));
		assertEquals(error.message, context.getString(R.string.error_bad_captcha_message));
	}

	@Test
	public void testNotAllowedError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.NOTALLOWED);
		assertEquals(error.title, context.getString(R.string.error_403_title));
		assertEquals(error.message, context.getString(R.string.error_403_message));
	}

	@Test
	public void testSubreditRequiredError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.SUBREDDIT_REQUIRED);
		assertEquals(error.title, context.getString(R.string.error_subreddit_required_title));
		assertEquals(error.message, context.getString(R.string.error_subreddit_required_message));
	}

	@Test
	public void testURLRequiredError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.URL_REQUIRED);
		assertEquals(error.title, context.getString(R.string.error_url_required_title));
		assertEquals(error.message, context.getString(R.string.error_url_required_message));
	}

	@Test
	public void testUnknownError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.UNKNOWN);
		assertEquals(error.title, context.getString(R.string.error_unknown_api_title));
		assertEquals(error.message, context.getString(R.string.error_unknown_api_message));
	}

	@Test
	public void testTooFastError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.TOO_FAST);
		assertEquals(error.title, context.getString(R.string.error_too_fast_title));
		assertEquals(error.message, context.getString(R.string.error_too_fast_message));
	}

	public void testTooLongError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.TOO_LONG);
		assertEquals(error.title, context.getString(R.string.error_too_long_title));
		assertEquals(error.message, context.getString(R.string.error_too_long_message));

	}

	public void testAlreadySubmittedError() {
		RRError error = General.getGeneralErrorForFailure(context, APIResponseHandler.APIFailureType.ALREADY_SUBMITTED);
		assertEquals(error.title, context.getString(R.string.error_already_submitted_title));
		assertEquals(error.message, context.getString(R.string.error_already_submitted_message));

	}
}
