package markup;

import java.util.List;

public class Strikeout extends AbstractElement implements AllowedInParagraph {
    public Strikeout(List<AllowedInParagraph> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[s]";
    }

    @Override
    protected String getCloseBBCodeTag() {
        return "[/s]";
    }

    @Override
    protected String getMarkdownTag() {
        return "~";
    }
}
