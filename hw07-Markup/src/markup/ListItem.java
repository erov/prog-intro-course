package markup;

import java.util.List;

public class ListItem extends AbstractElement {
    public ListItem(List<AllowedInListItem> items) {
        super(items);
    }

    @Override
    protected String getOpenBBCodeTag() {
        return "[*]";
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
