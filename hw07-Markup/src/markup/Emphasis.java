package markup;

import java.util.List;

public class Emphasis extends AbstractElement implements AllowedInParagraph {
    public Emphasis(List<AllowedInParagraph> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[i]";
    }

    @Override
    protected String getCloseBBCodeTag() {
        return "[/i]";
    }

    @Override
    protected String getMarkdownTag() {
        return "*";
    }
}
