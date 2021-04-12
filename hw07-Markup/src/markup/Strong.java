package markup;

import java.util.List;

public class Strong extends AbstractElement implements AllowedInParagraph {
    public Strong(List<AllowedInParagraph> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[b]";
    }

    @Override
    protected String getCloseBBCodeTag() {
        return "[/b]";
    }

    @Override
    protected String getMarkdownTag() {
        return "__";
    }
}
