package markup;

import java.util.List;

public class Paragraph extends AbstractElement implements AllowedInListItem {
    public Paragraph(List<AllowedInParagraph> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "";
    }

    @Override
    protected String getCloseBBCodeTag() {
        return "";
    }

    @Override
    protected String getMarkdownTag() {
        return "";
    }
}
