package org.quantumbadger.redreader.test.reddit.prepared;

import org.junit.Before;
import org.junit.Test;
import org.quantumbadger.redreader.reddit.prepared.RedditParsedComment;
import org.quantumbadger.redreader.reddit.prepared.markdown.MarkdownParagraphGroup;
import org.quantumbadger.redreader.reddit.prepared.markdown.MarkdownParser;
import org.quantumbadger.redreader.reddit.things.RedditComment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParsedCommentTest {

	// stub constants
	private static final String fake_string = "#fake comment title\n>fake comment quoted body.";
	private static final String FAKE_ID = "fake_id";
	private static final String FAKE_AND_TYPE = FAKE_ID + "_and_type";
	private static final String FAKE_COMMENT_AUTHOR_FLAIR = "fake_comment_author_flair";


	private RedditComment mockComment = mock(RedditComment.class);
	private RedditParsedComment redditParsedComment;

	@Before
	public void prepare() {
		when(mockComment.getBody()).thenReturn(fake_string);
		when(mockComment.getIdAndType()).thenReturn(FAKE_AND_TYPE);
		when(mockComment.getIdAlone()).thenReturn(FAKE_ID);
		when(mockComment.getAuthor_flair_text()).thenReturn(FAKE_COMMENT_AUTHOR_FLAIR);
		redditParsedComment = new RedditParsedComment(mockComment);
	}

	@Test
	public void testParsedCommentBodyTypes(){
		final MarkdownParser.MarkdownParagraphType
				FIRST_TYPE = MarkdownParser.MarkdownParagraphType.HEADER,
				SECOND_TYPE = MarkdownParser.MarkdownParagraphType.QUOTE;

		MarkdownParagraphGroup result = MarkdownParser.parse(fake_string.toCharArray());
		assertEquals(2, result.getParagraphs().length);
		assertEquals(FIRST_TYPE, result.getParagraphs()[0].getType());
		assertEquals(SECOND_TYPE, result.getParagraphs()[1].getType());
	}

	@Test
	public void testParsedCommentBodyRaws(){
		final String FIRST_RAW = "fake comment title";
		final String SECOND_RAW = "fake comment quoted body.";

		MarkdownParagraphGroup result = MarkdownParser.parse(fake_string.toCharArray());
		assertEquals(2, result.getParagraphs().length);
		if(2 == result.getParagraphs().length) {
			assertEquals(FIRST_RAW, result.getParagraphs()[0].getRaw().toString());
			assertEquals(SECOND_RAW, result.getParagraphs()[1].getRaw().toString());
		} else {
			assert(false);
		}
	}

	@Test
	public void testParsedCommentId(){
		assertEquals(redditParsedComment.getIdAlone(), FAKE_ID);
	}

	@Test
	public void testParsedCommentIdAndType(){
		assertEquals(redditParsedComment.getIdAndType(), FAKE_AND_TYPE);
	}

	@Test
	public void testParsedCommentAuthFlairText() {
		assertEquals(redditParsedComment.getFlair(), FAKE_COMMENT_AUTHOR_FLAIR);
	}
}
